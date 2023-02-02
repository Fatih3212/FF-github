
package net.mcreator.testone.entity;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class GhastBossREDEntity extends TestoneElements.ModElement {
	public static EntityType entity = null;
	@ObjectHolder("testone:entitybulletghastbossred")
	public static final EntityType arrow = null;
	public GhastBossREDEntity(TestoneElements instance) {
		super(instance, 66);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(4f, 4f))
						.build("ghastbossred").setRegistryName("ghastbossred");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65536, -16777216, new Item.Properties().group(ModesyalariItemGroup.tab))
				.setRegistryName("ghastbossred"));
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletghastbossred").setRegistryName("entitybulletghastbossred"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223315_a);
		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("testone:textures/ghast.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(ArrowCustomEntity.class, renderManager -> {
			return new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer());
		});
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 4800;
			setNoAI(false);
			setCustomName(new StringTextComponent("RED HELL"));
			setCustomNameVisible(true);
			this.moveController = new FlyingMovementController(this);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(5, new PanicGoal(this, 1.2));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50);
			this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, this, this.world);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			world.addEntity(entityarrow);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}
	}

	public static class Modelcustom_model extends EntityModel {
		private final RendererModel body;
		private final RendererModel tentacle1;
		private final RendererModel tentacle2;
		private final RendererModel tentacle3;
		private final RendererModel tentacle4;
		private final RendererModel tentacle5;
		private final RendererModel tentacle6;
		private final RendererModel tentacle7;
		private final RendererModel tentacle8;
		private final RendererModel tentacle9;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 32;
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 4.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F, false));
			tentacle1 = new RendererModel(this);
			tentacle1.setRotationPoint(-3.7F, 11.0F, -5.0F);
			tentacle1.cubeList.add(new ModelBox(tentacle1, 0, 0, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));
			tentacle2 = new RendererModel(this);
			tentacle2.setRotationPoint(1.3F, 11.0F, -5.0F);
			tentacle2.cubeList.add(new ModelBox(tentacle2, 0, 0, 4.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F, false));
			tentacle3 = new RendererModel(this);
			tentacle3.setRotationPoint(6.3F, 11.0F, -5.0F);
			tentacle3.cubeList.add(new ModelBox(tentacle3, 0, 0, -6.0F, 0.0F, -1.0F, 2, 13, 2, 0.0F, false));
			tentacle4 = new RendererModel(this);
			tentacle4.setRotationPoint(-6.3F, 11.0F, 0.0F);
			tentacle4.cubeList.add(new ModelBox(tentacle4, 0, 0, -1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F, false));
			tentacle5 = new RendererModel(this);
			tentacle5.setRotationPoint(-1.3F, 11.0F, 0.0F);
			tentacle5.cubeList.add(new ModelBox(tentacle5, 0, 0, -1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F, false));
			tentacle6 = new RendererModel(this);
			tentacle6.setRotationPoint(3.7F, 11.0F, 0.0F);
			tentacle6.cubeList.add(new ModelBox(tentacle6, 0, 0, -1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F, false));
			tentacle7 = new RendererModel(this);
			tentacle7.setRotationPoint(-3.7F, 11.0F, 5.0F);
			tentacle7.cubeList.add(new ModelBox(tentacle7, 0, 0, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
			tentacle8 = new RendererModel(this);
			tentacle8.setRotationPoint(1.3F, 11.0F, 5.0F);
			tentacle8.cubeList.add(new ModelBox(tentacle8, 0, 0, 4.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
			tentacle9 = new RendererModel(this);
			tentacle9.setRotationPoint(6.3F, 11.0F, 5.0F);
			tentacle9.cubeList.add(new ModelBox(tentacle9, 0, 0, -6.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			tentacle1.render(f5);
			tentacle2.render(f5);
			tentacle3.render(f5);
			tentacle4.render(f5);
			tentacle5.render(f5);
			tentacle6.render(f5);
			tentacle7.render(f5);
			tentacle8.render(f5);
			tentacle9.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}

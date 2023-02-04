
package net.mcreator.testone.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class TamableTurtleBossEntity extends TestoneElements.ModElement {
	public static EntityType entity = null;
	public TamableTurtleBossEntity(TestoneElements instance) {
		super(instance, 99);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(2f, 2f))
						.build("tamableturtleboss").setRegistryName("tamableturtleboss");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13434727, -52, new Item.Properties().group(ModesyalariItemGroup.tab))
				.setRegistryName("tamableturtleboss"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 3, 30));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223315_a);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new ModelBlueBossModel(), 2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("testone:textures/lueossexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			setCustomName(new StringTextComponent("TamableTurtleBoss"));
			setCustomNameVisible(true);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, EndermanEntity.class, true, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, true));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, true));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ZombiePigmanEntity.class, true, true));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, WitchEntity.class, true, true));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, true));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, true));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, WitherEntity.class, true, true));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, MagmaCubeEntity.class, true, true));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, DrownedEntity.class, true, true));
			this.targetSelector.addGoal(12, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(13, new PanicGoal(this, 1.2));
			this.goalSelector.addGoal(14, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(15, new RandomWalkingGoal(this, 0.8));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(50);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this);
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	public static class ModelBlueBossModel extends EntityModel {
		private final RendererModel bone;
		public ModelBlueBossModel() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new RendererModel(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 88, 40, 16.0F, -9.0F, -4.0F, 10, 8, 8, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -12.0F, -16.0F, 36, 8, 32, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 88, 56, -32.0F, -2.0F, 6.0F, 16, 2, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 92, -32.0F, -2.0F, -10.0F, 16, 2, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 76, 68, 8.0F, -4.0F, -28.0F, 5, 2, 16, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 80, 86, 8.0F, -4.0F, 12.0F, 5, 2, 16, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 40, -16.0F, -4.0F, -12.0F, 32, 4, 24, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 68, -14.0F, 0.0F, -10.0F, 28, 4, 20, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}

package net.mcreator.testone.procedures;

@TestoneElements.ModElement.Tag
public class YenidunyablokPortalTriggerUsedProcedure extends TestoneElements.ModElement {

	public YenidunyablokPortalTriggerUsedProcedure(TestoneElements instance) {
		super(instance, 20);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure YenidunyablokPortalTriggerUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (!entity.world.isRemote && entity instanceof ServerPlayerEntity) {
			DimensionType destinationType = DimensionType.OVERWORLD;

			ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) entity, true, "field_184851_cj");

			ServerWorld nextWorld = entity.getServer().getWorld(destinationType);

			((ServerPlayerEntity) entity).connection.sendPacket(new SChangeGameStatePacket(4, 0));

			((ServerPlayerEntity) entity).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
					nextWorld.getSpawnPoint().getZ(), entity.rotationYaw, entity.rotationPitch);

			((ServerPlayerEntity) entity).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) entity).abilities));
			for (EffectInstance effectinstance : ((ServerPlayerEntity) entity).getActivePotionEffects()) {
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlayEntityEffectPacket(entity.getEntityId(), effectinstance));
			}
			((ServerPlayerEntity) entity).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}

	}

}

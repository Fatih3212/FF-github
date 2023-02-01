package net.mcreator.testone.procedures;

@TestoneElements.ModElement.Tag
public class DarkingotarmorArmorBootsTickEventProcedure extends TestoneElements.ModElement {

	public DarkingotarmorArmorBootsTickEventProcedure(TestoneElements instance) {
		super(instance, 62);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DarkingotarmorArmorBootsTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (true);
			((PlayerEntity) entity).sendPlayerAbilities();
		}

	}

}

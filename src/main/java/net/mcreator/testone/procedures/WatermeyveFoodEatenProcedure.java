package net.mcreator.testone.procedures;

@TestoneElements.ModElement.Tag
public class WatermeyveFoodEatenProcedure extends TestoneElements.ModElement {

	public WatermeyveFoodEatenProcedure(TestoneElements instance) {
		super(instance, 74);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WatermeyveFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 50, (int) 3));

	}

}

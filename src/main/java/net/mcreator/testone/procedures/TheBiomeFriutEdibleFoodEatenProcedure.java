package net.mcreator.testone.procedures;

@TestoneElements.ModElement.Tag
public class TheBiomeFriutEdibleFoodEatenProcedure extends TestoneElements.ModElement {

	public TheBiomeFriutEdibleFoodEatenProcedure(TestoneElements instance) {
		super(instance, 24);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheBiomeFriutEdibleFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 1, (int) 3));

	}

}

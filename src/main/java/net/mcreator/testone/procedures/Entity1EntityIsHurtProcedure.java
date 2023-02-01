package net.mcreator.testone.procedures;

@TestoneElements.ModElement.Tag
public class Entity1EntityIsHurtProcedure extends TestoneElements.ModElement {

	public Entity1EntityIsHurtProcedure(TestoneElements instance) {
		super(instance, 63);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Entity1EntityIsHurt!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 120, (int) 5));

	}

}

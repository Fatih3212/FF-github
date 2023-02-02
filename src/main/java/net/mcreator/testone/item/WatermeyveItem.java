
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class WatermeyveItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:watermeyve")
	public static final Item block = null;

	public WatermeyveItem(TestoneElements instance) {
		super(instance, 74);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ModesyalariItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(5).saturation(1f)

					.build()));
			setRegistryName("watermeyve");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();

				WatermeyveFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}

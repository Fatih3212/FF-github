
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class YenidunyameyveItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:yenidunyameyve")
	public static final Item block = null;

	public YenidunyameyveItem(TestoneElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(2).saturation(0.1f)

					.build()));
			setRegistryName("yenidunyameyve");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 48;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
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

				YenidunyameyveFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}

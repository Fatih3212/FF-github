
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class DarkingotItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkingot")
	public static final Item block = null;

	public DarkingotItem(TestoneElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ModesyalariItemGroup.tab).maxStackSize(64));
			setRegistryName("darkingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}

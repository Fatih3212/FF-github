
package net.mcreator.testone.block;

@TestoneElements.ModElement.Tag
public class WaterdirtBlock extends TestoneElements.ModElement {

	@ObjectHolder("testone:waterdirt")
	public static final Block block = null;

	public WaterdirtBlock(TestoneElements instance) {
		super(instance, 66);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ModesyalariItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 10f).lightValue(0));

			setRegistryName("waterdirt");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}


package net.mcreator.testone.block;

@TestoneElements.ModElement.Tag
public class WateragacBlock extends TestoneElements.ModElement {

	@ObjectHolder("testone:wateragac")
	public static final Block block = null;

	public WateragacBlock(TestoneElements instance) {
		super(instance, 68);

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

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 10f).lightValue(0));

			setRegistryName("wateragac");
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


package net.mcreator.testone.block;

@TestoneElements.ModElement.Tag
public class YenidunyabiocimenBlock extends TestoneElements.ModElement {

	@ObjectHolder("testone:yenidunyabiocimen")
	public static final Block block = null;

	public YenidunyabiocimenBlock(TestoneElements instance) {
		super(instance, 23);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(1.5f, 10f).lightValue(0));

			setRegistryName("yenidunyabiocimen");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(YenidunyabiotoprakBlock.block, (int) (1)));
		}

	}

}

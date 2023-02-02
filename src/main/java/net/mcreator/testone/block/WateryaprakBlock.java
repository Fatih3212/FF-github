
package net.mcreator.testone.block;

@TestoneElements.ModElement.Tag
public class WateryaprakBlock extends TestoneElements.ModElement {

	@ObjectHolder("testone:wateryaprak")
	public static final Block block = null;

	public WateryaprakBlock(TestoneElements instance) {
		super(instance, 72);

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

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0f, 10f).lightValue(0));

			setRegistryName("wateryaprak");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR, (int) (1)));
		}

	}

}


package net.mcreator.testone.block;

@TestoneElements.ModElement.Tag
public class DarkblockBlock extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkblock")
	public static final Block block = null;

	public DarkblockBlock(TestoneElements instance) {
		super(instance, 56);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10f, 10f).lightValue(0));

			setRegistryName("darkblock");
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

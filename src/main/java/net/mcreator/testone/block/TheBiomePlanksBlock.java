
package net.mcreator.testone.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

import java.util.List;
import java.util.Collections;

@TestoneElements.ModElement.Tag
public class TheBiomePlanksBlock extends TestoneElements.ModElement {
	@ObjectHolder("testone:thebiomeplanks")
	public static final Block block = null;
	public TheBiomePlanksBlock(TestoneElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ModesyalariItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.GROUND).hardnessAndResistance(3f, 10f).lightValue(0));
			setRegistryName("thebiomeplanks");
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

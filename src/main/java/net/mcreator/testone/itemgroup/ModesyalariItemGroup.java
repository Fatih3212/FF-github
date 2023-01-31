
package net.mcreator.testone.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.testone.item.ThebetweenDiamondGemItem;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class ModesyalariItemGroup extends TestoneElements.ModElement {
	public ModesyalariItemGroup(TestoneElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmodesyalari") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ThebetweenDiamondGemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}

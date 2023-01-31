
package net.mcreator.testone.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class DenemebiomeyvesiItem extends TestoneElements.ModElement {
	@ObjectHolder("testone:denemebiomeyvesi")
	public static final Item block = null;
	public DenemebiomeyvesiItem(TestoneElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(5).saturation(1f).build()));
			setRegistryName("denemebiomeyvesi");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}

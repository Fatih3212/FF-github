
package net.mcreator.testone.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class DarkingottoolsAxeItem extends TestoneElements.ModElement {
	@ObjectHolder("testone:darkingottoolsaxe")
	public static final Item block = null;
	public DarkingottoolsAxeItem(TestoneElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ModesyalariItemGroup.tab)) {
		}.setRegistryName("darkingottoolsaxe"));
	}
}

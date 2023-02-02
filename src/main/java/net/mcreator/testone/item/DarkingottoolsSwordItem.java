
package net.mcreator.testone.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class DarkingottoolsSwordItem extends TestoneElements.ModElement {
	@ObjectHolder("testone:darkingottoolssword")
	public static final Item block = null;
	public DarkingottoolsSwordItem(TestoneElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 17.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ModesyalariItemGroup.tab)) {
		}.setRegistryName("darkingottoolssword"));
	}
}

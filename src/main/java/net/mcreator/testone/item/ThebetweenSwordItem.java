
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class ThebetweenSwordItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:thebetweensword")
	public static final Item block = null;

	public ThebetweenSwordItem(TestoneElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 9f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("thebetweensword"));
	}

}

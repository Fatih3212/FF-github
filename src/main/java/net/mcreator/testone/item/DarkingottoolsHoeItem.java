
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class DarkingottoolsHoeItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkingottoolshoe")
	public static final Item block = null;

	public DarkingottoolsHoeItem(TestoneElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("darkingottoolshoe"));
	}

}

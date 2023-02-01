
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class DarkingottoolsShovelItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkingottoolsshovel")
	public static final Item block = null;

	public DarkingottoolsShovelItem(TestoneElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("darkingottoolsshovel"));
	}

}

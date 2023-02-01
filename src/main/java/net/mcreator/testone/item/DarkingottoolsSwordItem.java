
package net.mcreator.testone.item;

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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("darkingottoolssword"));
	}

}

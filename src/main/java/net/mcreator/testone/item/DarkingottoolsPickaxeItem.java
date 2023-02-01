
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class DarkingottoolsPickaxeItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkingottoolspickaxe")
	public static final Item block = null;

	public DarkingottoolsPickaxeItem(TestoneElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
				return 2;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("darkingottoolspickaxe"));
	}

}

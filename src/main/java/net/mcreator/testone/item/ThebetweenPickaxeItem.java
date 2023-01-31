
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class ThebetweenPickaxeItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:thebetweenpickaxe")
	public static final Item block = null;

	public ThebetweenPickaxeItem(TestoneElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("thebetweenpickaxe"));
	}

}

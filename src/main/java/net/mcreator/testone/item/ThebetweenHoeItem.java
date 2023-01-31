
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class ThebetweenHoeItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:thebetweenhoe")
	public static final Item block = null;

	public ThebetweenHoeItem(TestoneElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("thebetweenhoe"));
	}

}

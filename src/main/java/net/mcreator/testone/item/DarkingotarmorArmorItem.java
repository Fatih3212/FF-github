
package net.mcreator.testone.item;

@TestoneElements.ModElement.Tag
public class DarkingotarmorArmorItem extends TestoneElements.ModElement {

	@ObjectHolder("testone:darkingotarmorarmorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("testone:darkingotarmorarmorbody")
	public static final Item body = null;

	@ObjectHolder("testone:darkingotarmorarmorlegs")
	public static final Item legs = null;

	@ObjectHolder("testone:darkingotarmorarmorboots")
	public static final Item boots = null;

	public DarkingotarmorArmorItem(TestoneElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 20;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{4, 12, 10, 4}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 15;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "darkingotarmorarmor";
			}

			public float getToughness() {
				return 0f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ModesyalariItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "testone:textures/models/armor/darkingotarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("darkingotarmorarmorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ModesyalariItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "testone:textures/models/armor/darkingotarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("darkingotarmorarmorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ModesyalariItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "testone:textures/models/armor/darkingotarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("darkingotarmorarmorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ModesyalariItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "testone:textures/models/armor/darkingotarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();

					DarkingotarmorArmorBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("darkingotarmorarmorboots"));
	}

}

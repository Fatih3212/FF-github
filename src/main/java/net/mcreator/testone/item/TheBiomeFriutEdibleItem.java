
package net.mcreator.testone.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.testone.procedures.TheBiomeFriutEdibleFoodEatenProcedure;
import net.mcreator.testone.itemgroup.ModesyalariItemGroup;
import net.mcreator.testone.TestoneElements;

@TestoneElements.ModElement.Tag
public class TheBiomeFriutEdibleItem extends TestoneElements.ModElement {
	@ObjectHolder("testone:thebiomefriutedible")
	public static final Item block = null;
	public TheBiomeFriutEdibleItem(TestoneElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ModesyalariItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(5).saturation(5f).build()));
			setRegistryName("thebiomefriutedible");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				TheBiomeFriutEdibleFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

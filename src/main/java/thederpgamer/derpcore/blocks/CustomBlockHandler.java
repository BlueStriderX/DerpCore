package main.java.thederpgamer.derpcore.blocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import main.java.thederpgamer.derpcore.main.Main;

public class CustomBlockHandler implements Listener {
	
	@EventHandler
	public static void onBlockPlace(BlockPlaceEvent e) {
		ItemStack item = e.getItemInHand();
		Block block = e.getBlock();
		Material m = block.getType();
		if(m.equals(Material.SPAWNER)) {
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			if(spawner.getSpawnedType().equals(EntityType.ARMOR_STAND)) {
				spawner.setSpawnRange(0);
				createSpawner(item, e.getBlock());
			}
		}
	}
	
	public static void createSpawner(ItemStack item, Block block) {
		
		int customModelData = getCustomModelData(item.getItemMeta().getDisplayName());
		
		String dataString = "minecraft:mob_spawner[SpawnData:{ArmorItems:[0:{},1:{},2:{},3:{id:\"minecraft:wooden_hoe\",Count:1b,CustomModelData:" + customModelData + ",tag:{Unbreakable:1}}]";
		BlockData data = Bukkit.createBlockData(dataString);
		block.setBlockData(data);
	}

	public static int getCustomModelData(String displayName) {
		int data = 0;
		for(CustomBlock x : Main.customBlocks) {
			if(x.displayName.equals(displayName)) {
				data = x.modelData;
			}
		}
		return data;
	}
}

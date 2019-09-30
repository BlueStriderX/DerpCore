package main.java.thederpgamer.derpcore.gui;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUICreator {
	
	public static void openGUI(CustomGUI customGUI, Player player) {
		Inventory gui = Bukkit.createInventory(player, 27, customGUI.getName());
		for(GUISlot x : customGUI.slots) {
			if(x.citem != null && x.cblock == null) {
				gui.setItem(0, createGuiItem(customGUI.getName(), new ArrayList<String>(Arrays.asList(new String[] { "" })), Material.WOODEN_HOE, x.citem.modelData));
			} else if(x.citem == null && x.cblock != null) {
				gui.setItem(0, createGuiItem(customGUI.getName(), new ArrayList<String>(Arrays.asList(new String[] { "" })), Material.WOODEN_HOE, x.cblock.modelData));
			}
		}		  
		player.closeInventory();
		player.openInventory(gui);
	}
	
	 public static ItemStack createGuiItem(String name, ArrayList<String> desc, Material mat, int modelData) {
		 ItemStack i = new ItemStack(mat, 1);
		 ItemMeta iMeta = i.getItemMeta();
		 iMeta.setDisplayName(name);
		 iMeta.setLore(desc);
		 iMeta.setCustomModelData(1);
		 i.setItemMeta(iMeta);
		 return i;
	 }
}

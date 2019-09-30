package main.java.thederpgamer.derpcore.gui;

import java.lang.reflect.Method;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;

import main.java.thederpgamer.derpcore.blocks.CustomBlock;
import main.java.thederpgamer.derpcore.blocks.CustomItem;

public class GUISlot {
	public Item item;
	public Block block;
	public CustomItem citem;
	public CustomBlock cblock;
	public String displayName;
	public int slot;
	public Method clickFunction;

	public GUISlot(Item guiItem, String displayName, int slot, Method onClick) {
		
	}
	
	public GUISlot(Block guiBlock, String displayName, int slot, Method onClick) {
		
	}
	
	public GUISlot(CustomItem customGUIItem, String displayName, int slot, Method onClick) {
		
	}
	
	public GUISlot(CustomBlock customGuiBlock, String displayName, int slot, Method onClick) {
		
	}
}
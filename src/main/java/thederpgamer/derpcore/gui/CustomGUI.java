package main.java.thederpgamer.derpcore.gui;

import java.util.List;

import org.bukkit.entity.Player;

public class CustomGUI {
	
	public String name;
	public String texPath;
	public int size = 27;
	public int guiOverlaySlot = 0;
	public List<GUISlot> slots;
	public List<GUIElement> elements;
	
	public CustomGUI(String displayName, String texturePath, List<GUISlot> triggerSlots, List<GUIElement> guiElements) {
		this.name = displayName;
		this.texPath = texturePath;
		this.slots = triggerSlots;
		this.elements = guiElements;
		saveGUI(this);
	}
	
	public CustomGUI(String displayName, String texturePath, List<GUISlot> triggerSlots) {
		this.name = displayName;
		this.texPath = texturePath;
		this.slots = triggerSlots;
		saveGUI(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void saveGUI(CustomGUI gui) {
		
	}
	
	public List<CustomGUI> loadGUIs() {
		return null;
	}
	
	public void sendGUI(CustomGUI gui, Player player) {
		GUICreator.openGUI(gui, player);
	}
}

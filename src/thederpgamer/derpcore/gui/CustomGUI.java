package thederpgamer.derpcore.gui;

import java.util.List;

public class CustomGUI {
	
	public String name;
	public String texName;
	public int size;
	public int guiOverlaySlot;
	public List<GUISlot> slots;
	public List<GUIElement> elements;
	
	public CustomGUI(String displayName, String textureName, int guiSize, int overlaySlot, List<GUISlot> triggerSlots, List<GUIElement> guiElements) {
		this.name = displayName;
		this.texName = textureName;
		this.size = guiSize;
		this.guiOverlaySlot = overlaySlot;
		this.slots = triggerSlots;
		this.elements = guiElements;
	}
	
	public CustomGUI(String displayName, String textureName, int guiSize, int overlaySlot, List<GUISlot> triggerSlots) {
		this.name = displayName;
		this.texName = textureName;
		this.size = guiSize;
		this.guiOverlaySlot = overlaySlot;
		this.slots = triggerSlots;
	}
}

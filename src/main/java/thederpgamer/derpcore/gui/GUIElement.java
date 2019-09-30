package main.java.thederpgamer.derpcore.gui;

public class GUIElement {
	
	public GUIElementType eType;
	public int slot;
	
	public GUIElement(GUIElementType element, int itemSlot) {
		this.eType = element;
		this.slot = itemSlot;
	}
}
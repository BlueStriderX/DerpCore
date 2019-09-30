package main.java.thederpgamer.derpcore.blocks;

import main.java.thederpgamer.derpcore.main.Main;
import net.minecraft.server.v1_14_R1.Block;
import net.minecraft.server.v1_14_R1.Blocks;

public class CustomBlock {
	
	public Block baseblock = Blocks.SPAWNER;
	public String displayName;
	public int modelData;
	
	public void register() {
		Main.customBlocks.add(this);
		Main.writeCustomBlock(this);
	}
}
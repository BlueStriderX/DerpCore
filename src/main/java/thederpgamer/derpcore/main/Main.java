package main.java.thederpgamer.derpcore.main;

import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import main.java.thederpgamer.derpcore.blocks.CustomBlockHandler;
import main.java.thederpgamer.derpcore.blocks.CustomBlock;

public class Main extends JavaPlugin {
	
  private static Main plugin;
  public String NAME = "DerpCore";
  public String VERSION = "0.1";
  public String AUTHOR = "TheDerpGamerX";
  public String pluginFile = NAME + "v" + VERSION;
  
  public static ArrayList<CustomBlock> customBlocks = new ArrayList<CustomBlock>();
  
  @Override
  public void onEnable() {
	plugin = this;
    System.out.println("Loading " + pluginFile + "...");
    
    //Events
    getServer().getPluginManager().registerEvents(new CustomBlockHandler(), this);
    
    //Commands
    //getCommand("<command>").setExecutor(new <CommandClass>());
  }
  
  public static Main getPlugin() {
	  return plugin;
  }
  
  public static void writeCustomBlock(CustomBlock customBlock) {
	  
  }
}

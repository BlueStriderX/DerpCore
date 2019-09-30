package main.java.thederpgamer.derpcore.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
  
  @SuppressWarnings("unchecked")
  public static void writeCustomBlock(CustomBlock customBlock) {
	  JSONObject block = new JSONObject();
	  JSONObject head = new JSONObject();
	  
	  JSONArray rotation = new JSONArray();
	  rotation.add(-30);
	  rotation.add(0);
	  rotation.add(0);
	  
	  JSONArray translation = new JSONArray();
	  translation.add(0);
	  translation.add(-30.75);
	  translation.add(-7.25);
	  
	  JSONArray scale = new JSONArray();
	  scale.add(3.0125);
	  scale.add(3.0125);
	  scale.add(3.0125);
	  
	  head.put("rotation", rotation);
	  head.put("translation", translation);
	  head.put("scale", scale);
	  block.put("display", head);
	  
	  
	  try (FileWriter file = new FileWriter("" + blockResourcePath + ".json")) {
		  file.write(block.toJSONString());
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
  }
}

package main.java.thederpgamer.derpcore.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.thederpgamer.derpcore.blocks.CustomBlockHandler;
import main.java.thederpgamer.derpcore.blocks.CustomBlock;

public class Main extends JavaPlugin {
	
  private static Main plugin;
  public String NAME = "DerpCore";
  public String VERSION = "0.1";
  public String AUTHOR = "TheDerpGamerX";
  public String pluginFile = NAME + "v" + VERSION;
  
  public static String pluginDataFolder = getPlugin().getDataFolder() + "";
  public static String resourcePackFolder = pluginDataFolder + "/resourcepack";
  
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
  
  @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
  public static void writeCustomBlock(CustomBlock customBlock) throws FileNotFoundException, IOException, ParseException {
	  JSONObject block = new JSONObject();
	  JSONObject head = new JSONObject();
	  JSONObject textures = new JSONObject();
	  JSONValue texture = new JSONValue();
	  
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
	  
	  texture.equals("blocks/" + customBlock.name);
	  textures.put("texture", texture);
	  head.put("rotation", rotation);
	  head.put("translation", translation);
	  head.put("scale", scale);
	  block.put("display", head);
	  block.put("textures", textures);
	  
	  try (FileWriter file = new FileWriter(resourcePackFolder + "/assets/minecraft/models/blocks/" + customBlock.name + ".json")) {
		  file.write(block.toJSONString());
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  
	  addCustomBlockToFile(customBlock.name, customBlock.modelData);
  }
  
  @SuppressWarnings("unchecked")
  private static void addCustomBlockToFile(String name, int modelData) throws FileNotFoundException, IOException, ParseException {
	  String jsonPath = resourcePackFolder + "/assets/minecraft/models/item/wooden_hoe.json";
	  
      Object obj = new JSONParser().parse(new FileReader(jsonPath)); 
      JSONObject jo = (JSONObject) obj;
      JSONArray overrides = (JSONArray) jo.get("overrides");
	  JSONArray predicate = new JSONArray();
	  JSONValue customModelData = new JSONValue();
	  JSONValue model = new JSONValue();
	  
	  model.equals("blocks/" + name);
	  customModelData.equals(modelData);
	  predicate.add(customModelData);
	  overrides.add(predicate);
	  overrides.add(model);
  }
  
}

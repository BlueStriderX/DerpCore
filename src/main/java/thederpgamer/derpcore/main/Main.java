package main.java.thederpgamer.derpcore.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
  private static Main plugin;
  public String NAME = "DerpCore";
  public String VERSION = "0.1";
  public String AUTHOR = "TheDerpGamerX";
  public String pluginFile = NAME + "v" + VERSION;

  
  @Override
  public void onEnable() {
	plugin = this;
    System.out.println("Loading " + pluginFile + "...");
    
    //Events
    //getServer().getPluginManager().registerEvents(new <EventClass>(), this);
    
    //Commands
    //getCommand("<command>").setExecutor(new <CommandClass>());
  }
  
  public static Main getPlugin() {
	  return plugin;
  }
}

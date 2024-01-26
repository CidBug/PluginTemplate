package net.toxi.plugin.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin{
	
	public static Plugin main;
	
	public EventListener list;

	
	@Override
	public void onEnable() {
		main = this;
		
		list = new EventListener();
	
		Bukkit.getServer().getPluginManager().registerEvents(list, this);
		
		this.getCommand("test").setExecutor(new Commands());
		
		this.getLogger().info("§2Plugin aktiviert!");
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("§4Plugin deaktiviert!");
	}

}

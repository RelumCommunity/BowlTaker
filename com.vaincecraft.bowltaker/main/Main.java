package com.vaincecraft.bowltaker.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.vaincecraft.bowltaker.events.BEvent;

public class Main extends JavaPlugin {
	public static Main plugin;
	public String pluginVersion = "V.1.2";
	public void onEnable() {
		plugin = this;
		String versioncheck = Bukkit.getVersion();
		String version[] = versioncheck.split(" ");
		if (Bukkit.getVersion().contains("Spigot")) {
			String servercheck = Bukkit.getVersion();
			String server[] = servercheck.split("-");
			plugin.getServer().getConsoleSender().sendMessage("[BowlTaker INFO] " + ChatColor.YELLOW + "BowlTaker using: " + server[1] + " version " + version[1] + version[2]);
		}
		else plugin.getServer().getConsoleSender().sendMessage("[BowlTaker INFO] " + ChatColor.YELLOW + "BowlTaker using: " + Bukkit.getVersion() + ChatColor.RED + ("UNTESTED SERVER VERSION"));
		  
		plugin.getServer().getConsoleSender().sendMessage("[BowlTaker] " + ChatColor.GREEN + "BowlTaker has been enabled (" + pluginVersion + ")");
		
		Bukkit.getPluginManager().registerEvents(new BEvent(), this);
	}
	
	public void onDisable() {
		plugin.getServer().getConsoleSender().sendMessage("[BowlTaker] " + ChatColor.RED + "BowlTaker has been disabled (" + pluginVersion + ")");
	}
	public static Main getInstance() {
		return plugin;
	}
}

package com.vaincecraft.bowltaker.main;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionChecker implements Listener{
	public String pluginVersion = Main.getInstance().getDescription().getVersion();
	public VersionChecker() {
		try {
			HttpURLConnection connection = (HttpURLConnection)new URL("https://api.spigotmc.org/legacy/update.php?resource=67397").openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
			if (!pluginVersion.equals(version)) {
				Main.getInstance().getLogger().log(Level.WARNING, " ");
				Main.getInstance().getLogger().log(Level.WARNING, "         -= BowlTaker =-");
				Main.getInstance().getLogger().log(Level.WARNING, "You do not have the latest version!");
				Main.getInstance().getLogger().log(Level.WARNING, " ");
				Main.getInstance().getLogger().log(Level.WARNING, "Current: " + pluginVersion);
				Main.getInstance().getLogger().log(Level.WARNING, "Latest: " + version);
				Main.getInstance().getLogger().log(Level.WARNING, " ");
			}
			else {
				Main.getInstance().getLogger().log(Level.INFO, " ");
				Main.getInstance().getLogger().log(Level.INFO, "         -= BowlTaker =-");
				Main.getInstance().getLogger().log(Level.INFO, "You are running the latest version!");
				Main.getInstance().getLogger().log(Level.INFO, " ");
			}
		}
		catch (IOException e) {
			Main.getInstance().getLogger().log(Level.SEVERE, " ");
			Main.getInstance().getLogger().log(Level.SEVERE, "         -= BowlTaker =-");
			Main.getInstance().getLogger().log(Level.SEVERE, "Could not make connection to SpigotMC.org!");
			Main.getInstance().getLogger().log(Level.SEVERE, " ");
			e.printStackTrace();
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent j) {
		Player p = j.getPlayer();
		if(p.hasPermission("bowltaker.updates")) {
			try {
		      HttpURLConnection connection = (HttpURLConnection)new URL("https://api.spigotmc.org/legacy/update.php?resource=67397").openConnection();
		      connection.setDoOutput(true);
		      connection.setRequestMethod("POST");
		      String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
		      if (!pluginVersion.equals(version)) {
		    	  p.sendMessage(ChatColor.GRAY + "[BowlTaker] " + ChatColor.RED + "You are not in the latest version, please update the plugin from our spigot page: https://www.spigotmc.org/resources/bowl-taker-1-8-8-1-14.67397/");
		      }
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
			}
		}
	}
}

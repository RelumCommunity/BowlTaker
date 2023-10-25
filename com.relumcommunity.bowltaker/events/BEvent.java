package com.relumcommunity.bowltaker.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import com.relumcommunity.bowltaker.main.Main;

public class BEvent implements Listener {
	public Boolean OffHand = true;
    public BEvent(String ver) {
    	if (ver.contains("1.7") || ver.contains("1.8") || (ver.contains("1.9") && !ver.contains("1.9.2") && !ver.contains("1.9.4"))) {
    		OffHand = false;
    	}
	}
	@EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (!e.getPlayer().hasPermission("bowltaker.bypass")) {
            ItemStack bowl = new ItemStack(Material.BOWL);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    e.getPlayer().getInventory().removeItem(new ItemStack[] {bowl});
                    if (OffHand == true) {
	                    if (e.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.BOWL)) {
	                        e.getPlayer().getInventory().setItemInOffHand(null);
	                    }
                    }
                }
            }, 2L);
        }
    }
}

package com.vaincecraft.bowltaker.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import com.vaincecraft.bowltaker.main.Main;

public class BEvent implements Listener {
	@EventHandler
	public void onEat(final PlayerItemConsumeEvent e) {
		final ItemStack bowl = new ItemStack(Material.BOWL);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			public void run() {
				e.getPlayer().getInventory().removeItem(new ItemStack[] { bowl });
			}
		}, 2);
	}
}

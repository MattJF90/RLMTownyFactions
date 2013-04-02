package com.rlminecraft.RLMTownyFactions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.event.LandClaimEvent;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

public class FactionListener implements Listener {
	
	RLMTownyFactions plugin;
	
	public FactionListener (RLMTownyFactions instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onFactionClaim (LandClaimEvent event) {
		plugin.console.info("LandClaimEvent triggered.");
		FLocation floc = event.getLocation();
		plugin.console.info("floc: " + floc.toString());
		Location loc = event.getPlayer().getLocation();
		plugin.console.info("loc:  " + loc.toString());
		TownBlock plot = TownyUniverse.getTownBlock(loc);
		if (plot == null) {
			plugin.console.info("TownBlock: null");
		}
		else {
			plugin.console.info("TownBlock: " + plot.toString());
		}
		
		if (plot == null || !plot.hasTown()) return;
		event.getPlayer().sendMessage(ChatColor.RED + "This land is already owned by a town.");
		event.setCancelled(true);
	}
	
}

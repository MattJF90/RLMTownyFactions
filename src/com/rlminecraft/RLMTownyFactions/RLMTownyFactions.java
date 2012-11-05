package com.rlminecraft.RLMTownyFactions;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.event.LandClaimEvent;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.Coord;

public class RLMTownyFactions extends JavaPlugin implements Listener {
	
	Logger console;
	Towny towny;
	
	public void onEnable() {
		console = this.getLogger();
		towny = (Towny) this.getServer().getPluginManager().getPlugin("Towny");
	}
	
	
	// EVENT LISTENERS
	
	@EventHandler
	public void onFactionClaim (LandClaimEvent event) {
		FLocation floc = event.getLocation();
		//Location loc = new Location(floc.getWorld(), floc.getX(), 64, floc.getZ());
		Coord coord = new Coord((int)floc.getX(),(int)floc.getZ());
		boolean doubleClaimed =  towny.getTownyUniverse()
			.getWorldMap().get(floc.getWorld()).hasTownBlock(coord);
		if (doubleClaimed) event.setCancelled(true);
	}
	
}

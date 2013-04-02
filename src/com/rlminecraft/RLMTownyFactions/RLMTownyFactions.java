package com.rlminecraft.RLMTownyFactions;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.massivecraft.factions.P;
import com.palmergames.bukkit.towny.Towny;

public class RLMTownyFactions extends JavaPlugin implements Listener {
	
	Logger console;
	Towny towny;
	P factions;
	
	public void onEnable() {
		console = this.getLogger();
		towny = (Towny) this.getServer().getPluginManager().getPlugin("Towny");
		factions = (P) this.getServer().getPluginManager().getPlugin("Factions");
		
		if (towny == null) {
			console.severe("Towny was not found on the server!");
		}
		if (factions == null) {
			console.severe("Factions was not found on the server!");
		}
		
		this.getServer().getPluginManager().registerEvents(new FactionListener(this), this);
	}
	
	public void onDisable() {
	}
	
}

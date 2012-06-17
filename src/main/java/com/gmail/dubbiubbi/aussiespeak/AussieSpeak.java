package com.gmail.dubbiubbi.aussiespeak;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AussieSpeak extends JavaPlugin implements Listener {
	private boolean inUse = false;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		this.getLogger().info("AussieSpeak loaded!");
	}

	@Override
	public void onDisable() {
		this.getLogger().info("AussieSpeak unloaded!");
	}
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if(cmd.getName().equalsIgnoreCase("aussiespeak")){ // If the player typed /basic then do the following...
    		inUse = !inUse;
    		return true;
    	} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
    	return false; 
    }

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if(inUse){
			String message = event.getMessage();
			message = message.replaceAll(" ", " cunt ");
			if(message.contains(".")){
				message = message.replaceAll("\\.", ", mate.");
			}else{
				message = message.concat(", mate.");
			}
			event.setMessage(message);
		}		
	}
}
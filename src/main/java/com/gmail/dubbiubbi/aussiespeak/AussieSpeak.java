package com.gmail.dubbiubbi.aussiespeak;

import org.bukkit.ChatColor;
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
		//registers the events so event handling can be done.
		getServer().getPluginManager().registerEvents(this, this);
		//prints to the logger that the plugin was loaded.
		this.getLogger().info("AussieSpeak loaded!");
		//Sets the description for the command aussiespeak.
		this.getCommand("aussiespeak").setDescription("Toggles pluin feature on and off.");
		//Sets the permission for the command aussiespeak so only ops can use it.
		this.getCommand("aussiespeak").setPermission("op");
		//Prints a custom message when someone who doesn't have permission tries to use the command.
		this.getCommand("aussiespeak").setPermissionMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
	}

	@Override
	public void onDisable() {
		//Prints to the logger when the plugin is unloaded. 
		this.getLogger().info("AussieSpeak unloaded!");
	}
	
	
	//Method that tells what to do when the aussiespeak command is called.
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if(cmd.getName().equalsIgnoreCase("aussiespeak")){
    			//Boolean value to toggle feature on and off.
    			inUse = !inUse;
        		return true;
    	}
    	return false;
    }

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		//When player uses chat this code runs. Checks to see if feature is enabled.
		if(inUse){
			//If the feature is turned on this code runs which makes cunt every other word and ends messages with mate.
			String message = event.getMessage();
			message = message.replaceAll(" ", " cunt ");
			if(message.contains(".")){
				if(message.endsWith(".")){
					message = message.replaceAll("\\.", ", mate.");
				}else{
					message = message.replaceAll("\\.", ", mate.");
					message = message.concat(", mate.");
				}
			}else{
				message = message.concat(", mate.");
			}
			event.setMessage(message);
		}		
	}
}
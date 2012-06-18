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
		getServer().getPluginManager().registerEvents(this, this);

		this.getLogger().info("AussieSpeak loaded!");
		
		this.getCommand("aussiespeak").setDescription("Toggles pluin feature on and off.");
		
		this.getCommand("aussiespeak").setPermission("op");
		
		this.getCommand("aussiespeak").setPermissionMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
	}

	@Override
	public void onDisable() {
		this.getLogger().info("AussieSpeak unloaded!");
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if(cmd.getName().equalsIgnoreCase("aussiespeak")){
    			inUse = !inUse;
        		return true;
    	}
    	return false;
    }

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if(inUse){
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
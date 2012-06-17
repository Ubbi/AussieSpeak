package com.gmail.dubbiubbi.aussiespeak;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.ChatColor;

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
	public void onPlayerChat(PlayerChatEvent event) {
		String message = event.getMessage();
		String messageToSend = new String(ChatColor.DARK_RED+"You do not have permission.");
		Player player = event.getPlayer();
		if(message.equals("/aussiespeak")){
			if(player.isOp()){
					inUse = !inUse;
			}else{
				player.sendMessage(messageToSend);
			}
		}
		if(inUse){
			message.replaceAll(" ", " cunt ");
			message.replaceAll(".", ", mate.");
		}	
		event.setMessage(message);
	}
}
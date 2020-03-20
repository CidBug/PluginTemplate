package net.toxi.plugin.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();		
		
		p.sendMessage("Hallo "+p.getName());
		Bukkit.broadcastMessage(p.getName()+" hat den Server betreten!");
		
	}
	
	@EventHandler
	public void onWakeUp(PlayerBedLeaveEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("Guten Morgen, "+p.getName());
		
		p.getInventory().addItem(createItem());
	}
	
	private ItemStack createItem() {
		ItemStack item = new ItemStack(Material.COOKIE, 3);
		
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§5 Guten Morgen Keks");
			meta.addEnchant(Enchantment.DURABILITY, 3, true);
		
		item.setItemMeta(meta);
		return item;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		switch (e.getAction()) {
		case LEFT_CLICK_AIR:
			p.sendMessage("Du haust in die Luft!");
			break;
		case LEFT_CLICK_BLOCK:
			p.sendMessage("Du hast einen Block angeklickt.");
			break;
		case RIGHT_CLICK_AIR:
			p.sendMessage("Rechtsklick in die Luft!");
			break;
		case RIGHT_CLICK_BLOCK:
			p.sendMessage("Das ist ein block vom Typ §6"+e.getClickedBlock().getType());
			break;
		case PHYSICAL:
			p.sendMessage("Das war ne Druckplatte oder so ...");
			break;
		default:
			break;
		}
	}
	

}

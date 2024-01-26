package net.toxi.plugin.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Utils {

	public boolean checkForTNT(Player p) {
		if(p == null) {
			return false;
		}
		if(p.getInventory().contains(Material.TNT)) {
			p.getInventory().remove(Material.TNT);
			return true;
		} else {
			return false;
		}
	
	}
	
}

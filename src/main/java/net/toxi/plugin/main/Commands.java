package net.toxi.plugin.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if("test".equalsIgnoreCase(cmd.getName())) {
				
				if(args.length > 0) {
					
					switch (args[0]) {
					case "hallo":
						p.sendMessage("Hallo "+p.getName()+"!");
						break;
						
					case "start":
						p.sendMessage("Los gehts!");
						Timer t = new Timer();
						t.startTimer();
						break;
						
					case "check":
						Utils u = new Utils();
						u.checkForTNT(Bukkit.getPlayer("Kenny"));
						p.sendMessage("Kenny hat nun kein TNT mehr ;D");
						break;
					default:
						break;
					}
				}
			}
			
			
		} else {
			sender.sendMessage("Du bist kein Spieler, sondern die Console!");
		}
		
		return true;
	}

}

package net.toxi.plugin.main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public class Timer{		//https://bukkit.gamepedia.com/Scheduler_Programming

	public int counter = 60;
	
	public void startTimer() {
		
		BukkitScheduler scheduler = Plugin.main.getServer().getScheduler();
		counter = scheduler.scheduleSyncRepeatingTask(Plugin.main, new Runnable() {
			
			@Override
			public void run() {
				
				switch (counter) {
					case 60: case 30: case 10: case 5: case 3: case 2: case 1:
					
						Bukkit.broadcastMessage("§bDas Spiel beginnt in §6"+counter+" §bSekunde(n)!");

				default:
					break;
				}
				
				counter--;	
				if(counter < 1) {
					scheduler.cancelTask(counter);
				}
			}
		}, 0, 20L);
	}

	
	
}

package tk.Zeryther.staffnotify.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StaffNotifyAPI {

	public static void createNotification(String msg, StaffNotifyType type){
		if(type == StaffNotifyType.NONE){
			for(Player all : Bukkit.getOnlinePlayers()){
				if(all.hasPermission(type.getPermission())){
					all.sendMessage("§7[§cStaffNotify§7] §r" + msg);
				}
			}
			
			System.out.println("[StaffNotify] " + msg);
		} else {
			for(Player all : Bukkit.getOnlinePlayers()){
				if(all.hasPermission(type.getPermission())){
					all.sendMessage("§7[§cStaffNotify§7|" + type.getSuffix() + "§7] §r" + msg);
				}
			}
			
			System.out.println("[StaffNotify|" + type.getName() + "] " + msg);
		}
	}
	
	public static void createNotification(String msg, String suffix){
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("staffnotify.seenotify.custom")){
				all.sendMessage("§7[§cStaffNotify§7|§r" + suffix + "§7] §r" + msg);
			}
		}
		
		System.out.println("[StaffNotify|" + suffix + "] " + msg);
	}
	
}

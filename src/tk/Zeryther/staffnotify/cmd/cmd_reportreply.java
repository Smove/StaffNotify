package tk.Zeryther.staffnotify.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import tk.Zeryther.staffnotify.StaffNotify;
import tk.Zeryther.staffnotify.StaffNotifyMeta;
import tk.Zeryther.staffnotify.api.StaffNotifyAPI;
import tk.Zeryther.staffnotify.api.StaffNotifyType;

public class cmd_reportreply implements CommandExecutor {

	private StaffNotify plugin;
	public cmd_reportreply(StaffNotify plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if((sender instanceof Player)){
			Player p = (Player)sender;
			
			if(p.hasPermission("staffnotify.cmd.reportreply")){
				if(args.length < 2){
					p.sendMessage("§c/" + label + " <Player> <Message>");
				} else {
					if(Bukkit.getPlayer(args[0]) == null){
						p.sendMessage("§cThat player could not be found.");
					} else {
						Player p2 = Bukkit.getPlayer(args[0]);
						
						StringBuilder sb = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
						sb.append(" ").append(args[i]);
						}
						
						String finalMsg = sb.toString().substring(1);
						
						StaffNotifyAPI.createNotification(p.getDisplayName() + "§7: §f" + finalMsg, StaffNotifyType.REPORT_REPLY);
						p2.sendMessage("§7[§cStaffNotify§7|§r" + StaffNotifyType.REPORT_REPLY.getSuffix() + "§7] §r" + p.getDisplayName() + "§7: §f" + finalMsg);
						p.sendMessage("§aYou replied to the player §2" + p2.getName());
					}
				}
			} else {
				p.sendMessage(StaffNotifyMeta.NO_PERMISSION);
			}
		} else if((sender instanceof ConsoleCommandSender)){
			ConsoleCommandSender CONSOLE = (ConsoleCommandSender)sender;
			
			if(args.length < 2){
				CONSOLE.sendMessage("§c/" + label + " <Player> <Message>");
			} else {
				if(Bukkit.getPlayer(args[0]) == null){
					CONSOLE.sendMessage("§cThat player could not be found.");
				} else {
					Player p2 = Bukkit.getPlayer(args[0]);
					
					StringBuilder sb = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
					sb.append(" ").append(args[i]);
					}
					
					String finalMsg = sb.toString().substring(1);
					
					p2.sendMessage("§7[§cStaffNotify§7|§r" + StaffNotifyType.REPORT_REPLY.getSuffix() + "§7] §r§dCONSOLE§7: §f" + finalMsg);
					StaffNotifyAPI.createNotification("§dCONSOLE§7: §f" + finalMsg, StaffNotifyType.REPORT_REPLY);
				}
			}
		}
		
		return false;
	}
	
}

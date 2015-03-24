package tk.Zeryther.staffnotify.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.Zeryther.staffnotify.StaffNotify;
import tk.Zeryther.staffnotify.StaffNotifyMeta;
import tk.Zeryther.staffnotify.api.StaffNotifyAPI;
import tk.Zeryther.staffnotify.api.StaffNotifyType;

public class cmd_report implements CommandExecutor {

	private StaffNotify plugin;
	public cmd_report(StaffNotify plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("report")){
			if((sender instanceof Player)){
				Player p = (Player)sender;
				
				if(p.hasPermission("staffnotify.cmd.report")){
					if(args.length == 0){
						p.sendMessage("§c/" + label + " <Message>");
					} else {
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < args.length; i++) {
						sb.append(" ").append(args[i]);
						}
						
						String finalMsg = sb.toString().substring(1);
						
						StaffNotifyAPI.createNotification(p.getDisplayName() + "§7: §f" + finalMsg, StaffNotifyType.REPORT);
						
						p.sendMessage("§aYour message was sent to our staff");
					}
				} else {
					p.sendMessage(StaffNotifyMeta.NO_PERMISSION);
				}
			} else {
				sender.sendMessage(StaffNotifyMeta.NO_PLAYER);
			}
		}
		
		return false;
	}
	
}

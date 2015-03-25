package tk.Zeryther.staffnotify.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.Zeryther.staffnotify.StaffNotify;
import tk.Zeryther.staffnotify.StaffNotifyMeta;
import tk.Zeryther.staffnotify.api.StaffNotifyAPI;
import tk.Zeryther.staffnotify.api.StaffNotifyType;

public class cmd_staffnotify implements CommandExecutor {

	private StaffNotify plugin;
	public cmd_staffnotify(StaffNotify plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("staffnotify")){
			sender.sendMessage("§c=================================");
			sender.sendMessage("    §c§lStaffNotify");
			sender.sendMessage("      §7by Zeryther");
			sender.sendMessage("");
			sender.sendMessage("  §chttp://www.zeryther.tk");
			sender.sendMessage("§c=================================");
		}
		
		return false;
	}
	
}

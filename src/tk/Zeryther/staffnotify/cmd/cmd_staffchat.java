package tk.Zeryther.staffnotify.cmd;

import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import tk.Zeryther.staffnotify.StaffNotify;
import tk.Zeryther.staffnotify.StaffNotifyMeta;
import tk.Zeryther.staffnotify.api.StaffNotifyAPI;
import tk.Zeryther.staffnotify.api.StaffNotifyType;

public class cmd_staffchat implements CommandExecutor {

	private StaffNotify plugin;
	public cmd_staffchat(StaffNotify plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("staffchat")){
			if((sender instanceof Player)){
				Player p = (Player)sender;
				
				if(p.hasPermission("staffnotify.cmd.staffchat")){
					if(args.length == 0){
						p.sendMessage("§c/" + label + " <Message>");
					} else {
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < args.length; i++) {
						sb.append(" ").append(args[i]);
						}
						
						String finalMsg = sb.toString().substring(1);
						StaffNotifyAPI.createNotification(p.getDisplayName() + "§7: §f" + finalMsg, StaffNotifyType.TEAM_CHAT);
					}
				} else {
					p.sendMessage(StaffNotifyMeta.NO_PERMISSION);
				}
			} else if((sender instanceof ConsoleCommandSender)){
				ConsoleCommandSender CONSOLE = (ConsoleCommandSender)sender;
				
				if(args.length == 0){
					CONSOLE.sendMessage("§c/" + label + " <Message>");
				} else {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
					sb.append(" ").append(args[i]);
					}
					
					String finalMsg = sb.toString().substring(1);
					StaffNotifyAPI.createNotification("§dCONSOLE§7: §f" + finalMsg, StaffNotifyType.TEAM_CHAT);
				}
			} else if((sender instanceof CommandBlock)){
				CommandBlock cb = (CommandBlock)sender;
				
				if(args.length == 0){} else {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
					sb.append(" ").append(args[i]);
					}
					
					String finalMsg = sb.toString().substring(1);
					StaffNotifyAPI.createNotification("§d" + cb.getName() + " §f§o(Commandblock)§r§7: §f" + finalMsg, StaffNotifyType.TEAM_CHAT);
				}
			} else {
				System.err.println("[StaffNotify|ERROR] Someone tried to execute /staffchat, but Sender-Entity is unknown.");
			}
		}
		
		return false;
	}
	
}

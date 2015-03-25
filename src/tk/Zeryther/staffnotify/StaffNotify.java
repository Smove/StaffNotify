package tk.Zeryther.staffnotify;

import org.bukkit.plugin.java.JavaPlugin;

import tk.Zeryther.staffnotify.cmd.cmd_report;
import tk.Zeryther.staffnotify.cmd.cmd_reportreply;
import tk.Zeryther.staffnotify.cmd.cmd_staffchat;
import tk.Zeryther.staffnotify.cmd.cmd_staffnotify;

public class StaffNotify extends JavaPlugin {

	public void onEnable(){
		System.out.println("[StaffNotify] ENABLING..");
		
		try {
			System.out.println("[StaffNotify] ENABLED!");
		} catch(Exception e){
			System.out.println("[StaffNotify] FAILED TO ENABLE PLUGIN!");
			e.printStackTrace();
			System.out.println("[StaffNotify] DISABLING PLUGIN..");
			this.setEnabled(false);
		}
		
		//saveDefaultConfig();
		_registerCommands();
		_registerListeners();
	}
	
	public void onDisable(){
		System.out.println("[StaffNotify] ENABLING..");
		System.out.println("[StaffNotify] ENABLED!");
	}
	
	private void _registerCommands(){
		getCommand("staffchat").setExecutor(new cmd_staffchat(this));
		getCommand("report").setExecutor(new cmd_report(this));
		getCommand("staffnotify").setExecutor(new cmd_staffnotify(this));
		getCommand("reportreply").setExecutor(new cmd_reportreply(this));
	}
	
	private void _registerListeners(){
		
	}
	
}

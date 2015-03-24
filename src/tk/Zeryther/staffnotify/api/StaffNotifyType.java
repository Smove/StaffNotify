package tk.Zeryther.staffnotify.api;

public enum StaffNotifyType {

	TEAM_CHAT(0, "Team-Chat", "§bTeam-Chat", "staffnotify.seenotify.teamchat"),
	REPORT(1, "Report", "§4Report", "staffnotify.seenotify.report"),
	JOIN(2, "Join", "§aJoin", "staffnotify.seenotify.join"),
	LEAVE(3, "Leave", "§cLeave", "staffnotify.seenotify.leave"),
	BADWORD(4, "Bad-Word", "§cBad-Word", "staffnotify.seenotify.badword"),
	BAN(5, "Ban", "§5Ban", "staffnotify.seenotify.ban"),
	NONE(6, "None", "§8UNDEFINED", "staffnotify.seenotify.undefined"),
	REPORT_REPLY(7, "Report-Reply", "§4Report-Reply", "staffnotify.seenotify.report.reply");
	
	private int id;
	private String name;
	private String suffix;
	private String permission;
	
	StaffNotifyType(int id, String name, String suffix, String permission){
		this.id = id;
		this.name = name;
		this.suffix = suffix;
		this.permission = permission;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSuffix(){
		return suffix;
	}
	
	public String getPermission(){
		return permission;
	}
	
}
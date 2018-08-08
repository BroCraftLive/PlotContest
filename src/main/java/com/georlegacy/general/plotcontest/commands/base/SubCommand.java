package com.georlegacy.general.plotcontest.commands.base;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    public SubCommand() {
        this(null, null, null, null, null);
    }

    @Getter private String firstCommand;

    @Getter private String[] aliases;

    @Getter private String permission;

    @Getter private String help;

    @Getter private String description;

    public SubCommand(String firstCommand, String[] aliases, String permission, String help, String description) {
        this.firstCommand = firstCommand;
        this.aliases = aliases;
        this.permission = permission;
        this.help = help;
        this.description = description;
    }

    public abstract boolean execute(CommandSender sender, Command command, String[] args);

}

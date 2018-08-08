package com.georlegacy.general.plotcontest.commands.base;

import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashSet;
import java.util.Set;

public abstract class Command implements CommandExecutor {

    public Command() {
        this(null, null, null);
    }

    @Getter private String permission;

    @Getter private String help;

    @Getter private String description;

    @Getter private Set<SubCommand> subCommands;

    public Command(String permission, String help, String description) {
        this.permission = permission;
        this.help = help;
        this.description = description;

        this.subCommands = new HashSet<SubCommand>();
    }

    public final void addSubCommand(SubCommand subCommand) {
        this.subCommands.add(subCommand);
    }

    public abstract boolean execute(CommandSender sender, org.bukkit.command.Command command, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        for (SubCommand subCommand : subCommands) {
            for (String alias : subCommand.getAliases()) {
                if (args[0].equalsIgnoreCase(alias)) {
                    return subCommand.execute(sender, command, args);
                }
            }
        }
        return execute(sender, command, args);
    }
}

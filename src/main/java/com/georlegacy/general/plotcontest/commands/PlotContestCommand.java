package com.georlegacy.general.plotcontest.commands;

import com.georlegacy.general.plotcontest.commands.base.Command;
import org.bukkit.command.CommandSender;

public class PlotContestCommand extends Command {

    public PlotContestCommand() {
        super("", "See subcommands", "The main command for PlotContest");
    }

    @Override
    public boolean execute(CommandSender sender, org.bukkit.command.Command command, String[] args) {

        return true;
    }

}

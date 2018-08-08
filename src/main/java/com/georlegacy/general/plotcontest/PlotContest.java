package com.georlegacy.general.plotcontest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlotContest extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager manager = Bukkit.getServer().getPluginManager();
        final Plugin plotsquared = manager.getPlugin("PlotSquared");

        if(plotsquared != null && !plotsquared.isEnabled()) {
            getLogger().warning("Disabling due to lack of PlotSquared");
            manager.disablePlugin(this);
            return;
        }

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}

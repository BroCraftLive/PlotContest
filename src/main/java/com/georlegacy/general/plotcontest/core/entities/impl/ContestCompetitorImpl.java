package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.ContestCompetitor;
import com.georlegacy.general.plotcontest.core.entities.ContestContributor;
import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.Judge;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class ContestCompetitorImpl implements ContestCompetitor {

    private final Set<ContestEntry> entries;
    private final String uuid;
    private String name;
    private boolean canCompete;

    public ContestCompetitorImpl(Player player) {
        this.entries = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.canCompete = true;
    }

    public ContestCompetitorImpl(Player player, boolean canCompete) {
        this.entries = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.canCompete = canCompete;
    }

    @Override
    public Set<ContestEntry> getEntries() {
        return entries;
    }

    @Override
    public String getUUID() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canCompete() {
        return canCompete;
    }

    public boolean addEntry(ContestEntry entry) {
        if (this.entries.contains(entry))
            return false;
        this.entries.add(entry);
        return true;
    }

    public boolean removeEntry(ContestEntry entry) {
        if (!this.entries.contains(entry))
            return false;
        this.entries.remove(entry);
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCanCompete(boolean canCompete) {
        this.canCompete = canCompete;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ContestCompetitor &&
                ((ContestContributor) obj).getUUID().equals(this.getUUID());
    }

}

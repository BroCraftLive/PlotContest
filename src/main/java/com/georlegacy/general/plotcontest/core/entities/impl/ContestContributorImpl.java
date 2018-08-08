package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.ContestContributor;
import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.Judge;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class ContestContributorImpl implements ContestContributor {

    private final Set<ContestEntry> entries;
    private final String uuid;
    private String name;
    private boolean canContribute;

    public ContestContributorImpl(Player player) {
        this.entries = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.canContribute = true;
    }

    public ContestContributorImpl(Player player, boolean canContribute) {
        this.entries = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.canContribute = canContribute;
    }

    @Override
    public Set<ContestEntry> getEntriesContributedTo() {
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
    public boolean canContribute() {
        return canContribute;
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

    public void setCanContribute(boolean canContribute) {
        this.canContribute = canContribute;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ContestContributor &&
                ((ContestContributor) obj).getUUID().equals(this.getUUID());
    }

}

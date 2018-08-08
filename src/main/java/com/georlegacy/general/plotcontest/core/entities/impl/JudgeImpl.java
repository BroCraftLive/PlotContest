package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.Contest;
import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.Judge;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JudgeImpl implements Judge {

    private final Set<Contest> contestsJudged;
    private final Set<ContestEntry> entriesJudged;
    private final String uuid;
    private String name;

    public JudgeImpl(Player player) {
        this.contestsJudged = new HashSet<Contest>();
        this.entriesJudged = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
    }

    public JudgeImpl(Player player, Contest... contests) {
        this.contestsJudged = new HashSet<Contest>(Arrays.asList(contests));
        this.entriesJudged = new HashSet<ContestEntry>();
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
    }

    @Override
    public Set<Contest> getContestsJudged() {
        return null;
    }

    @Override
    public Set<ContestEntry> getEntriesJudged() {
        return null;
    }

    @Override
    public String getUUID() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addContest(Contest contest) {
        if (this.contestsJudged.contains(contest))
            return false;
        contestsJudged.add(contest);
        return true;
    }

    public boolean removeContest(Contest contest) {
        if (!this.contestsJudged.contains(contest))
            return false;
        contestsJudged.remove(contest);
        return true;
    }

    public boolean addEntry(ContestEntry entry) {
        if (this.entriesJudged.contains(entry))
            return false;
        entriesJudged.add(entry);
        return true;
    }

    public boolean removeEntry(ContestEntry entry) {
        if (!this.entriesJudged.contains(entry))
            return false;
        entriesJudged.remove(entry);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Judge &&
                ((Judge) obj).getUUID().equals(this.getUUID());
    }

}

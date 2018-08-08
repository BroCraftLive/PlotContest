package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.EntryScore;
import com.georlegacy.general.plotcontest.core.entities.Scorer;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ScorerImpl implements Scorer {

    private final String uuid;
    private String name;
    private final Set<EntryScore> scoresGiven;
    private boolean canScore;

    public ScorerImpl(Player player) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.scoresGiven = new HashSet<EntryScore>();
        this.canScore = true;
    }

    public ScorerImpl(Player player, boolean canScore) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.scoresGiven = new HashSet<EntryScore>();
        this.canScore = canScore;
    }

    public ScorerImpl(Player player, EntryScore... scoresGiven) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.scoresGiven = new HashSet<EntryScore>(Arrays.asList(scoresGiven));
        this.canScore = true;
    }

    public ScorerImpl(Player player, boolean canScore, EntryScore... scoresGiven) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.scoresGiven = new HashSet<EntryScore>(Arrays.asList(scoresGiven));
        this.canScore = canScore;
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
    public Set<EntryScore> getScoresGiven() {
        return scoresGiven;
    }

    @Override
    public boolean canScore() {
        return canScore;
    }

    public boolean addScore(EntryScore score) {
        if (this.scoresGiven.contains(score))
            return false;
        this.scoresGiven.add(score);
        return true;
    }

    public boolean removeScore(EntryScore score) {
        if (!this.scoresGiven.contains(score))
            return false;
        this.scoresGiven.remove(score);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Scorer &&
                ((Scorer) obj).getUUID().equals(this.getUUID());
    }

}

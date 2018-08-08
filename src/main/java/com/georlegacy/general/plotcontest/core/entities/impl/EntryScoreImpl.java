package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.EntryScore;
import com.georlegacy.general.plotcontest.core.entities.Scorer;

import java.util.Date;

public class EntryScoreImpl implements EntryScore {

    private final Date dateIssued;
    private final Scorer scorer;
    private final ContestEntry scoredEntry;
    private short score;

    public EntryScoreImpl(Scorer scorer, ContestEntry entry, short score) {
        this.dateIssued = new Date();
        this.scorer = scorer;
        this.scoredEntry = entry;
        this.score = score;
    }

    @Override
    public Date getDateIssued() {
        return dateIssued;
    }

    @Override
    public Scorer getScorer() {
        return scorer;
    }

    @Override
    public ContestEntry getScoredEntry() {
        return scoredEntry;
    }

    @Override
    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EntryScore &&
                ((EntryScore) obj).getScoredEntry().equals(this.getScoredEntry()) &&
                ((EntryScore) obj).getScorer().equals(this.getScorer()) &&
                ((EntryScore) obj).getScore() == this.getScore();
    }

}

package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContestEntryImpl implements ContestEntry {

    private final Set<EntryScore> scores;
    private final ContestCompetitor competitor;
    private final Set<ContestContributor> contributors;
    private final Date dateEntered;
    private final Contest contest;
    private final Set<Judgement> judgements;

    public ContestEntryImpl(ContestCompetitor competitor, Contest contest) {
        this.scores = new HashSet<EntryScore>();
        this.competitor = competitor;
        this.contributors = new HashSet<ContestContributor>();
        this.dateEntered = new Date();
        this.contest = contest;
        this.judgements = new HashSet<Judgement>();
    }

    public ContestEntryImpl(ContestCompetitor competitor, Contest contest, ContestContributor... contributors) {
        this.scores = new HashSet<EntryScore>();
        this.competitor = competitor;
        this.contributors = new HashSet<ContestContributor>(Arrays.asList(contributors));
        this.dateEntered = new Date();
        this.contest = contest;
        this.judgements = new HashSet<Judgement>();
    }

    @Override
    public Set<EntryScore> getScores() {
        return scores;
    }

    @Override
    public ContestCompetitor getCompetitor() {
        return competitor;
    }

    @Override
    public Set<ContestContributor> getContributors() {
        return contributors;
    }

    @Override
    public Date getDateEntered() {
        return dateEntered;
    }

    @Override
    public Contest getContest() {
        return contest;
    }

    @Override
    public Set<Judgement> getJudgements() {
        return judgements;
    }

    public boolean addScore(EntryScore score) {
        if (this.scores.contains(score))
            return false;
        this.scores.add(score);
        return true;
    }

    public boolean removeScore(EntryScore score) {
        if (!this.scores.contains(score))
            return false;
        this.scores.remove(score);
        return true;
    }

    public boolean addContributor(ContestContributor contributor) {
        if (this.contributors.contains(contributor))
            return false;
        this.contributors.add(contributor);
        return true;
    }

    public boolean removeContributor(ContestContributor contributor) {
        if (!this.contributors.contains(contributor))
            return false;
        this.contributors.remove(contributor);
        return true;
    }

    public boolean addJudgement(Judgement judgement) {
        if (this.judgements.contains(judgement))
            return false;
        this.judgements.add(judgement);
        return true;
    }

    public boolean removeJudgement(Judgement judgement) {
        if (!this.judgements.contains(judgement))
            return false;
        this.judgements.remove(judgement);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ContestEntry &&
                ((ContestEntry) obj).getCompetitor().equals(this.getCompetitor()) &&
                ((ContestEntry) obj).getContributors().equals(this.getContributors()) &&
                ((ContestEntry) obj).getContest().equals(this.getContest()) &&
                ((ContestEntry) obj).getDateEntered().equals(this.getDateEntered());
    }

}

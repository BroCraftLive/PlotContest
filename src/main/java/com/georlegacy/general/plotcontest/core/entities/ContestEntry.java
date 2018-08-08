package com.georlegacy.general.plotcontest.core.entities;

import java.util.Date;
import java.util.Set;

public interface ContestEntry {

    Set<EntryScore> getScores();

    ContestCompetitor getCompetitor();

    Set<ContestContributor> getContributors();

    Date getDateEntered();

    Contest getContest();

    Set<Judgement> getJudgements();

    @Override
    boolean equals(Object o);

}

package com.georlegacy.general.plotcontest.core.entities;

import java.util.Date;

public interface EntryScore {

    Date getDateIssued();

    Scorer getScorer();

    ContestEntry getScoredEntry();

    short getScore();

    @Override
    boolean equals(Object o);

}

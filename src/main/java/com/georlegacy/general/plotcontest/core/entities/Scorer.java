package com.georlegacy.general.plotcontest.core.entities;

import java.util.Set;

public interface Scorer {

    String getUUID();

    String getName();

    Set<EntryScore> getScoresGiven();

    boolean canScore();

    @Override
    boolean equals(Object o);

}

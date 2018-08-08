package com.georlegacy.general.plotcontest.core.entities;

import java.util.Set;

public interface ContestCompetitor {

    Set<ContestEntry> getEntries();

    String getUUID();

    String getName();

    boolean canCompete();

    @Override
    boolean equals(Object o);

}

package com.georlegacy.general.plotcontest.core.entities;

import java.util.Set;

public interface Judge {

    Set<Contest> getContestsJudged();

    Set<ContestEntry> getEntriesJudged();

    String getUUID();

    String getName();

    @Override
    boolean equals(Object o);

}

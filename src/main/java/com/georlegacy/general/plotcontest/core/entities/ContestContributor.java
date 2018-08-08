package com.georlegacy.general.plotcontest.core.entities;

import java.util.Set;

public interface ContestContributor {

    Set<ContestEntry> getEntriesContributedTo();

    String getUUID();

    String getName();

    boolean canContribute();

    @Override
    boolean equals(Object o);

}

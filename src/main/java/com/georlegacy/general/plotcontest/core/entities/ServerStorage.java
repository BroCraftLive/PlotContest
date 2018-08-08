package com.georlegacy.general.plotcontest.core.entities;

import java.util.Set;
import java.util.UUID;

public interface ServerStorage {

    Set<Contest> getArchivedContests();

    Set<Contest> getCurrentContests();

    UUID getUID();

    @Override
    boolean equals(Object o);

}

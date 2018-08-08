package com.georlegacy.general.plotcontest.core.entities;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface Contest {

    Set<ContestEntry> getEntries();

    Date getStartDate();

    String getTheme();

    boolean entriesCanHaveContributors();

    Optional<String> getPermission();

    Set<Judge> getJudges();

    @Override
    boolean equals(Object o);

}
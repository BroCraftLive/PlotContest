package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.Contest;
import com.georlegacy.general.plotcontest.core.entities.ServerStorage;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ServerStorageImpl implements ServerStorage {

    private final Set<Contest> archivedContests;
    private final Set<Contest> currentContests;
    private final UUID uid;

    public ServerStorageImpl() {
        this.archivedContests = new HashSet<Contest>();
        this.currentContests = new HashSet<Contest>();
        this.uid = UUID.randomUUID();
    }

    @Override
    public Set<Contest> getArchivedContests() {
        return null;
    }

    @Override
    public Set<Contest> getCurrentContests() {
        return null;
    }

    @Override
    public UUID getUID() {
        return uid;
    }

    public boolean addContest(Contest contest) {
        if (this.currentContests.contains(contest))
            return false;
        this.currentContests.add(contest);
        return true;
    }

    public boolean removeContest(Contest contest) {
        if (!this.currentContests.contains(contest))
            return false;
        this.currentContests.remove(contest);
        return true;
    }

    public boolean deleteContest(Contest contest) {
        if (!this.archivedContests.contains(contest))
            return false;
        this.archivedContests.remove(contest);
        return true;
    }

    public boolean archiveContest(Contest contest) {
        if (!currentContests.contains(contest) || archivedContests.contains(contest))
            return false;
        Optional<Contest> optionalContest = currentContests.stream().filter(c -> c.equals(contest)).findFirst();
        if (!optionalContest.isPresent())
            return false;
        archivedContests.add(optionalContest.get());
        currentContests.remove(contest);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ServerStorage &&
                ((ServerStorage) obj).getUID().equals(this.getUID());
    }

}
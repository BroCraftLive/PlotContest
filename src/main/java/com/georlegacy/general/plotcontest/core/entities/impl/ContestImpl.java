package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.Contest;
import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.Judge;

import java.util.*;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class ContestImpl implements Contest {

    private Optional<String> permission;
    private final Set<ContestEntry> entries;
    private final Date startDate;
    private final String theme;
    private boolean entriesCanHaveContributors;
    private final Set<Judge> judges;

    public ContestImpl(String theme, boolean entriesCanHaveContributors) {
        this.entries = new HashSet<ContestEntry>();
        this.startDate = new Date();
        this.theme = theme;
        this.entriesCanHaveContributors = entriesCanHaveContributors;
        this.permission = Optional.empty();
        this.judges = new HashSet<Judge>();
    }

    public ContestImpl(String theme, String permission, boolean entriesCanHaveContributors) {
        this.entries = new HashSet<ContestEntry>();
        this.startDate = new Date();
        this.theme = theme;
        this.entriesCanHaveContributors = entriesCanHaveContributors;
        this.permission = Optional.of(permission);
        this.judges = new HashSet<Judge>();
    }

    public ContestImpl(String theme, boolean entriesCanHaveContributors, Judge... judges) {
        this.entries = new HashSet<ContestEntry>();
        this.startDate = new Date();
        this.theme = theme;
        this.entriesCanHaveContributors = entriesCanHaveContributors;
        this.permission = Optional.empty();
        this.judges = new HashSet<Judge>(Arrays.asList(judges));
    }

    public ContestImpl(String theme, String permission, boolean entriesCanHaveContributors, Judge... judges) {
        this.entries = new HashSet<ContestEntry>();
        this.startDate = new Date();
        this.theme = theme;
        this.entriesCanHaveContributors = entriesCanHaveContributors;
        this.permission = Optional.of(permission);
        this.judges = new HashSet<Judge>(Arrays.asList(judges));
    }

    @Override
    public Set<ContestEntry> getEntries() {
        return entries;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String getTheme() {
        return theme;
    }

    @Override
    public boolean entriesCanHaveContributors() {
        return entriesCanHaveContributors;
    }

    @Override
    public Optional<String> getPermission() {
        return permission;
    }

    @Override
    public Set<Judge> getJudges() {
        return judges;
    }

    public boolean hasJudges() {
        return !this.judges.isEmpty();
    }

    public boolean hasPermission() {
        return !this.permission.isPresent();
    }

    public void setEntriesCanHaveContributors(boolean entriesCanHaveContributors) {
        this.entriesCanHaveContributors = entriesCanHaveContributors;
    }

    public void setPermission(String permission) {
        this.permission = Optional.of(permission);
    }

    public boolean removeJudge(Judge judge) {
        if (!this.judges.contains(judge))
            return false;
        this.judges.remove(judge);
        return true;
    }

    public boolean addJudge(Judge judge) {
        if (this.judges.contains(judge))
            return false;
        this.judges.add(judge);
        return true;
    }

    public boolean removeEntry(ContestEntry entry) {
        if (!this.entries.contains(entry))
            return false;
        this.entries.remove(entry);
        return true;
    }

    public boolean addEntry(ContestEntry entry) {
        if (this.entries.contains(entry))
            return false;
        this.entries.add(entry);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Contest &&
                ((Contest) obj).getStartDate().equals(this.getStartDate()) &&
                ((Contest) obj).getTheme().equals(this.getTheme());
    }

}
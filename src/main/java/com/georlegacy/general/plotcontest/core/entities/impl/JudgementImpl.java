package com.georlegacy.general.plotcontest.core.entities.impl;

import com.georlegacy.general.plotcontest.core.entities.ContestEntry;
import com.georlegacy.general.plotcontest.core.entities.Judge;
import com.georlegacy.general.plotcontest.core.entities.Judgement;

import java.util.Date;

public class JudgementImpl implements Judgement {

    private final Date judgementDate;
    private final Judge judge;
    private final ContestEntry judgedEntry;
    private short score;

    public JudgementImpl(Judge judge, ContestEntry judgedEntry, short score) {
        this.judgementDate = new Date();
        this.judge = judge;
        this.judgedEntry = judgedEntry;
        this.score = score;
    }

    @Override
    public Date getJudgementDate() {
        return judgementDate;
    }

    @Override
    public Judge getJudge() {
        return judge;
    }

    @Override
    public ContestEntry getEntryJudged() {
        return judgedEntry;
    }

    @Override
    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Judgement &&
                ((Judgement) obj).getEntryJudged().equals(this.getEntryJudged()) &&
                ((Judgement) obj).getJudge().equals(this.getJudge()) &&
                ((Judgement) obj).getScore() == this.getScore();
    }

}

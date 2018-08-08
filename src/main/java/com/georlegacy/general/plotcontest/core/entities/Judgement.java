package com.georlegacy.general.plotcontest.core.entities;

import java.util.Date;

public interface Judgement {

    Date getJudgementDate();

    Judge getJudge();

    ContestEntry getEntryJudged();

    short getScore();

    @Override
    boolean equals(Object o);

}

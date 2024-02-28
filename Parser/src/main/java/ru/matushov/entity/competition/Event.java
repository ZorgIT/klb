package ru.matushov.entity.competition;

import ru.matushov.entity.runner.KlbRunner;
import ru.matushov.entity.runner.Runner;

import java.util.List;

public interface Event {
    String getClubPageURL();

    String getPeriod();

    String getTotalPoints();
    String getRunnerCount();
    List<KlbRunner> getRunners();

}

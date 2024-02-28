package ru.matushov.entity.competition;

import lombok.Data;
import ru.matushov.entity.race.KlbmImpl;
import ru.matushov.entity.runner.KlbRunner;

import java.util.List;

@Data
public class CompetitionImpl implements Event {
    String clubPageURL;
    String period;
    String runnerCount;
    String totalPoints;
    List<KlbRunner> runners;
}

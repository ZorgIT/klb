package ru.matushov.entity.competition;

import lombok.Data;

@Data
public class CompetitionImpl implements Event {
    String clubPageURL;
    String period;
    String runnerCount;
    String totalPoints;
}

package ru.matushov.entity.club;

import ru.matushov.entity.competition.Event;

import java.util.List;

public interface Club {
    String getName();

    String getEmail();

    String getContact();

    String getBased();

    List<Event> getCompetitions();
}

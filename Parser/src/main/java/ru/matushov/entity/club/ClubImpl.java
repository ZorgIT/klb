package ru.matushov.entity.club;

import lombok.Data;
import ru.matushov.entity.competition.Event;

import java.util.List;

@Data
public class ClubImpl implements Club {
    String name;
    String email;
    String contact;
    String based;
    List<Event> competitions;
}

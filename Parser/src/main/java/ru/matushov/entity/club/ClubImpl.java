package ru.matushov.entity.club;

import lombok.Data;
import ru.matushov.entity.competition.CompetitionImpl;
import ru.matushov.entity.competition.Event;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClubImpl implements Club {
    String name;
    String email;
    String contact;
    String based;
    List<CompetitionImpl> competitions;
    //TODO Сет со всеми бегунами участвовавшими в составе клуба и принесшими
    // результат.
}

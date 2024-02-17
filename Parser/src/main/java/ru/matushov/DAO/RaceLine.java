package ru.matushov.DAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RaceLine {
    String date;
    String eventName;
    String city;
    String distance;
    String result;
    String points;
    String bonuses;
}

package ru.matushov.DAO;

import lombok.*;
import ru.matushov.parsers.Utils;

import java.util.Date;

@Data
public class KlbmRaceData implements RaceLine {
    Date date;
    String eventName;
    String city;
    String distance;
    String result;
    String points;
    String bonuses;

    public void setDate(String txt) {
        this.date = Utils.parseDate(txt);
    }
    public void setResult(String txt) {

    }

}

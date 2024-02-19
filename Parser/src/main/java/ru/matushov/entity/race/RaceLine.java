package ru.matushov.entity.race;


import java.util.Date;

public interface RaceLine {
    Date getDate();

    String getEventName();

    String getCity();

    String getDistance();

    String getResult();

    String getPoints();

    String getBonuses();
    Integer getIdBonusOwner(); //id клуба в матче которому присвоены балы

}

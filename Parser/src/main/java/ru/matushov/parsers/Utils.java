package ru.matushov.parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date parseDate(String dateString) {
        // возможные строки {"29.07 2023 год", "30.07 2022 год", "12.12.2021 2020/21 год"};
        //:TODO проверить на большей выборке, можно отбросить все символы и обрезать по кол-ву без разделителей.
        SimpleDateFormat simpleDateFormat;
        String cleanedDate = dateString.replaceAll("[^\\d.]", "");
        // Разбиваем строку по пробелу и берем первый элемент
        String datePart = cleanedDate.split("\\s+")[0];
        // Если длина строки больше 10 символов, обрезаем до 10 символов
        if (datePart.length() > 10) {
            datePart = datePart.substring(0, 10);
            simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        } else {
            simpleDateFormat = new SimpleDateFormat("dd.MMyyyy");
        }

        try {
            Date date = simpleDateFormat.parse(datePart);
            return date;
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга даты: " + e.getMessage());
        }
        return null;
    }
}

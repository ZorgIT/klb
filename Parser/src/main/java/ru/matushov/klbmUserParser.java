package ru.matushov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.matushov.DAO.klbmRaceData;

import java.util.ArrayList;
import java.util.List;

public class klbmUserParser {
    public static List<klbmRaceData> parse(String url) {

        List<klbmRaceData> raceDatas = new ArrayList<>();
        try {
            var pageData = Jsoup.connect(url).userAgent("Chrome/121.0.6167.185")
                    .referrer("http://www.google.com")
                    .get();
            // Парсим страницу на таблицу с забегами
            Elements lines = pageData.select("table.table.table-condensed.table-hover tr");
            String matchPeriod = ""; // Переменная для хранения текущего года при парсинге
            for (Element line : lines) {
                // Проверяем, является ли текущая строка с информацией о годе
                if (line.select("th").size() == 1) {
                    // Извлекаем год из строки
                    matchPeriod = line.select("th").text();
                    continue;
                } else if (line.select("td:nth-child(2)").text().equals("")) {
                    continue;
                }
                klbmRaceData raceData = new klbmRaceData();
                //Извлекаем данные по каждому забегу
                raceData.setDate(line.select("td:nth-child(2)").text() + " " + matchPeriod);
                raceData.setEventName(line.select("td:nth-child(3) a").text());
                raceData.setCity(line.select("td:nth-child(4)").text());
                raceData.setDistance(line.select("td:nth-child(5) a").text());
                raceData.setResult(line.select("td:nth-child(6)").text());
                raceData.setPoints(line.select("td:nth-child(7)").text());
                raceData.setBonuses(line.select("td:nth-child(8)").text());
                raceDatas.add(raceData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return raceDatas;
    }
}

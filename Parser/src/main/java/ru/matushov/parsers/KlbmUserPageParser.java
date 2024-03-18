package ru.matushov.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.matushov.entity.race.KlbmImpl;

import java.util.ArrayList;
import java.util.List;

/*
page example https://probeg.org/klb/person/8219/
 */
public class KlbmUserPageParser {
    public static List<KlbmImpl> parse(Document klbRunner) {

        List<KlbmImpl> racesData = new ArrayList<>();
        try {
            Elements lines = klbRunner.select("table.table.table-condensed.table-hover tr");
            racesData = processTable(lines);
        } catch (Exception e) {
            System.err.println("Ошибка парсинга данных со страницы:" + klbRunner.baseUri());
            e.printStackTrace();
        }
        return racesData;
    }

    public static String parseSurname(Document klbRunner) {
        klbRunner.getElementsByClass("col-md-12").first().text();
        //TODO finalize method
        String surname =
                klbRunner.getElementsByClass("col-md-12").first().child(1).text();

        return surname;

    }

    private static List<KlbmImpl> processTable(Elements lines) {
        List<KlbmImpl> racesData = new ArrayList<>();
        String matchPeriod = ""; // Переменная для хранения текущего года при парсинге
        for (Element line : lines) {
            // проверка на год или шапку таблицы
            if (line.select("th").size() == 1) {
                matchPeriod = line.select("th").text();
                continue;
            } else if (line.select("td:nth-child(2)").text().equals("")) {
                continue;
            }
            KlbmImpl raceData = new KlbmImpl();
            //Извлекаем данные по каждому забегу
            raceData.setDate(line.select("td:nth-child(2)").text() + " " + matchPeriod);
            raceData.setEventName(line.select("td:nth-child(3) a").text());
            raceData.setCity(line.select("td:nth-child(4)").text());
            raceData.setDistance(line.select("td:nth-child(5) a").text());
            raceData.setResult(line.select("td:nth-child(6)").text());
            raceData.setPoints(line.select("td:nth-child(7)").text());
            raceData.setBonuses(line.select("td:nth-child(8)").text());
            racesData.add(raceData);
        }
        return racesData;
    }
}



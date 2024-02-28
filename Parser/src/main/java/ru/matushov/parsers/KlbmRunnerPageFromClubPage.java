package ru.matushov.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.matushov.entity.race.KlbmImpl;
import ru.matushov.entity.runner.KlbRunner;
import ru.matushov.entity.runner.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
https://probeg.org/klb/team/1359/
 */
public class KlbmRunnerPageFromClubPage {
    public static List<KlbRunner> parse(Document klbmTeam) {
        List<KlbRunner> runners = new ArrayList<>();
        try {
            Elements lines = klbmTeam.select("table.table.table-condensed.table-hover tr");
            runners = processTable(lines);
        } catch (Exception e) {
            System.err.println("Ошибка парсинга данных со страницы:");
            e.printStackTrace();
        }
        return runners;
    }

    private static List<KlbRunner> processTable(Elements lines) {
        List<KlbRunner> runners = new ArrayList<>();
        for (Element line : lines) {
            // проверка на год или шапку таблицы
            if (!line.getElementsByClass("info").isEmpty()) {
                continue;
            }
            KlbRunner runner = new KlbRunner();
            //Извлекаем данные по каждому бегуну
            runner.setKlbmPage("https://probeg.org" + (line.select("a[href" +
                    "^=/klb/person/]").attr("href")));

            String personal = line.select("a[href^=/user/]").attr("href");
            runner.setPersonalPage("https://probeg.org" + personal);
            runner.setBirthday((line.select("td:nth-child(3)").text()));
            /*
            runner.setDate(line.select("td:nth-child(2)").text() + " " + matchPeriod);
            runner.setEventName(line.select("td:nth-child(3) a").text());
            runner.setCity(line.select("td:nth-child(4)").text());
            runner.setDistance(line.select("td:nth-child(5) a").text());
            runner.setResult(line.select("td:nth-child(6)").text());
            runner.setPoints(line.select("td:nth-child(7)").text());
            runner.setBonuses(line.select("td:nth-child(8)").text());
            */
            runners.add(runner);
        }
        return runners;
    }

}

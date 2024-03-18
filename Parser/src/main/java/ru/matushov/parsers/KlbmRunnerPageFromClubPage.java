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
пример разбираемой страницы - вытаскивает таблицу бегунов из соревнования
https://probeg.org/klb/team/1359/
 */
public class KlbmRunnerPageFromClubPage {
    public static List<KlbRunner> parse(Document klbmTeam) {
        List<KlbRunner> runners = new ArrayList<>();
        try {
            Element table = klbmTeam.selectFirst("div.col-md-5");
            Elements lines = table.select("table.table.table-condensed" +
                    ".table-hover tr");
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
            // проверка на шапку
            if (!line.getElementsByClass("info").isEmpty()) {
                continue;
            }
            KlbRunner runner = new KlbRunner();
            //Извлекаем данные по каждому бегуну
            runner.setKlbmPage("https://probeg.org" + (line.select("a[href" +
                    "^=/klb/person/]").attr("href")));

            String personal = line.select("a[href^=/user/]").attr("href");
            if (personal.length() > 3) {
                runner.setPersonalPage("https://probeg.org" + personal);
            }
            runner.setBirthday((line.select("td:nth-child(3)").text()));

            String[] name = (line.select("td:nth-child(2)").text()).split(" ");
            if (name.length > 1) {
                runner.setFirstname(name[1]);
                runner.setLastname(name[0]);
            }
            runners.add(runner);
        }
        return runners;
    }

}

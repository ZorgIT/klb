package ru.matushov.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.matushov.entity.competition.CompetitionImpl;

import java.util.ArrayList;
import java.util.List;

/*
page example https://probeg.org/club/208/
 */
public class CompetitionFromClubPage {
    public static List parse(Document clubPage) {
        List<CompetitionImpl> competitions = new ArrayList<>();
        try {
            Elements lines = clubPage.select("table.table.table-condensed.table-hover tr");
            competitions = processTable(lines);

        } catch (Exception e) {
            System.err.println("Ошибка парсинга данных со страницы:" + clubPage);
            e.printStackTrace();
        }
        return competitions;

    }

    public static List<CompetitionImpl> processTable(Elements lines) {
        List<CompetitionImpl> competitions = new ArrayList<>();
        String matchPeriod = "";
        for (Element line : lines) {
            if (line.select("th").size() == 1) {
                matchPeriod = line.select("th").text();
                continue;
            } else if (line.select("td:nth-child(2)").text().equals("")) {
                continue;
            }
            CompetitionImpl event = new CompetitionImpl();
            event.setClubPageURL("https://probeg.org" + (line.select("td:nth-child(1) a").attr("href")));
            event.setRunnerCount((line.select("td:nth-child(2)").text()));
            event.setTotalPoints((line.select("td:nth-child(4)").text()));
            event.setPeriod(matchPeriod);
            competitions.add(event);
        }
        return competitions;
    }
}

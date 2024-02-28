package ru.matushov.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.matushov.entity.club.Club;
import ru.matushov.entity.club.ClubImpl;

/*
page example https://probeg.org/club/208/
 */
public class ClubInfoFromClubPage {
    public static Club parse(Document clubPage) {
        ClubImpl club = new ClubImpl();
        try {
            club.setName(clubPage.getElementsByTag("h3").first().text());
            club.setEmail(clubPage.select("a[href*=mailto]").attr("href").substring(7));
            Elements dataTable = clubPage.getElementsByClass("col-md-6");
            //TODO указаны конкретные поля, абстрагировать
            club.setContact(dataTable.get(0).childNode(5).toString());
            //TODO указаны конкретные поля, абстрагировать
            club.setBased(dataTable.get(0).childNode(7).toString());
        } catch (Exception e) {
            System.err.println("Получены не полные данные");
        }
        return club;
    }
}
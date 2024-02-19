package ru.matushov;

import org.jsoup.Jsoup;
import ru.matushov.parsers.ClubInfoFromClubPage;
import ru.matushov.parsers.CompetitionFromClubPage;
import ru.matushov.parsers.KlbmUserPageParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        var competitionsPageData = CompetitionFromClubPage.parse("https://probeg.org/club/208/");
        competitionsPageData.forEach(System.out::println);

        var clubPageData = ClubInfoFromClubPage.parse(Jsoup.connect("https://probeg.org/club/208/")
                .userAgent("Chrome/121.0.6167.185")
                .referrer("http://www.google.com")
                .get());



//        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9985/");
//        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9046/");
//        klbmUserPageData.forEach(System.out::println);
    }
}

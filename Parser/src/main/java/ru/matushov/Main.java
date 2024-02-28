package ru.matushov;

import org.jsoup.Jsoup;
import ru.matushov.parsers.ClubInfoFromClubPage;
import ru.matushov.parsers.CompetitionFromClubPage;
import ru.matushov.parsers.KlbmRunnerPageFromClubPage;
import ru.matushov.parsers.KlbmUserPageParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


//        var competitionsPageData = CompetitionFromClubPage.parse("https://probeg.org/club/208/");
//        competitionsPageData.forEach(System.out::println);

//        var clubPageData = ClubInfoFromClubPage.parse(Jsoup.connect("https://probeg.org/club/208/")
//                .userAgent("Chrome/121.0.6167.185")
//                .referrer("http://www.google.com")
//                .get());
//        System.out.println(clubPageData);

        var klbmclubPageData = KlbmRunnerPageFromClubPage.parse(Jsoup.connect(
                "https://probeg.org/klb/team/1452/")
                .userAgent("Chrome/121.0.6167.185")
                .referrer("http://www.google.com")
                .get());
        System.out.println(klbmclubPageData);




//        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9985/");
//        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9046/");
//        klbmUserPageData.forEach(System.out::println);
    }
}

/*
Document doc = Jsoup.connect(url).get()  парсить с жестокго диска - .parse(File())

Element  fff = postDetailsDoc.getElementsByClass ("classname").first().child()
//first - первый элемент, child - на сколько дочерних элементов спуститься вниз
далее с fff елемента можно снять аттрибуты - .txt илил .href.

Elements ffa = doc.select("a"); -получить все ссылки на странице
Elements ffa = doc.select("a.classname"); -получить все ссылки на странице с определенным классом
(#навание) - по id
foreach Elements - перебирать элементы
    element.attr("href") - каждая ссылка
 */
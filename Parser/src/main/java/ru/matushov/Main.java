package ru.matushov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.matushov.entity.club.Club;
import ru.matushov.entity.club.ClubImpl;
import ru.matushov.entity.competition.CompetitionImpl;
import ru.matushov.entity.competition.Event;
import ru.matushov.entity.runner.KlbRunner;
import ru.matushov.parsers.ClubInfoFromClubPage;
import ru.matushov.parsers.CompetitionFromClubPage;
import ru.matushov.parsers.KlbmRunnerPageFromClubPage;
import ru.matushov.parsers.KlbmUserPageParser;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

import static ru.matushov.parsers.Utils.getDoc;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        1) Создаем объект клуб
        2) Наполняем базовой информацией с главной страницы https://probeg
        .org/club/208/ (пример клуб СС)
        3) Парсим главную страницу клуба https://probeg.org/club/208/,
        получаем перечень прошедших КЛБ-матчей (10 шт. для СС)
        4) Для каждого из КЛБ-Матчей
        Проходим по каждому клб-матчу(евент), получаем список бегунов в
        каждом периоде. и присваиваем их клубу.


        :TODO вытащить отчество бегуна
        :TODO создать отдельный список бегунов когда-либо участвовавших в
          составе  КЛБ СС
         */

        Document clubMainPage = getDoc("https://probeg.org/club/208/");

        ClubImpl club = ClubInfoFromClubPage.parse(clubMainPage);
        club.setCompetitions(CompetitionFromClubPage.parse(clubMainPage));
        for (CompetitionImpl event : club.getCompetitions()) {
            String klbmURL = event.getClubPageURL();//каждый матч
            Document klbmcur = getDoc(klbmURL);
            List<KlbRunner> runners =
                    KlbmRunnerPageFromClubPage.parse(klbmcur);
            event.setRunners(runners);
        }

        System.out.println(club.toString());
    }
}

/*
        var competitionsPageData = CompetitionFromClubPage.parse("https://probeg.org/club/208/");
        competitionsPageData.forEach(System.out::println);
*/

/*
        var clubPageData = ClubInfoFromClubPage.parse(Jsoup.connect("https://probeg.org/club/208/")
                .userAgent("Chrome/121.0.6167.185")
                .referrer("http://www.google.com")
                .get());
        System.out.println(clubPageData);
*/

/*
        var klbmclubPageData = KlbmRunnerPageFromClubPage.parse(Jsoup.connect(
                "https://probeg.org/klb/team/1452/")
                .userAgent("Chrome/121.0.6167.185")
                .referrer("http://www.google.com")
                .get());
        System.out.println(klbmclubPageData);
*/

/*
        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9985/");
        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9046/");
        klbmUserPageData.forEach(System.out::println);
*/

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
package ru.matushov.parsers;

import org.jsoup.nodes.Document;
import ru.matushov.entity.club.Club;
import ru.matushov.entity.club.ClubImpl;

public class ClubInfoFromClubPage {
    public static Club parse(Document clubPage) {
        ClubImpl club = new ClubImpl();
        try {
            club.setName(clubPage.select("h1").first().text());
            club.setEmail(clubPage.select("a[href*=mailto]").attr("href").substring(7));
            club.setContact(clubPage.select(":containsOwn(Телефон)")
                    .first().siblingElements().get(0).ownText().trim());
            club.setBased(clubPage.select(":containsOwn(Дата создания)").first().ownText().split(": ")[1].trim());
            //            clubPage.select("a[href*=vk.com]").attr("href");
        } catch (Exception e) {
            System.err.println("Ошибка получения данных о клубе:");
            e.printStackTrace();
        }
        return club;
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
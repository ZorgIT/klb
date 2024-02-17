package ru.matushov;

import ru.matushov.parsers.KlbmUserPageParser;

public class Main {
    public static void main(String[] args) {
//        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9985/");
        var klbmUserPageData = KlbmUserPageParser.parse("https://probeg.org/klb/person/9046/");
        klbmUserPageData.forEach(System.out::println);
    }
}

package ru.matushov;

public class Main {
    public static void main(String[] args) {
        var pageData2 = klbmUserParser.parse("https://probeg.org/klb/person/9985/");
        pageData2.forEach(System.out::println);
    }
}

package ru.matushov.entity.runner;

import lombok.Data;

@Data
public class KlbRunner implements Runner {
    String firstname;
    String lastname;
    String surname;
    String birthday;
    String personalPage;
    String klbmPage;
}

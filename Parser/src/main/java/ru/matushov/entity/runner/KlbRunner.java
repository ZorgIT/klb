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

    @Override
    public String toString() {
        return "KlbRunner{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", personalPage='" + personalPage + '\'' +
                ", klbmPage='" + klbmPage + '\'' +
                '}' + "\n";
    }
}

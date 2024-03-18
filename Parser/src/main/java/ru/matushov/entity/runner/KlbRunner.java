package ru.matushov.entity.runner;

import lombok.Data;
import ru.matushov.entity.race.KlbmImpl;

import java.util.List;

@Data
public class KlbRunner implements Runner {
    String firstname;
    String lastname;
    String surname;
    String birthday;
    String personalPage;
    String klbmPage;
    List<KlbmImpl> klmbRaces;

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

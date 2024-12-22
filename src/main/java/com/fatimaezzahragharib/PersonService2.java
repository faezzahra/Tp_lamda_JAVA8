package com.fatimaezzahragharib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService2 {

    // Nouvelle méthode pour filtrer les adultes
    public static List<Person> getAdultsOver21() {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Alice", "Smith", LocalDate.of(1990, 5, 12), "10 Rue des Roses"),
            new Person("John", "Doe", LocalDate.of(2005, 7, 21), "50 Rue des Lilas"),
            new Person("Emily", "Johnson", LocalDate.of(1980, 3, 9), "10 Rue des Roses")
        );
        Predicate<Person> isAdult = person -> person.calculateAge() >= 21;
        return mockPersonsDatabase.stream()
                                  .filter(isAdult)
                                  .collect(Collectors.toList());
    }
}

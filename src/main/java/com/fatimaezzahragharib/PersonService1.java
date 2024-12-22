package com.fatimaezzahragharib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService1 {

    // Méthode pour trouver les personnes par adresse
    public static List<Person> findByLocation(String location) {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Sofia", "Martin", LocalDate.of(1992, 4, 18), "10 Avenue des Fleurs"),
            new Person("Liam", "Durand", LocalDate.of(2001, 7, 22), "22 Rue des Écoles"),
            new Person("Emma", "Lopez", LocalDate.of(1989, 9, 10), "10 Avenue des Fleurs")
        );
        Predicate<Person> hasLocation = person -> person.getAddress().equals(location);
        return mockPersonsDatabase.stream()
                                  .filter(hasLocation)
                                  .collect(Collectors.toList());
    }

    // Méthode pour trouver les adultes
    public static List<Person> getAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Sofia", "Martin", LocalDate.of(1992, 4, 18), "10 Avenue des Fleurs"),
            new Person("Liam", "Durand", LocalDate.of(2001, 7, 22), "22 Rue des Écoles"),
            new Person("Emma", "Lopez", LocalDate.of(1989, 9, 10), "33 Boulevard des Champs")
        );
        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;
        return mockPersonsDatabase.stream()
                                  .filter(isAdult)
                                  .collect(Collectors.toList());
    }
}





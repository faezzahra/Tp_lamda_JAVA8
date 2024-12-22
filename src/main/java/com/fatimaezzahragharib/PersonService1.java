package com.fatimaezzahragharib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService1 {
    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
            new Person("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B"),
            new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "123 Rue A")
        );
        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);
        return mockPersonsDatabase.stream()
                                  .filter(hasAddress)
                                  .collect(Collectors.toList());
    }

    public static List<Person> filterAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
            new Person("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B"),
            new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "789 Rue C")
        );
        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;
        return mockPersonsDatabase.stream()
                                  .filter(isAdult)
                                  .collect(Collectors.toList());
    }
}

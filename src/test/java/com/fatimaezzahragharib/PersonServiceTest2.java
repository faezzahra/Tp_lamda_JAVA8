package com.fatimaezzahragharib;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.function.Predicate;  // Ajout de l'import de Predicate
import java.util.stream.Collectors;  // Ajout de l'import de Collectors

public class PersonServiceTest2 {

    // Nouvelle méthode pour filtrer les personnes par adresse dans le test
    public static List<Person> findPeopleAtAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Alice", "Smith", LocalDate.of(1990, 5, 12), "10 Rue des Roses"),
            new Person("John", "Doe", LocalDate.of(2005, 7, 21), "50 Rue des Lilas"),
            new Person("Emily", "Johnson", LocalDate.of(1980, 3, 9), "10 Rue des Roses")
        );
        // Correction de l'import de Predicate et du code associé
        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);
        return mockPersonsDatabase.stream()
                                  .filter(hasAddress)
                                  .collect(Collectors.toList());
    }

    @Test
    public void testFindPeopleAtAddress() {
        List<Person> peopleAt10RueDesRoses = findPeopleAtAddress("10 Rue des Roses");
        List<Person> expectedPeopleAt10RueDesRoses = Arrays.asList(
            new Person("Alice", "Smith", LocalDate.of(1990, 5, 12), "10 Rue des Roses"),
            new Person("Emily", "Johnson", LocalDate.of(1985, 3, 9), "10 Rue des Roses")
        );
        assertThat(peopleAt10RueDesRoses).containsExactlyElementsOf(expectedPeopleAt10RueDesRoses);
    }

    @Test
    public void testGetAdultsOver21() {
        List<Person> adultsOver21 = PersonService2.getAdultsOver21();
        List<Person> expectedAdultPersons = Arrays.asList(
            new Person("Alice", "Smith", LocalDate.of(1990, 5, 12), "10 Rue des Roses"),
            new Person("Emily", "Johnson", LocalDate.of(1980, 3, 9), "10 Rue des Roses")
        );
        assertThat(adultsOver21).containsExactlyElementsOf(expectedAdultPersons);
    }
}

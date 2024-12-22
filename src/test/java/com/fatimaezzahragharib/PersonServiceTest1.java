package com.fatimaezzahragharib;

import org.junit.Test; // Import de JUnit 4
import static org.assertj.core.api.Assertions.assertThat; // Import de AssertJ
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;

public class PersonServiceTest1 {

    @Test
    public void testFindByLocation() {
        // Test de la méthode findByLocation
        List<Person> peopleLivingIn10AvenueDesFleurs = PersonService1.findByLocation("10 Avenue des Fleurs");
        
        List<Person> expectedPersonsLivingIn10AvenueDesFleurs = Arrays.asList(
            new Person("Sofia", "Martin", LocalDate.of(1992, 4, 18), "10 Avenue des Fleurs"),
            new Person("Emma", "Lopez", LocalDate.of(1989, 9, 10), "10 Avenue des Fleurs")
        );

        // Vérification avec AssertJ
        assertThat(peopleLivingIn10AvenueDesFleurs)
            .containsExactlyElementsOf(expectedPersonsLivingIn10AvenueDesFleurs);
    }

    @Test
    public void testGetAdults() {
        // Test de la méthode getAdults
        List<Person> adults = PersonService1.getAdults();
        
        List<Person> expectedAdultPersons = Arrays.asList(
            new Person("Sofia", "Martin", LocalDate.of(1992, 4, 18), "10 Avenue des Fleurs"),
            new Person("Emma", "Lopez", LocalDate.of(1989, 9, 10), "33 Boulevard des Champs")
        );

        // Vérification avec AssertJ
        assertThat(adults).containsExactlyElementsOf(expectedAdultPersons);
    }
}

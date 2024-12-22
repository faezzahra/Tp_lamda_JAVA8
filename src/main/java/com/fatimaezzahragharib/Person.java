package com.fatimaezzahragharib;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;

    public Person(String firstName, String lastName, LocalDate birthDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
package com.project.ita5.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    @Transient
    public static final String SEQUENCE_NAME = "persons_sequence";

    @Id
    private String id;
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message = "Name must be 1-100 characters long")
    private String name;
    @NotBlank(message = "Surname is required")
    @Size(min = 1, max = 100, message = "Surname must be 1-100 characters long")
    private String surname;
    @NotBlank(message = "Phone is required")
    @Size(max = 12, message = "Max length is 12 characters")
    @Pattern(
            regexp = "^\\+?[0-9]+$",
            message = "Phone number should be vaild"
    )
    private String phone;
    @Size(max = 100, message = "Max length is 100 characters")
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @Size(max = 150, message = "Max length is 150 characters")
    private String uni;
    @NotBlank(message = "Contract is required")
    private boolean contract;

    private ApplicationExtra extra;

    public Person(String id, @NotBlank(message = "Name is required") @Size(min = 1, max = 100, message = "Name must be 1-100 characters long") String name, @NotBlank(message = "Surname is required") @Size(min = 1, max = 100, message = "Surname must be 1-100 characters long") String surname, @NotBlank(message = "Phone is required") @Pattern(
            regexp = "^\\+?[0-9]+$",
            message = "Phone number should be vaild"
    ) String phone, @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email, String uni, boolean contract, ApplicationExtra extra) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.uni = uni;
        this.contract = contract;
        this.extra = extra;
    }

    public Person() {
    }

    public Person(Person person, ApplicationExtra extra) {
        this.id = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.email = person.getEmail();
        this.phone = person.getPhone();
        this.uni = person.getUni();
        this.contract = person.getContract();
        this.extra = extra;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUni() {
        return uni;
    }

    public boolean getContract() {
        return contract;
    }

    public ApplicationExtra getExtra() {
        return extra;
    }
}

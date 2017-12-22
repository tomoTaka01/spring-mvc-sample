package com.example.springmvcsample.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonForm {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Max(100)
    private Integer age;

    @Past
    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate birthDay;

    @Digits(integer = 10, fraction = 0)
    @NumberFormat(pattern = "#,###")
    private BigDecimal salary;

    public PersonForm() {
    }

    public PersonForm(String firstName, String lastName, Integer age, LocalDate birthDay, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", salary=" + salary +
                '}';
    }
}

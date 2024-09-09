package com.auluttam.DataValidationInSpringBoot;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Student {

    @NotNull(message = "Roll number cannot be null")
    @Max(value = 100, message = "Roll number must not exceed 100")
    @Positive(message = "Roll number must be a positive number")
    private int roll;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 10, min = 1, message = "Name must be between 1 and 10 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    public Student() {}

    // Getters and setters with validation annotations

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}

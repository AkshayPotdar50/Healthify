package com.healthify.service.patientservice.dto;

import com.healthify.service.patientservice.entity.Gender;
import com.healthify.service.patientservice.entity.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private String phone;
    private LocalDate dob;
    private Gender gender;
    private String address;

    // Getters and setters

    public Patient toEntity() {
        Patient patient = new Patient();
        patient.setName(this.name);
        patient.setEmail(this.email);
        patient.setPhone(this.phone);
        patient.setDob(this.dob);
        patient.setGender(this.gender);
        patient.setAddress(this.address);
        patient.setActive(true);
        return patient;
    }
}

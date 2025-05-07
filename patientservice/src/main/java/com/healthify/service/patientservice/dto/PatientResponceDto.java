package com.healthify.service.patientservice.dto;

import com.healthify.service.patientservice.entity.Gender;
import com.healthify.service.patientservice.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PatientResponceDto {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private LocalDate dob;
    private Gender gender;
    private String address;


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

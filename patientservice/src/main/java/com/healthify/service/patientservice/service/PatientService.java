package com.healthify.service.patientservice.service;

import com.healthify.service.patientservice.dto.PatientRequestDto;
import com.healthify.service.patientservice.dto.PatientResponceDto;

import java.util.UUID;

public interface PatientService {
    PatientResponceDto createPatient(PatientRequestDto request);
    PatientResponceDto getPatientById(UUID id);
    PatientResponceDto updatePatient(UUID id, PatientRequestDto request);
    void deletePatient(UUID id);

}

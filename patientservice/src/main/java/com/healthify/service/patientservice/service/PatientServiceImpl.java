package com.healthify.service.patientservice.service;

import com.healthify.service.patientservice.dto.PatientRequestDto;
import com.healthify.service.patientservice.dto.PatientResponceDto;
import com.healthify.service.patientservice.entity.Patient;
import com.healthify.service.patientservice.exception.PatientNotFoundException;
import com.healthify.service.patientservice.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;


    @Override
    public PatientResponceDto createPatient(PatientRequestDto request) {
        Patient patient=new Patient();
        BeanUtils.copyProperties(request, patient);
        repository.save(patient);
        return toDTO(patient);
    }

    @Override
    public PatientResponceDto getPatientById(UUID id) {
        Patient patient=repository.findById(id)
                .orElseThrow(()->new PatientNotFoundException(id));
        return toDTO(patient);
    }

    @Override
    public PatientResponceDto updatePatient(UUID id, PatientRequestDto request) {
        Patient patient= repository.findById(id)
                .orElseThrow(()->new PatientNotFoundException(id));
        BeanUtils.copyProperties(request, patient, "id");
        repository.save(patient);
        return toDTO(patient);
    }

    @Override
    public void deletePatient(UUID id) {
        Patient patient=repository.findById(id)
                .orElseThrow(()->new PatientNotFoundException(id));
        patient.setActive(false);
        repository.save(patient);

    }

    private PatientResponceDto toDTO(Patient patient) {
        PatientResponceDto dto = new PatientResponceDto();
        BeanUtils.copyProperties(patient, dto);
        return dto;
    }

}

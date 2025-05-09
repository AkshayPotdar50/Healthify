package com.healthify.service.patientservice.repository;

import com.healthify.service.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {


    Optional<Patient> findByEmail(String email);
}

package com.healthify.service.patientservice.exception;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(UUID id){
        super("patient not found with given id"+id);
    }
}

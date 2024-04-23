package com.peytosoft.PatientService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.peytosoft.PatientService.Dao.PatientDao;
import com.peytosoft.PatientService.Model.Patient;

public class PatientService {
	
	@Autowired
	PatientDao patientDao;

	public ResponseEntity<List<Patient>> getAllPatient() {
		try {
            return new ResponseEntity<>(patientDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Patient> getpatientBypatientId(Integer patientId) {
		try {
            return new ResponseEntity<>(patientDao.findByPatientId(patientId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> createPatient(Patient patient) {
		patientDao.save(patient);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

}

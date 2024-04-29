package com.peytosoft.PatientService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peytosoft.PatientService.Model.Patient;
import com.peytosoft.PatientService.Service.PatientService;



@RestController
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("allPatient")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return patientService.getAllPatient();
    }
	
	@GetMapping("patientId/{patientId}")
	public ResponseEntity<Patient> getpatientBypatientId(@PathVariable Integer patientId){
	    return patientService.getpatientBypatientId(patientId);
	}
	
	@PostMapping("addPatient")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }
	

}

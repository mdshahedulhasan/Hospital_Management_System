package com.peytosoft.DoctorService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.peytosoft.DoctorService.Dao.DoctorDao;
import com.peytosoft.DoctorService.Model.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	DoctorDao doctorDao;

	public ResponseEntity<String> addDoctor(Doctor doctor) {
		doctorDao.save(doctor);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<Doctor> getDoctorBydoctorId(Integer doctorId) {
		try {
            return new ResponseEntity<>(doctorDao.findByDoctorId(doctorId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Doctor> getDoctorByfirstName(String firstName) {
		try {
            return new ResponseEntity<>(doctorDao.findByFirstName(firstName), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Doctor> getDoctorBylastName(String lastName) {
		try {
            return new ResponseEntity<>(doctorDao.findByLastName(lastName), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Doctor>> getDoctorByspeciality(String spec) {
		try {
            return new ResponseEntity<>(doctorDao.findBySpeciality(spec), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Doctor>> getAllDoctor() {
		try {
            return new ResponseEntity<>(doctorDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	

}

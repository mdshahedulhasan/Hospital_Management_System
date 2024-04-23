package com.peytosoft.AppointmentService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.peytosoft.AppointmentService.Dao.AppointmentDao;
import com.peytosoft.AppointmentService.Model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentDao appointmentDao;

	public ResponseEntity<List<Appointment>> getappointmentBypatientId(Integer patientId) {
		try {
            return new ResponseEntity<>(appointmentDao.findByPatientId(patientId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addAppointment(Appointment appointment) {
		appointmentDao.save(appointment);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Appointment>> getappointmentBydoctorId(Integer doctorId) {
		try {
            return new ResponseEntity<>(appointmentDao.findByDoctorId(doctorId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}

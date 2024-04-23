package com.peytosoft.AppointmentService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peytosoft.AppointmentService.Model.Appointment;
import com.peytosoft.AppointmentService.Service.AppointmentService;



@RestController
@RequestMapping("appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("addAppointment")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment){
        return appointmentService.addAppointment(appointment);
    }
	
	@GetMapping("getAppointmentBypatientId")
	public ResponseEntity<List<Appointment>> getappointmentBypatientId(@RequestParam Integer patientId){
	    return appointmentService.getappointmentBypatientId(patientId);
	}
	
	@GetMapping("getAppointmentBydoctorId")
	public ResponseEntity<List<Appointment>> getappointmentBydoctorId(@RequestParam Integer doctorId){
	    return appointmentService.getappointmentBydoctorId(doctorId);
	}

}

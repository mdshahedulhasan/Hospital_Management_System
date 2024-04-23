package com.peytosoft.PatientService.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peytosoft.PatientService.Model.Appointment;


@FeignClient("APPOINTMENTSERVICE")
public interface PatientInterface {
	
	@GetMapping("appointment/getappointmentBypatientId")
	public ResponseEntity<List<Appointment>> getappointmentBypatientId(@RequestParam Integer patientId);

}

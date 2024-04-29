package com.peytosoft.DoctorService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peytosoft.DoctorService.Model.Doctor;

public interface DoctorDao extends JpaRepository<Doctor,Integer>{

	Doctor findByDoctorId(Integer doctorId);

	Doctor findByFirstName(String firstName);

	Doctor findByLastName(String lastName);

	List<Doctor> findBySpeciality(String spec);

}

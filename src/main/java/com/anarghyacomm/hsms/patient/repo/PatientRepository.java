package com.anarghyacomm.hsms.patient.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghyacomm.hsms.patient.entity.PatientEntity;



@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer>{

	public Optional<PatientEntity> findByEmail(String email);

	public Optional<PatientEntity> findByPatientId(int patientId);
}

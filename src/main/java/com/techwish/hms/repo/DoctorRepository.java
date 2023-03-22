package com.techwish.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwish.hms.entity.DoctorEntity;

public interface DoctorRepository 
extends JpaRepository<DoctorEntity, Long>{
	
}

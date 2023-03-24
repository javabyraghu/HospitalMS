package com.techwish.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.techwish.hms.entity.DoctorEntity;

public interface DoctorRepository 
extends JpaRepository<DoctorEntity, Long>{

	@Modifying
	@Query("UPDATE DoctorEntity de SET de.docDept=:docDept WHERE de.id=:id")
	public Integer updateDocDeptById(Long id, String docDept);
}

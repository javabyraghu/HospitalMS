package com.techwish.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwish.hms.entity.DoctorEntity;
import com.techwish.hms.exception.DoctorNotFoundException;
import com.techwish.hms.mapper.DoctorMapper;
import com.techwish.hms.payload.DoctorDto;
import com.techwish.hms.repo.DoctorRepository;
import com.techwish.hms.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Autowired
	private DoctorMapper mapper;
	
	@Override
	public Long addDoctor(DoctorDto dto) {
		DoctorEntity doctorEntity = mapper.mapToEntity(dto);
		doctorEntity = repo.save(doctorEntity);
		return doctorEntity.getId();
	}

	@Override
	public DoctorDto getOneDoctor(Long id) {
		DoctorEntity doctorEntity = repo.findById(id)
		.orElseThrow(
				()-> new DoctorNotFoundException(
						"DOCTOR '"+id+"' NOT EXIST")
				);
		
		return mapper.mapToDto(doctorEntity);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<DoctorEntity> list = repo.findAll();
		List<DoctorDto> listDto = mapper.mapToDtoList(list);
		return listDto;
	}

	@Override
	public void deleteDoctor(Long id) {
		repo.delete(repo.findById(id)
		.orElseThrow(
				()-> new DoctorNotFoundException(
						"DOCTOR '"+id+"' NOT EXIST")
				));
	}

	@Override
	public void updateDoctor(DoctorDto dto) {
		if( repo.existsById(dto.getId()) ) {
			DoctorEntity entity = mapper.mapToEntity(dto);
			repo.save(entity);
		}
		else
			throw new DoctorNotFoundException(
					"DOCTOR '"+dto.getId()+"' NOT EXIST");
	}

}

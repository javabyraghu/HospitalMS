package com.techwish.hms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techwish.hms.entity.DoctorEntity;
import com.techwish.hms.payload.DoctorDto;

@Component
public class DoctorMapper {

	@Autowired
	private ModelMapper mapper;
		
	public DoctorEntity mapToEntity(DoctorDto dto) {
		DoctorEntity entity = mapper.map(dto, DoctorEntity.class);
		return entity;
	}
	
	public DoctorDto mapToDto(DoctorEntity entity) {
		ModelMapper mapper = new ModelMapper();
		DoctorDto dto = mapper.map(entity, DoctorDto.class);
		return dto;
	}
	
	public List<DoctorDto> mapToDtoList(List<DoctorEntity> entities) {
		List<DoctorDto> list = new ArrayList<>(entities.size());
		for(DoctorEntity entity : entities) {
			list.add(mapToDto(entity));
		}
		return list;
	}
}

package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	DtoUser entityToDtoUser(User user);

	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "createTime", ignore = true)
    @Mapping(target = "id", ignore = true) // id'yi yok say
    User dtoUserIUToEntity(DtoUserIU dtoUserIU);
	
	List<DtoUser> entitiesToDtoUsers(List<User> users);
	
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "createTime", ignore = true)
    @Mapping(target = "id", ignore = true) // id'yi yok say
	void dtoUserIUToEntity(DtoUserIU dtoUserIU, @MappingTarget User user);

}

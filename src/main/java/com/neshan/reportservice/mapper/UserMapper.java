package com.neshan.reportservice.mapper;

import com.neshan.reportservice.model.dto.RegisterRequest;
import com.neshan.reportservice.model.dto.UsersDto;
import com.neshan.reportservice.model.entity.User;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserMapper {

    UsersDto userToUsersDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(RegisterRequest dto, @MappingTarget User user);
}

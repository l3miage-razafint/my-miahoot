package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.UserEntity;
import fr.uga.l3miage.example.request.UserDtoRequest;
import fr.uga.l3miage.example.response.UserDtoResponse;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    UserDtoResponse toDto(UserEntity userEntity);

    UserEntity toEntity(UserDtoRequest userDtoRequest);

    void mergeToEntity(@MappingTarget @NonNull UserEntity baseUser, UserDtoRequest userDtoRequest);
}

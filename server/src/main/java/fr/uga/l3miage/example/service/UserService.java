package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.UserComponent;
import fr.uga.l3miage.example.exception.rest.MiahootRestException;
import fr.uga.l3miage.example.exception.technical.MiahootTechException;
import fr.uga.l3miage.example.mapper.UserMapper;
import fr.uga.l3miage.example.models.UserEntity;
import fr.uga.l3miage.example.request.UserDtoRequest;
import fr.uga.l3miage.example.response.UserDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private UserComponent userComponent;
    private UserMapper userMapper;


    public void registerUser(UserDtoRequest userDtoRequest){
        UserEntity newUserEntity = userMapper.toEntity(userDtoRequest);
        userComponent.registerUser(newUserEntity);
    }

    public List<UserDtoResponse> getAll() {
        return userComponent.getAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDtoResponse getUser(Long id) {
        try {
            return userMapper.toDto(userComponent.getUser(id));
        } catch (MiahootTechException e) {
            throw new MiahootRestException(e.getMessage(), e);
        }
    }

    public void updateUser(Long id, UserDtoRequest userDtoRequest) {
        try {
            UserEntity baseUserToUpdate = userComponent.getUser(id);
            userMapper.mergeToEntity(baseUserToUpdate, userDtoRequest);
            userComponent.updateUser(baseUserToUpdate);
        } catch (MiahootTechException e) {
            throw new MiahootRestException(String.format("User with userId [%s] not found", id), e);
        }
    }

    public void deleteUser(Long id) {
        try{
            userComponent.deleteUser(id);
        }catch (MiahootTechException e){
            throw new MiahootRestException(e.getMessage(), e);
        }
    }
}

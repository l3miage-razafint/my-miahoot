package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.MiahootTechException;
import fr.uga.l3miage.example.models.UserEntity;
import fr.uga.l3miage.example.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserComponent {
    private final UserRepo userRepo;

    public void registerUser(final UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    public UserEntity getUser(Long id) throws MiahootTechException {
        return userRepo.findById(id)
                .orElseThrow(() -> new MiahootTechException(String.format("User with userId [%s] not found", id)));
    }

    public void updateUser(UserEntity updatedUserEntity) {
        userRepo.save(updatedUserEntity);
    }

    public void deleteUser(Long id) throws MiahootTechException {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            throw new MiahootTechException(String.format("User with userId [%s] not found", id));
        }
    }
}

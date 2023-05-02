package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.UserEndpoint;
import fr.uga.l3miage.example.request.UserDtoRequest;
import fr.uga.l3miage.example.response.UserDtoResponse;
import fr.uga.l3miage.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class UserController implements UserEndpoint {

    private final UserService userService;

    @Override
    public ResponseEntity<String> registerUser(final UserDtoRequest userDtoRequest) {
        userService.registerUser(userDtoRequest);
        return new ResponseEntity<>("User registration successful", OK);
    }

    @Override
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAll());
    }

    @Override
    public ResponseEntity<UserDtoResponse> getUser(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(id));
    }

    @Override
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDtoRequest userDtoRequest) {
        userService.updateUser(id, userDtoRequest);
        return new ResponseEntity<>("User uptaded successfully", OK);
    }

    @Override
    public ResponseEntity<String> updateUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", OK);
    }
}

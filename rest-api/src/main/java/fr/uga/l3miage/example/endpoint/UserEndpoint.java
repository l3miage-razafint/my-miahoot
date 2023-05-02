package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.request.UserDtoRequest;
import fr.uga.l3miage.example.response.UserDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public interface UserEndpoint {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDtoRequest userDtoRequest);

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers();

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUser(@PathVariable Long id);

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDtoRequest userDtoRequest);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id);
}

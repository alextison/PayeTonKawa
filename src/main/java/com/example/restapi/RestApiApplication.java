import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // Code pour créer un nouvel utilisateur
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        // Code pour récupérer un utilisateur par son identifiant
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        // Code pour mettre à jour les informations d'un utilisateur
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        // Code pour supprimer un utilisateur
    }

}

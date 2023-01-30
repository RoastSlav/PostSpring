package rostislav.postspring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rostislav.postspring.models.User;

public interface IUserController {
    @PostMapping("/register")
    public int createUser(User user, HttpServletRequest req);

    @PostMapping("/login")
    public int login(@RequestBody User user, HttpServletRequest req);

    @PostMapping("/deactivate/#{username}")
    public int deactivateUser(@PathVariable String username);

    @PostMapping("/delete/#{username}")
    public int deleteUser(@PathVariable String username);
}

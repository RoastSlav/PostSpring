package rostislav.postspring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rostislav.postspring.mappers.UserMapper;
import rostislav.postspring.models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RestController
@RequestMapping("/userControl")
public class UserController implements IUserController{
    @Autowired
    UserMapper mapper;
    private static MessageDigest crypt;

    static {
        try {
            crypt = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int createUser(User user, HttpServletRequest req) {
        Random random = new Random();
        int randomNum = random.nextInt(1000000000);

        user.password = hashPassword(user.password + randomNum);
        user.salt = randomNum;
        mapper.createUser(user);
        HttpSession session = req.getSession(true);
        session.setAttribute("userName", user.username);
        return 1;
    }

    @Override
    public int login(User user, HttpServletRequest req) {
        String password = user.password;
        user = mapper.getUser(user.username);
        String encryptedPass = hashPassword(password + user.salt);
        if (user.password.equals(encryptedPass)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("userName", user.username);
            return 1;
        }
        return 0;
    }

    @Override
    public int deactivateUser(String username) {
        return mapper.deactivateUser(username);
    }

    @Override
    public int deleteUser(String username) {
        return mapper.deleteUser(username);
    }

    private static String hashPassword(String password) {
        crypt.reset();
        crypt.update(password.getBytes());

        byte[] digest = crypt.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append((char) b);
        }
        return sb.toString();
    }
}

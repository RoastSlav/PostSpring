package rostislav.postspring.mappers;

import org.springframework.web.bind.annotation.GetMapping;
import rostislav.postspring.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(String username);
    public User[] getAllUsers();
    public int createUser(User user);

    public int deactivateUser(String username);

    public int deleteUser(String username);
}

package rostislav.postspring.mappers;

import rostislav.postspring.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(String username);

    public int createUser(User user);
}

package Mappers;

import Models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(String username);

    public int createUser(User user);
}

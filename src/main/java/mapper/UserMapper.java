package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    User getUserById(String id);

    void addUser(User user);

    void update(User user);

    void delete(String id);

    List<User> filterBySexAndAge(@Param("sex")String sex, @Param("age")String age, @Param("type")String type);
}

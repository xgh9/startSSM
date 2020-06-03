package service;

import bean.Dept;
import bean.User;

import java.util.List;

public interface ServiceI {
    List<User> getAllUser();

    List<Dept> getAllDept();

    User getUserById(String id);

    void addUser(User user);

    void update(User user);

    void delete(String id);

    List<User> getUsersLike(String str);
}

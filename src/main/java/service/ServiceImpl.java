package service;

import bean.Dept;
import bean.User;
import mapper.DeptMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class ServiceImpl implements ServiceI{

    @Autowired
    UserMapper userMapper;

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void addUser(User user) {
        userMapper.addUser(user);
        deptMapper.updateNumber(1,user.getDept().getId().toString());
    }

    @Override
    @Transactional
    public void update(User user) {
        User oldUser = userMapper.getUserById(user.getId().toString());
        String oldDid = oldUser.getDept().getId().toString();
        String newDid = user.getDept().getId().toString();
        if (oldDid != newDid){
            deptMapper.updateNumber(-1,oldDid);
            deptMapper.updateNumber(1,newDid);
        }
        userMapper.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void delete(String id) {
        User user = userMapper.getUserById(id);
        userMapper.delete(id);
        deptMapper.updateNumber(-1,user.getDept().getId().toString());
    }
}

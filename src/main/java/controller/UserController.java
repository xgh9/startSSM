package controller;

import bean.Dept;
import bean.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired()
    ServiceImpl service;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView listUsers(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<User> allUser = service.getAllUser();
        ModelAndView view = new ModelAndView();
        view.addObject("users", allUser);
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "depts", method = RequestMethod.GET)
    public ModelAndView listDepts(){
        List<Dept> depts = service.getAllDept();
        ModelAndView view = new ModelAndView();
        view.addObject("depts", depts);
        view.setViewName("depts");
        return view;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id")String id){
        service.delete(id);
        return "redirect:users";
    }

    @RequestMapping("add")
    public ModelAndView toAdd(){
        List<Dept> depts = service.getAllDept();
        ModelAndView view = new ModelAndView();
        view.addObject("user", new User(null,null,null,null,new Dept()));
        view.addObject("depts", depts);
        view.setViewName("update");
        return view;
    }

    @RequestMapping("user/{id}")
    public ModelAndView toUpdate(@PathVariable("id")String id){
        User user = service.getUserById(id);
        List<Dept> depts = service.getAllDept();
        ModelAndView view = new ModelAndView();
        view.addObject("user", user);
        view.addObject("depts", depts);
        view.setViewName("update");
        return view;
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public String updateUser(User user){
        service.update(user);
        return "redirect:users";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String addUser(User user){
        service.addUser(user);
        return "redirect:users";
    }
}

package controller;

import bean.Dept;
import bean.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired()
    ServiceImpl service;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView listUsers(Integer pageNum){
        if (pageNum == null){
            pageNum=1;
        }
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

    @RequestMapping(value = "like", method = RequestMethod.GET)
    public ModelAndView likeUsers(String str){
        List<User> allUser = service.getUsersLike(str);
        ModelAndView view = new ModelAndView();
        view.addObject("users", allUser);
        view.setViewName("index");
        return view;
    }




    /**
     * spring处理json的条件
     * 1：导入jar<dependency>
     *              <groupId>com.fasterxml.jackson.core</groupId>
     *              <artifactId>jackson-databind</artifactId>
     *              <version>2.9.0</version>
     *          </dependency>
     * 2：在xml中开启注解驱动<mvc:annotation-driven/>
     * 3.在处理ajax请求的方法上加上@ResponseBody
     * 4.将要转换为json且响应到客户端的数据作为返回值
     *
     *
     * @RequestBody用于接收json数据
     * @return
     */
    @RequestMapping("testJson")
    @ResponseBody
    public User testJson(){
        User user = null;
        return user;
    }


    @RequestMapping("down")
    public ResponseEntity<byte[]> testFile(HttpSession session) throws Exception{
        String path = session.getServletContext().getRealPath("img");
        String p = path + File.separator + "head.png";
        FileInputStream inputStream = new FileInputStream(p);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attacment;filename=head.png");
        ResponseEntity<byte[]> entity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        inputStream.close();
        return entity;
    }

    /**
     *
     * @param uploadfile 批量上传：MultipartFile[] uploadfile
     * @param desc
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("up")
    public String upload(CommonsMultipartFile uploadfile, String desc, HttpSession session) throws IOException {
        String path = session.getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = uploadfile.getOriginalFilename();
        uploadfile.transferTo(new File(file,filename));
        return "success";
    }
}

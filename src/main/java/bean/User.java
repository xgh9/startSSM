package bean;

import org.springframework.stereotype.Repository;

@Repository
public class User {
    private Integer id;
    private String userName;
    private String sex;
    private Integer age;
    private Dept dept;

    public User() {
    }

    public User(Integer id, String userName, String sex, Integer age, Dept dept) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

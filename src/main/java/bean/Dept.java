package bean;

import org.springframework.stereotype.Repository;

@Repository
public class Dept {
    private Integer id;
    private String name;

    public Dept() {
    }

    public Dept(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    private Integer number;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

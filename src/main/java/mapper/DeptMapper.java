package mapper;

import bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> getAllDept();

    Dept getDeptById(String id);

    //k=1代表数量加一，k=-1代表数量减一
    void updateNumber(@Param("k") Integer k, @Param("id")String id);
}

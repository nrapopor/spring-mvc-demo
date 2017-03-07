package com.nrapoport.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.nrapoport.mybatis.domain.Department;

@Mapper
public interface DepartmentMapper {

    @Results(id = "departmentIdResult", value = { //
        @Result(property = "deptNo", column = "dept_no", id = true),
        @Result(property = "deptName", column = "dept_name") //
    })
    @Select("select * from employees.departments WHERE dept_no = \"${id}\"")
    Department findById(@Param("id") String id);

    @Results(id = "departmentNameResult", value = { //
        @Result(property = "deptNo", column = "dept_no", id = true),
        @Result(property = "deptName", column = "dept_name") //
    })
    @Select("select * from employees.departments WHERE dept_name like \"${name}%\" or \"${name}\" = \"ALL\" ")
    List<Department> findByName(@Param("name") String name);

    @Results(id = "departmentAllResult", value = { //
        @Result(property = "deptNo", column = "dept_no", id = true),
        @Result(property = "deptName", column = "dept_name") //
    })
    @Select("select * from employees.departments")
    List<Department> getAll();
}

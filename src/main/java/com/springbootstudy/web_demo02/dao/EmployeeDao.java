package com.springbootstudy.web_demo02.dao;

import com.springbootstudy.web_demo02.pojo.Department;
import com.springbootstudy.web_demo02.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees=  null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee (1001,"AA","00000001@qq.com",1,new Department(101,"教学部")));
        employees.put(1002, new Employee(1002,"BB","00000002@qq.com",0,new Department(102,"市场部")));
        employees.put(1003, new Employee(1003,"CC","00000003@qq.com",0,new Department(103,"采购部")));
        employees.put(1004, new Employee(1004,"DD","00000004@qq.com",1,new Department(104,"保卫部")));
        employees.put(1005, new Employee(1005,"EE","00000005@qq.com",0,new Department(105,"管理服务部")));
    }
    //主键自增！
    private static Integer initId = 1006;
    //增加一个员工
    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //通过id删除员工
    public void delete(Integer id)
    {
        employees.remove(id);
    }

}

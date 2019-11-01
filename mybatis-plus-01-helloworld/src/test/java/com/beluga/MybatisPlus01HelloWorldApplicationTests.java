package com.beluga;

import com.beluga.beans.Employee;
import com.beluga.mapper.EmployeeMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus01HelloWorldApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testInsertKey(){

        Employee employee = new Employee();
        employee.setLastName("Beluga");
        employee.setEmail("1511397550@qq.com");
        employee.setGender(1);
        employee.setAge(23);
        int insert = employeeMapper.insert(employee);
        System.out.println("result: " + insert);

        // 直接获取当前在数据中的主键值
        Integer id = employee.getId();
        System.out.println("主键值: " + id);
    }

    @Test
    public void testHelloWorld(){
        List<Employee> employees = employeeMapper.selectList(null);
        for (Employee emp:employees){
            System.out.println(emp);
        }
    }

}

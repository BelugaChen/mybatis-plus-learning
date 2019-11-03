package com.beluga.mybatisplus02;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beluga.mybatisplus02.beans.Employee;
import com.beluga.mybatisplus02.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus02ApplicationTests {

    /**
     * AR这种方式,本质上是对MyBatis底层的SqlSession操作的封装
     */
    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * AR(Active Record) 分页复杂操作
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();
        IPage<Employee> iPage = employee.selectPage(new Page<Employee>(1, 1), new QueryWrapper<Employee>()
                .like("last_name", "a"));
        List<Employee> records = iPage.getRecords();
        System.out.println(records);
    }

    /**
     * AR(Active Record) 删除操作
     *
     * 注意: 删除不存在的数据 逻辑也是属于成功的
     */
    @Test
    public void testARDelete(){
        Employee employee = new Employee();
        employee.setId(2);
        boolean delete = employee.deleteById();
        System.out.println("result: "+ delete);
    }


    /**
     * AR(Active Record) 查询操作
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();
        Employee result = employee.selectById(12);
        System.out.println("result: " + result);
    }


    /**
     * AR(Active Record) 修改操作
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee()
                .setId(12)
                .setLastName("Docker")
                .setEmail("mrc@163.com")
                .setGender(1)
                .setAge(34);
       /* boolean b = employee.updateById();
        System.out.println("result: " + b);*/
        List<Employee> employees = employee.selectAll();
        System.out.println(employees);
    }


    /**
     * AR(Active Record) 插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee()
                .setLastName("Mr.C")
                .setEmail("mrc@163.com")
                .setGender(1)
                .setAge(35);
        boolean insert = employee.insert();
        System.out.println("result: " + insert);
    }

}

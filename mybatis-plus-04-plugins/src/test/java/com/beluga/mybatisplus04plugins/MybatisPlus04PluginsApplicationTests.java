package com.beluga.mybatisplus04plugins;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beluga.mybatisplus04plugins.beans.Employee;
import com.beluga.mybatisplus04plugins.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus04PluginsApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 测试乐观锁插件
     */
    @Test
    public void testOptimisticLocker(){
        // 更新操作
        Employee employee = new Employee();
        employee.setId(12);
        employee.setLastName("mybatisPlus");
        employee.setGender("1");
        employee.setAge(22);
        employee.setVersion(3);

        int i = employeeMapper.updateById(employee);
        System.out.println("result: " + i);
    }


    /**
     * 测试分页插件
     */
    @Test
    public void testPage(){

        Page<Employee> page = new Page<>(1,1);

        IPage<Employee> iPage = employeeMapper.selectPage(page,
                null);
        List<Employee> records = iPage.getRecords();

        System.out.println(records);

        System.out.println("===================获取分页相关的一些信息===================");
        System.out.println("总条数: " + page.getTotal());
        System.out.println("总页数: " + page.getPages());
        System.out.println("当前页码: " + page.getCurrent());
        System.out.println("每页显示的条数: " + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
    }

}

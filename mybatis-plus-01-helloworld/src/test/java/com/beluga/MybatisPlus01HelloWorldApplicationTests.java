package com.beluga;

import ch.qos.logback.core.joran.conditional.Condition;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beluga.beans.Employee;
import com.beluga.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus01HelloWorldApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 条件构造器 查询操作
     */
    @Test
    public void testEntityWrapperSelect(){
        IPage<Employee> page = employeeMapper.selectPage(new Page<Employee>(1, 2),
                new QueryWrapper<Employee>()
                        .between("age", 20, 50)
                        .eq("gender",1)
                        .eq("last_name","Tom"));
        System.out.println(page.getRecords());

        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>()
                .eq("gender", 0)
                .like("last_name", "老师").or()
                .like("email", "a"));
        System.out.println(employees);


    }

    /**
     * 条件构造器 修改操作
     */
    @Test
    public void testEntityWrapperUpdate(){
        employeeMapper.update(new Employee().setLastName("Silence").setEmail("sil@888.com").setGender(0),
                new UpdateWrapper<Employee>()
                        .eq("last_name","Tom")
                        .eq("age",44));
    }

    /**
     * 条件构造器 删除操作
     */
    @Test
    public void testQueryWrapperDelete(){
        employeeMapper.delete(new QueryWrapper<Employee>()
                .eq("last_name","Kim"));
    }


    /**
     * 删除操作
     */
    @Test
    public void testDelete(){

        /**
         * 1.int deleteById(Serializable id);
         */
        int i = employeeMapper.deleteById(10);

        /**
         * 2.int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
         */
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("id","9");
        columnMap.put("last_name","lauren");
        int j = employeeMapper.deleteByMap(columnMap);

        /**
         * 3.int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
         */
        List<Integer> ids = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int k = employeeMapper.deleteBatchIds(ids);

        /**
         * 4.int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
         */
        Wrapper<Employee> wrapper = new QueryWrapper<>(new Employee().setId(7));
        int delete = employeeMapper.delete(wrapper);
        System.out.println("wrapper: " + delete);
    }


    /**
     * 查询操作
     */
    @Test
    public void testSelect(){
        /**
         * 1.selectById(Serializable id);
         */
        Employee employee = employeeMapper.selectById(6);
        System.out.println(employee);

        /**
         * 2.selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper)
         */
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(new Employee().setId(4).setLastName("white"));
        Employee employee1 = employeeMapper.selectOne(queryWrapper);
        System.out.println(employee1);

        /**
         * 3.selectBatchIds(@Param(Constants.COLLECTION)
         *              Collection<? extends Serializable> idList);
         */
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        List<Employee> employees = employeeMapper.selectBatchIds(ids);
        System.out.println(employees);

        /**
         * 4.List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
         */
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name","Kim");
        List<Employee> employee_map = employeeMapper.selectByMap(columnMap);
        System.out.println(employee_map);

        /**
         * 5.IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
         */
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(1, 2), null);
        System.out.println(employeeIPage.getRecords());
    }

    @Test
    public void testCommonUpdate(){

        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("MyBatisPlus");
        employee.setEmail("mybatisPlus@163.com");
        employee.setGender(0);
        employee.setAge(30);
        int result = employeeMapper.updateById(employee);
        System.out.println("result: " + result);
    }


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

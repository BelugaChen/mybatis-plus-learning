package com.beluga.mybatisplus03autogenerator.service.impl;

import com.beluga.mybatisplus03autogenerator.beans.Employee;
import com.beluga.mybatisplus03autogenerator.mapper.EmployeeMapper;
import com.beluga.mybatisplus03autogenerator.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈健Beluga
 * @since 2019-11-03
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    /**
     * EmployeeServiceImpl 继承了 ServiceImpl
     *  1. 在ServiceImpl中已经完成了Mapper对象的注入, 直接在EmployeeServiceImpl中进行使用
     *  2. 在ServiceImpl中也帮我们提供了常用的CRUD方法, 基本的一些CRUD方法在Service中不需要我们自己定义了
     */
}

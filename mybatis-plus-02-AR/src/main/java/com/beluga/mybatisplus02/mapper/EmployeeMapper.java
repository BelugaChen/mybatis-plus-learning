package com.beluga.mybatisplus02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beluga.mybatisplus02.beans.Employee;
import org.springframework.stereotype.Repository;

/**
 * Mapper接口
 *
 * 基于MP: 让XxxMapper接口继承BaseMapper接口即可.
 *         BaseMapper<T> : 泛型指定的就是当前Mapper接口所操作的实体类类型
 * @author 陈健Beluga
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}

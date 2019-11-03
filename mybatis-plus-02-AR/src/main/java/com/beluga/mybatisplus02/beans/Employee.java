package com.beluga.mybatisplus02.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * javaBean
 *
 * 定义javaBean中成员变量时所使用的类型:
 *      因为每个基本类型都有一个默认值：
 *          int ===> 0
 *          boolean ===> false
 *
 * MyBatisPlus会默认使用实体类的类名去数据库找对应的表名.
 * @TableName：
 *  value: 指定表名。
 * @TableName("tbl_employee")
 *
 * @author 陈健Beluga
 */
@Data
@Accessors(chain = true)
public class Employee extends Model<Employee> {

    /**
     * @TableId:
     *  value: 指定表中的主键列的列名, 如果实体属性名与别名一致, 可以省略不指定。
     *  type: 指定主键策略。
     *
     * @TableId(value = "id",type = IdType.AUTO)
     */
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private double salary;

    /**
     * 指定当前实体类的主键属性
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}

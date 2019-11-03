package com.beluga.mybatisplus03autogenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus03AutoGeneratorApplicationTests {

    /**
     * 代码生成实例代码
     */
    @Test
    public void testGenerator(){
        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true) // 是否支持AR模式
                    .setAuthor("陈健Beluga") // 作者
                    .setOutputDir(System.getProperty("user.dir")+"/src/main/java") // 生成路径
                    .setFileOverride(true)   // 文件覆盖
                    .setOpen(false)
                    .setIdType(IdType.AUTO)  // 主键策略
                    .setServiceName("%sService")        // 设置生成的service接口的名字的首字母为I
                    .setBaseResultMap(true)
                    .setBaseColumnList(true);

        // 2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUrl("jdbc:mysql://182.92.217.51:3306/mybatis?characterEncoding=utf8&useSSL=false&serverTimezone=GMT&rewriteBatchedStatements=true")
                        .setUsername("root")
                        .setPassword("Cj969788.+#");

        // 3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  // 全局大写命名
                        .setTablePrefix("tbl_") // 指定表名下划线
                        .setNaming(NamingStrategy.underline_to_camel)  // 驼峰命名策略
                        .setInclude("tbl_employee"); // 生成的表

        // 4. 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.beluga.mybatisplus03autogenerator")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        // 5. 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);

        // 6. 执行
        autoGenerator.execute();
    }
}

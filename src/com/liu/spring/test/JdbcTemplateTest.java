package com.liu.spring.test;

import com.liu.spring.bean.Monster;
import com.liu.spring.jdbcTemplate.MonsterDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplateTest {
//    测试能否连接上数据库
    @Test
    public void testDatasourceByJdbcTemplate() throws SQLException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        DataSource dataSource = (DataSource)ioc.getBean("dataSource");
//        获取链接
        Connection connection = dataSource.getConnection();
        System.out.println("connection链接="+connection);
    }

//    添加数据
    @Test
    public void addDataByJdbcTemplate(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        //第一种方式
//        jdbcTemplate.execute("INSERT INTO monster VALUES(400, '红孩儿', '枪法');");
        //第二种方法
        String sql="INSERT INTO monster VALUES(?, ?, ?)";
        //影响的行数
        int update = jdbcTemplate.update(sql, 500, "红孩儿2", "枪法厉害2");
        System.out.println("受影响的记录数："+update);
    }

    //测试修改数据
    @Test
    public void updateDataByJdbcTemplate(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql="Update monster set skill=? where id=?";
        int affected = jdbcTemplate.update(sql, "美女记", 300);
        System.out.println("影响记录数="+affected);
    }

//    批量添加
//    这里有一个使用api的技巧
    @Test
    public void addBatch(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql="INSERT INTO monster VALUES(?, ?, ?)";
        List<Object[]> batchArgs=new ArrayList<>();
        batchArgs.add(new Object[]{600,"老鼠精","偷吃粮食"});
        batchArgs.add(new Object[]{700,"老猫精","抓老鼠"});
        //public int[] batchUpdate(String sql, List<Object[]> batchArgs)
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        for (int anInt : ints) {
            System.out.println("anInt="+anInt);
        }
    }

    //查询数据，封装到一个对象
    @Test
    public void selectDataTranObject(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql="select id as monsterId,name,skill from monster where id=100";
//        RowMapper<T> var2 接口对返回的数据进行封装，底层使用反射 setter
        BeanPropertyRowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper);
        System.out.println("monster="+monster);
    }

    //查询数据，封装到一个集合
    @Test
    public void selectDataTranCollection(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql="select id as monsterId,name,skill from monster where id>?";
//        RowMapper<T> var2 接口对返回的数据进行封装，底层使用反射 setter
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
//        <T> List<T> query(String var1, RowMapper<T> var2)
        List<Monster> monsterList = jdbcTemplate.query(sql, rowMapper, 100);
        System.out.println("monster="+monsterList.toString());
    }

    //查询一行一列的值
    @Test
    public void selectDataForOne(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql="select name from monster where id=100";
//        RowMapper<T> var2 接口对返回的数据进行封装，底层使用反射 setter
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        String name = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println("name="+name);
    }

    @Test
//    MonsterDao是否生效
    public void monsterDaoSave(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        MonsterDao monsterDao = ioc.getBean("monsterDao", MonsterDao.class);
        Monster monster = new Monster(1000, "小鸭精", "吃鱼");
        monsterDao.save(monster);
    }

}

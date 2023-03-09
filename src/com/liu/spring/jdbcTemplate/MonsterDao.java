package com.liu.spring.jdbcTemplate;

import com.liu.spring.bean.Monster;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class MonsterDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(Monster monster){
        String sql="INSERT INTO monster VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, monster.getMonsterId(), monster.getName(), monster.getSkill());
        System.out.println("MonsterDao保存成功，影响行数="+update);
    }
}

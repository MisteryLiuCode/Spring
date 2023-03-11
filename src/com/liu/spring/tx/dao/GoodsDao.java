package com.liu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

//注入到spring容器
@Repository
public class GoodsDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*
    根据商品id返回对应的价格
     */
    public Float queryPriceById(Integer id) {
        String sql = "SELECT price From goods Where goods_id=?";
        Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
        return price; }

    /*
    根据用户id修改用户的余额
     */
    public void updateBalance(Integer user_id, Float money) {
        String sql = "UPDATE user_account SET money=money-? Where user_id=?";
        jdbcTemplate.update(sql, money, user_id);
    }

    /*
    根据商品id修改商品库存
     */
    public void updateAmount(Integer goods_id, int amount){
        String sql = "UPDATEX goods_amount SET goods_num=goods_num-? Where goods_id=?";
        jdbcTemplate.update(sql, amount , goods_id);
    }
}

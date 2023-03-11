package com.liu.spring.tx.service;

import com.liu.spring.tx.dao.GoodsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsService {
    //定义属性GoodsDao
    @Resource
    private GoodsDao goodsDao;
//    编写一个方法，完成用户购买商品的业务
    public void buyGoods(int userId,int goodId,int amount){
        //得到商品的价格
        Float price = goodsDao.queryPriceById(userId);
        //减少用户的余额
        goodsDao.updateBalance(userId,price*amount);
        //减少库存量
        goodsDao.updateAmount(goodId,amount);
    }

    /*
    使用注解的方式
    使用@Transactional 可以进行声明式事务
     */
    @Transactional
    public void buyGoodsTx(int userId,int goodId,int amount){
        //得到商品的价格
        Float price = goodsDao.queryPriceById(userId);
        //减少用户的余额
        goodsDao.updateBalance(userId,price*amount);
        //减少库存量
        goodsDao.updateAmount(goodId,amount);
    }
}

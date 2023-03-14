package com.liu.spring.tx.service;

import com.liu.spring.tx.dao.GoodsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsService {
    //定义属性GoodsDao
    @Resource
    private GoodsDao goodsDao;

    //    编写一个方法，完成用户购买商品的业务
    public void buyGoods(int userId, int goodId, int amount) {
        //得到商品的价格
        Float price = goodsDao.queryPriceById(userId);
        //减少用户的余额
        goodsDao.updateBalance(userId, price * amount);
        //减少库存量
        goodsDao.updateAmount(goodId, amount);
    }

    /*
    使用注解的方式
    使用@Transactional 可以进行声明式事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyGoodsTx(int userId, int goodId, int amount) {
        //得到商品的价格
        Float price = goodsDao.queryPriceById(userId);
        //减少用户的余额
        goodsDao.updateBalance(userId, price * amount);
        //减少库存量
        try {
            goodsDao.updateAmount(goodId, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    事务超时回滚
//    没有设置timeout默认=-1.表示使用默认的事务超时时间
    @Transactional(timeout = 2)
    public void buyGoodsTimeTx(int userId, int goodId, int amount) {
        //得到商品的价格
        Float price = goodsDao.queryPriceById(userId);
        //减少用户的余额
        goodsDao.updateBalance(userId, price * amount);
//        在这模拟超时，看上面的修改是否会回滚
        try {
            Thread.sleep(4000);
            System.out.println("超时结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //减少库存量
        try {
            goodsDao.updateAmount(goodId, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    演示事务的传播机制
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyGoodsTx2(int userId, int goodId, int amount) {
        //得到商品的价格
        Float price = goodsDao.queryPriceById2(userId);
        //减少用户的余额
        goodsDao.updateBalance2(userId, price * amount);
        //减少库存量
        goodsDao.updateAmount2(goodId, amount);
    }

    //    演示事务的默认隔离级别：可重复读
//    在第一次读取之后，中间会在数据库中修改数据，但是读取的结果是一致的。
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void buyGoodsIsolationLevel(int goodId) {
        //得到商品的价格
        Float price1 = goodsDao.queryPriceById2(goodId);
        System.out.println("第一次读取的商品价格："+price1);
//        可重复读取商品价格
        Float price2 = goodsDao.queryPriceById2(goodId);
        System.out.println("第二次读取的商品价格："+price2);
    }
}

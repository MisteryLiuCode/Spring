package com.liu.spring.tx;

import com.liu.spring.tx.dao.GoodsDao;
import com.liu.spring.tx.service.GoodsService;
import com.liu.spring.tx.service.MultiplyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {

    //    测试根据id查询商品
    @Test
    public void queryPriceByIdTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        Float price = goodsDao.queryPriceById(1);
        System.out.println("id=" + 1 + "的商品价格=" + price);
    }

    /*
    根据id修改用户余额
     */
    @Test
    public void updateBalanceTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        goodsDao.updateBalance(1, 1.0F);
        System.out.println("改变余额成功");
    }

    /*
    根据商品id修改商品库存
     */
    @Test
    public void updateAmountTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        goodsDao.updateAmount(1, 1);
        System.out.println("改变商品库存");
    }

    //测试用户购买商品业务
    @Test
    public void byGoodTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods(1, 1, 1);
        System.out.println("商品购买成功");
    }

    //测试用户带有事务的购买商品业务
    @Test
    public void byGoodTxTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoodsTx(1, 1, 1);
        System.out.println("商品购买成功");
    }


    //    测试事务的传播机制
    @Test
    public void MultiBuyGoodsByTx() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        MultiplyService multiplyService = ioc.getBean(MultiplyService.class);
        multiplyService.MultiBuyGoodsByTx();
    }

    //    测试默认事务隔离级别：可重复读
    @Test
    public void IsolationLevel() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoodsIsolationLevel(1);
    }


    //    测试事务超时回滚
    @Test
    public void byGoodTimeTxTest() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoodsTimeTx(1, 1, 1);
        System.out.println("商品购买成功");
    }


}

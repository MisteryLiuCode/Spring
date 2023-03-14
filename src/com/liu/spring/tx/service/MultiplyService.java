package com.liu.spring.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MultiplyService {
    @Resource
    private GoodsService goodsService;

    /*
    有两个购买的行文，两个方法都是声明式事务，并且两个事务的隔离级别都是默认的，required
    会当做整体事务进行管理，也就是两个事务都成功才算成功。
     */
    @Transactional
    public void MultiBuyGoodsByTx(){
        goodsService.buyGoodsTx(1,1,1);
        goodsService.buyGoodsTx2(1,1,1);
    }

}

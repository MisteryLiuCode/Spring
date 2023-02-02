package com.liu.spring.factory;

import com.liu.spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

public class MyFactoryBean implements FactoryBean {

    //在配置时候，指定获取的对象对应key
    private String key;
    private Map<String,Object> monsterMap;

    //初始化monsterMap，放入一些对象
    {
        monsterMap=new HashMap<>();
        monsterMap.put("monster01",new Monster(300,"牛魔王","芭蕉扇"));
        monsterMap.put("monster02",new Monster(400,"狐狸精","美人计"));
    }

    public void setKey(String key) {
        this.key = key;
    }

    //返回对象
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    //返回对象类型
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //返回是否为单例的
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

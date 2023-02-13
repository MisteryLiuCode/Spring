package com.liu.spring.depinjection;

public class PhoneDao extends BaseDao<Phone>{
    @Override
    public void save() {
        System.out.println("PhoneDao里的save方法");
    }
}

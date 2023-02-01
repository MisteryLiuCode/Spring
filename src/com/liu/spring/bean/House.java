package com.liu.spring.bean;

public class House {
    private String name;
    public House() {
        System.out.println("House 构造器执行");
    }
    public House(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("House setName()="+name);
        this.name = name;
    }
//    初始化方法
    public void init(){
        System.out.println("House init()..");
    }
//    销毁方法
    public void destroy(){
        System.out.println("House destroy()..");
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                '}';
    }
}

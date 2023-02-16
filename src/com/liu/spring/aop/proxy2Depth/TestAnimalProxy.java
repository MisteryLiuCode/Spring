package com.liu.spring.aop.proxy2Depth;

import org.junit.jupiter.api.Test;

public class TestAnimalProxy {

    @Test
    public void proxyRun(){
        SmartAnimal vehicle=new Cat();
        VehicleAnimalProvider vehicleProxyProvider = new VehicleAnimalProvider(new Cat());
//        得到一个代理对象，该对象可以代理执行方法
        SmartAnimal proxy = vehicleProxyProvider.getProxy();
//        System.out.println("编译类型是proxy");
//      class com.sun.proxy.$Proxy8,可以看到，执行run方法的时候不是直接调用vehicle.run，
//      而是执行代理的invoke方法
//        System.out.println("运行类型是"+proxy.getClass());
        Float res= proxy.getSum(1F,1F);
//        System.out.println("代理对象输出的结果是"+res);
        System.out.println("========");
//        调用另一个方法
        Float sub = proxy.getSub(1F, 1F);
    }

    public void animalRun(){
        SmartAnimal smartAnimal = new Cat();
        VehicleAnimalProvider vehicleAnimalProvider = new VehicleAnimalProvider(new Cat());
        SmartAnimal proxy = vehicleAnimalProvider.getProxy();



    }
}

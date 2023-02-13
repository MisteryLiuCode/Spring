package com.liu.spring.proxy2;

import org.junit.jupiter.api.Test;

public class TestVehicleProxy {
    @Test
    public void test(){
        Vehicle vehicle=new Car();
        vehicle.run();
    }

    @Test
    public void proxyRun(){
        Vehicle vehicle=new Car();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(new Car());
//        得到一个代理对象，该对象可以代理执行方法
        Vehicle proxy = vehicleProxyProvider.getProxy();
        System.out.println("编译类型是proxy");
//      class com.sun.proxy.$Proxy8,可以看到，执行run方法的时候不是直接调用vehicle.run，
//      而是执行代理的invoke方法
        System.out.println("运行类型是"+proxy.getClass());

        proxy.run();
    }




}

package com.liu.spring.test;


import com.liu.spring.bean.House;
import com.liu.spring.bean.Monster;
import com.liu.spring.component.MyComponent;
import com.liu.spring.component.UserController;
import com.liu.spring.component.UserService;
import com.liu.spring.depinjection.PhoneService;
import com.liu.spring.di.DiImpl;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {


    @Test
    public void getMonster() {
        //创建容器 ApplicationContext,该容器和容器配置文件关联
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        编译类型是object,运行类型是Monster
        Object monster01 = ioc.getBean("monster01");
        System.out.println(monster01);
    }


    //    通过bean类型获取对象
    @Test
    public void getBeanType() throws DocumentException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        通过对象类型获取bean
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean=" + bean);
    }

    //    通过构造器来设置属性
    @Test
    public void setBeanByConstructer() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        通过对象类型获取bean
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean=" + bean);
    }

    //    依赖注入
    @Test
    public void setDi() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //        编译类型是object,运行类型是Monster
        DiImpl diImpli = (DiImpl) ioc.getBean("diImpl");
        diImpli.diTest();
    }

    //bean的生命周期
    @Test
    public void beanLife() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //        编译类型是object,运行类型是Monster
        House house = (House) ioc.getBean("house");

        //执行销毁方法,上面是使用接口来接收,但是接口中没有destroy方法,所以又转化为运行类型来执行close方法
        ((ClassPathXmlApplicationContext)ioc).close();
    }

//    测试集成属性 patent
    @Test
    public void getBeanForParent(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster11 = ioc.getBean("monster11", Monster.class);
        Monster monster12 = ioc.getBean("monster12", Monster.class);
        System.out.println(monster11);
        System.out.println(monster12);
    }


    //测试bean创建顺序
    @Test
    public void testBeanByCreate(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("ok");
    }


    //测试bean后置处理器
    @Test
    public void beanPostProcessor(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans02.xml");
        House house = (House)ioc.getBean("house");
        House house02 = (House)ioc.getBean("house02");
        System.out.println(house);
        System.out.println(house02);
    }

    @Test
    public void attributeBean(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monsterId1000 = (Monster) ioc.getBean("monsterId1000");
        System.out.println(monsterId1000);
    }

//    通过注解配置bean
    @Test
    public void setBeanByAnnotation(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans05.xml");
        MyComponent myComponent = (MyComponent) ioc.getBean("myComponent");
        System.out.println(myComponent);
    }
    //    演示注解AutoWaired
    @Test
    public void autoWaired(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans05.xml");
        UserController userController = (UserController) ioc.getBean("userController");
        userController.asyOk();
        System.out.println(userController);
        UserService userService = ioc.getBean("userService", UserService.class);
        System.out.println("容器中的userService="+userService);
        UserService userService200 = ioc.getBean("userService200", UserService.class);
        System.out.println("userService200="+userService200);
    }
    @Test
    public void setProByDepencyInjection(){

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans07.xml");
        ioc.getBean("phoneService", PhoneService.class);


    }

//    泛型依赖配置bean
    @Test
    public void setProByAutoWired(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans07.xml");
        System.out.println("ok");
    }
}

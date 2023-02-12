package com.liu.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

//    这里使用name指定了名称，userService200这个名称就没有意义了
//    从容器中获取的就是id就是name属性配置的。
//    @Resource(name="userService")

//    这样就不对了，因为按照类型进行装配的话，就要求这个类型的对象只有一个，如果有多个就不知道取哪个了。
//    注意：此时userService400也是不存在的
//    @Resource(type = UserService.class)
    @Resource
//    @Autowired
//    @Qualifier(value = "userService200")
    private UserService userService;

    public void asyOk(){
        System.out.println("UserController的sayOk()");
//        输出hash值
        System.out.println("userController装配的userService属性="+userService);
        userService.hi();
    }
}

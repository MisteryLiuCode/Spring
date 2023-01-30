package com.liu.spring.applicationContext;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现简单spring的一个简单容器
 * 主要是看一下流程,比较简单
 * 主要实现如何将beans.xml文件进行解析,并生成对象,放入容器中
 * 并提供一个方法,返回对应的对象
 * @author liushuaibiao
 */
public class ApplicationContext {
    private ConcurrentHashMap<String,Object> singletonObject=
            new ConcurrentHashMap<>();

//    构造器,接收beans.xml,名称,该文件默认在src
    public ApplicationContext(String iocBeanXmlFile) throws DocumentException {
//        1.得到类加载路径,查看一下ApplicationContext的路径在哪,看看iocBeanXmlFile该要如何读取
//        输出:/Spring/Spring/out/production/Spring/,找到这个文件夹,可以看到,beans,xml就在这个文件夹下面
//        那么也就是说,beans.xml直接放在src里是可以拿到的
        String path=this.getClass().getResource("/").getPath();
//        创建读取xml的对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File((path + iocBeanXmlFile).replaceAll("%20", "")));
//        得到根元素
        Element rootElement = document.getRootElement();
//        得到第一个bean-monster01
        Element bean = (Element)rootElement.elements("bean").get(0);
//        获取bean的相关属性
        String id = bean.attributeValue("id");
        String aClass = bean.attributeValue("class");
        String monsterId = bean.attributeValue("monsterId");
        String name = bean.attributeValue("name");
        String skill = bean.attributeValue("skill");
        System.out.println("id:"+id+"\n"+"aClass"+"\n"+aClass);




    }


}

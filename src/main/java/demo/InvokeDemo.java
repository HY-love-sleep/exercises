package demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/22 10:44
 * @description：反射 通过反射可以获取类的属性和方法， 并调用这这些属性和方法
 * 优点 ： 灵活
 * 缺点 ： 可以无视泛型安全检查 ， 性能也会稍差一些
 */
public class InvokeDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 通过 Class.forName()传入类的全路径来获取
        Class<?> targetClass = Class.forName("demo.TargetObject");

        // 创建该类的对象
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        // 获取该类的方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // 获取指定方法并调用
        // 1、调用public方法
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "洪子一定要找到满意的工作！");

        // 获得指定参数并对参数进行修改
        Field field = targetClass.getDeclaredField("s");
        // 因为 s 是private变量， 所以要field.setAccessible(true) TRUE： 抑制Java语言访问检查
        field.setAccessible(true);
        field.set(targetObject, "changzi he hongzi");


        // 2、调用private方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);


    }
}

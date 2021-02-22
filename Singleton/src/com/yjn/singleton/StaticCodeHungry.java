package com.yjn.singleton;

/**
 * @Author: yjn
 * @Date: 2021/2/22 17:52
 * 饿汉式(静态代码块)
 */
public class StaticCodeHungry {
    public static void main(String[] args) {
        StaticCodeSingleton instance = StaticCodeSingleton.instance;
        StaticCodeSingleton instance1 = StaticCodeSingleton.instance;
        System.out.println(instance == instance1);
    }
}

class StaticCodeSingleton {
    //构造器私有化
    private StaticCodeSingleton() {

    }

    public static StaticCodeSingleton instance;

    //在类的静态代码块创建对象实例
    static {
        instance = new StaticCodeSingleton();
    }

    //提供一个公共的方法返回静态实例
    public StaticCodeSingleton getInstance() {
        return instance;
    }
}
/**
 *优缺点:这种方法和静态变量饿汉式是一样的
 * 可能会导致内存浪费
 * **/
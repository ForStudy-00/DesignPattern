package com.yjn.singleton;

/**
 * 静态常量饿汉式
 *
 * @author Lenovo
 */
public class StaticConstantHungry {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);
    }

}

class Singleton {
    //①构造器私有
    private Singleton() {

    }
    //②在类的内部创建对象实例
    public static final Singleton INSTANCE = new Singleton();

    //③提供公有静态方法返回对象实例
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
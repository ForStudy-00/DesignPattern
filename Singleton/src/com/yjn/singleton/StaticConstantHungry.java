package com.yjn.singleton;

/**
 * 静态常量饿汉式
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
    //①构造器私有化
    private Singleton() {

    }
    //②在类的内部创建对象实例
    public static final Singleton INSTANCE = new Singleton();

    //③提供公有静态方法返回对象实例
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
/**
 * 1）优点:写法简单 在类的装载过程就完成了实例化。避免了线程同步问题
 * 2）缺点：在类的装载过程完成实例化，没有达到懒加载的效果，如果从始至终从没有使用过这个实例，就会造成内存浪费
 * 3）这种方式基于classloader机制避免了多线程的同步问题，不过instance在类装载时就实例化，在单例模式中大多数都是调用
 *    getInstance方法，但是导致类装载的原因有很多种，因此不能确定有其他方式（或者其他的静态方法）导致类加载，这时初始化
 *    instance就没有达到懒加载的效果
 * 4）结论：这种单例模式可用，可能会造成内存浪费。
 *
 **/
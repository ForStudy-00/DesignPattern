package com.yjn.singleton;

/**
 * @Author: yjn
 * @Date: 2021/2/22 20:25
 * 静态内部类的方式
 */
public class StaticInnerClass {

    public static void main(String[] args) {
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton instance1 = StaticInnerClassSingleton.getInstance();
        System.out.println(instance==instance1);
    }
}

class StaticInnerClassSingleton {

    //构造器私有化
    private StaticInnerClassSingleton() {
    }

    private static volatile StaticInnerClassSingleton instance;

    //写一个静态内部类,该类中有一个静态属性 StaticInnerClassSingleton
    private static class SingletonInstance {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    //提供一个公共的静态方法,直接返回SingletonInstance.INSTANCE;
    public static StaticInnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
/**
 * 1)这种方式采用了类装载的机制来保证初始化实例时只有一个线程.
 * 2)静态内部类方式在Singleton类呗装载时并不会立即实例化,而是在需要实例化时,调用getInstance方法,才会装载SingletonInstance类
 *   ,从而完成Singleton的实例化
 * 3)类的静态属性只会在第一次加载类的时候初始化,所以在这里,jvm帮我们保证了线程的安全性,在类进行初始化时,别的线程是无法进入的.
 * 4)优点:避免了线程不安全,利用静态内部类特点实现延迟加载,效率高.
 * 推荐使用
 **/
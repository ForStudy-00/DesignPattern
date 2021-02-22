package com.yjn.singleton;

/**
 * @Author: yjn
 * @Date: 2021/2/22 19:25
 * 懒汉式第一种  非线程安全的
 */
public class LazyManOne {

    public static void main(String[] args) {
        LazyManOneSingleton instance = LazyManOneSingleton.getInstance();
        LazyManOneSingleton instance1 = LazyManOneSingleton.getInstance();
        System.out.println(instance==instance1);
    }
}

class LazyManOneSingleton {
    //构造办法私有化
    private LazyManOneSingleton() {
    }
    private static LazyManOneSingleton singleton;

    public  static LazyManOneSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyManOneSingleton();
        }
        return singleton;
    }
}
/**
 * 优点:起到了懒加载的效果,但是只能在单线程下使用
 * 缺点:如果在多线程下,一个线程进入了if(singleton==null)的判断语句块,还没来得及往下执行,另一个线程也通过了这个判断语句,这时就会产生多个实例
 * 结论:不要在开发中使用这种方式
 **/
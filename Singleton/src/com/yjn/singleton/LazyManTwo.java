package com.yjn.singleton;

/**
 * @Author: yjn
 * @Date: 2021/2/22 19:37
 * <p>
 * 懒汉式第二种  线程安全的
 */
public class LazyManTwo {

    public static void main(String[] args) {
        LazyManTowSingleton instance = LazyManTowSingleton.getInstance();
        LazyManTowSingleton instance1 = LazyManTowSingleton.getInstance();
        System.out.println(instance == instance1);
    }
}

class LazyManTowSingleton {
    //构造办法私有化
    private LazyManTowSingleton() {
    }

    private static LazyManTowSingleton singleton;

    public static synchronized LazyManTowSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyManTowSingleton();
        }
        return singleton;
    }
}
/**
 * 优点:起到了懒加载的效果,是线程安全的
 * 缺点:效率太低,每个线程在想获得类的实例时,执行getInstance方法都要进行同步.
 * 而其实这个方法只执行一次实例化代码就够了,后面想要获取该类的实例,直接返回就行.方法进行同步效率太低
 * 结论:不建议开发中使用这种方式
 **/

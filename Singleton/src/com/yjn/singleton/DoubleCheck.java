package com.yjn.singleton;

/**
 * @Author: yjn
 * @Date: 2021/2/22 20:03
 * <p>
 * 双重检查   线程安全的
 */
public class DoubleCheck {

    public static void main(String[] args) {
        DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton instance1 = DoubleCheckSingleton.getInstance();
        System.out.println(instance == instance1);
    }
}

class DoubleCheckSingleton {
    private DoubleCheckSingleton() {
    }

    private static volatile DoubleCheckSingleton singleton;

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
/**
 * 优缺点:
 * 1)双重检查是多线程开发中经常使用到的,如代码中所示,我们进行了两次if(singleton==null)检查,这样就可以保证线程安全了
 * 2)这样,实例化代码只用执行一次,后面再次访问时,判断if(singleton==null),直接return实例化对象,也避免了反复进行方法同步
 * 3)线程安全;延迟加载;效率较高.
 * 4)结论:在实际开发中,推荐使用这种单例设计模式
 **/
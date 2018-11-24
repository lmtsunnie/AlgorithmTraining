package java;

// 饿汉式，无论需不需要都直接创建
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton() { }
    public static Singleton getInstance() {
        return singleton;
    }
}
// 懒汉式，需要的时候才创建
class Singleton2 {
    private static Singleton2 singleton2;
    private Singleton2() { }
    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

// 加锁，因为需要new的时候不多，大多数是读操作，所以效率不高
class Singleton3 {
    private static volatile Singleton3 singleton3;
    private Singleton3() {}
    public static Singleton3 getInstance() {
        synchronized (Singleton3.class) {
            if (singleton3 == null) {
                singleton3 = new Singleton3();
            }
            return singleton3;
        }
    }
}

// 双重检测锁，在加锁之前检测是否是空，是空才加锁
class Singleton4 {
    private static volatile Singleton4 singleton4;
    private Singleton4() {}
    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}

// 静态内部类
class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 singleton5 = new Singleton5();
    }
    private Singleton5() {}
    public static Singleton5 getInstance() {
        return SingletonHolder.singleton5;
    }
}

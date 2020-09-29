public class StaticSingleton {
    //构造器私有化，防止new对象
    private StaticSingleton() {
    }

    //静态内部类的方式
    // 外部类被装载的时候，内部类不会被装载，当getInstace()执行的时候这个内部类才会被装载；JVM装载类的时候是线程安全的
    private static class SingletonInstance {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
class TestStatic{
    public static void main(String[] args) {
        StaticSingleton instance1 = StaticSingleton.getInstance();
        StaticSingleton instance2 = StaticSingleton.getInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }


}
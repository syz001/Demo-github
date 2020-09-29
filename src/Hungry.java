//饿汉模式（静态常量）
public class Hungry {

    //1.构造器私有化（防止new）
    private Hungry(){}

    //2.类的内部创建对象
    private final static Hungry instance;

    //2.1静态代码块中创建单例对象
    static {
        instance = new Hungry();
    }

    //3.提供一个公有的静态方法，返回实例对象
    public static Hungry getInstance(){
        return instance;
    }
}

class Test{
    public static void main(String[] args) {
        Hungry instance1 = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }


}
public class Lazybones3 {
    private  static volatile Lazybones3 instance;
    private Lazybones3(){}

    //    提供一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题，并保证了效率
    public static Lazybones3 getInstance(){

        if(instance == null){
            synchronized (Lazybones3.class){
                if(instance == null){
                    instance = new Lazybones3();
                }
            }
        }
        return instance;
    }
}
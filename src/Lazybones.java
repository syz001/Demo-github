public class Lazybones {
    private  static Lazybones instance;

    private Lazybones(){}

    //    提供一个静态的公有方法，当使用到该方法时，才会去创建instance
    //    即懒汉式
    public static synchronized Lazybones getInstance(){
        if(instance == null){
            instance = new Lazybones();
        }
        return instance;
    }
}
class MyThread implements Runnable{ // 实现Runnable接口，作为线程的实现类
    private String name ;       // 表示线程的名称
    public MyThread(String name){
        this.name = name ;      // 通过构造方法配置name属性
    }
    public void run(){  // 覆写run()方法，作为线程 的操作主体
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "运行：" + Lazybones.getInstance().hashCode()) ;
        }
    }
};
class RunnableDemo01{
    public static void main(String args[]){
        MyThread mt1 = new MyThread("线程A ") ;    // 实例化对象
        MyThread mt2 = new MyThread("线程B ") ;    // 实例化对象

        new Thread(mt1).start(); ;       // 实例化Thread类对象并启动
        new Thread(mt2).start(); ;       // 实例化Thread类对象并启动

    }
};

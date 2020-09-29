public enum EnumSinglon {
    INSTANCE;
    public void method(){
        System.out.println("hello world");
    }
}
//测试
class TestEnumSingleton{
    public static void main(String[] args) {
        // 直接调用静态方法获得，而不是使用new
        EnumSinglon singleton1 = EnumSinglon.INSTANCE;
        EnumSinglon singleton2 = EnumSinglon.INSTANCE;
        //开发人员a做的修改
        // 发现两个对象相等
        System.out.println(singleton1 == singleton2); //返回true

        //返回一样的 hashcode
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());
    }
}
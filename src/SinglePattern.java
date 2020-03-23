//饿汉模式（预先实例化）
class SinglePatternHunger {
    public static SinglePatternHunger amInstant = new SinglePatternHunger();

    private SinglePatternHunger() { System.out.println("I am SinglePatternHunger");}

    public static SinglePatternHunger getInstance() {
        return amInstant;
    }
}
//懒汉模式（调用时才实例化）
//下面这种写法，通过内部静态类，可以保证加载时才实例化外部类，实现懒汉单例模式
class SinglePatternLazy {

    private SinglePatternLazy() {System.out.println("I am SinglePatternLazy");}

    public static synchronized SinglePatternLazy getInstance() {
        return InstantHolder.mInstant;
    }

    private static class InstantHolder {
        private static SinglePatternLazy mInstant = new SinglePatternLazy();
    }
}
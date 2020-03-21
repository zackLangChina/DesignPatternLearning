/**
 * 单例模式
 * 分为饿汉模式（预先实例化）和懒汉模式（调用时才实例化）
 */
class SinglePatternHunger {
    public static SinglePatternHunger amInstant = new SinglePatternHunger();

    private SinglePatternHunger() { System.out.println("I am SinglePatternHunger");}

    public static SinglePatternHunger getInstance() {
        return amInstant;
    }
}


class SinglePatternLazy {

    private SinglePatternLazy() {System.out.println("I am SinglePatternHunger");}

    public static synchronized SinglePatternLazy getInstance() {
        return InstantHolder.mInstant;
    }

    private static class InstantHolder {
        private static SinglePatternLazy mInstant = new SinglePatternLazy();
    }
}
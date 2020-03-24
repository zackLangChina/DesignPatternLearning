interface Sword {
    void showProperty();
}
//一把黄金剑
class GoldSword implements Sword {

    @Override
    public void showProperty() {
        System.out.println(getClass().getName());
    }
}
//一把木剑
class WoodSword implements Sword {

    @Override
    public void showProperty() {
        System.out.println(getClass().getName());
    }
}
//装饰类
class SwordDecorator implements Sword {
    Sword mBase;

    public SwordDecorator(Sword mBase) {
        this.mBase = mBase;
    }
    //可以动态更换需要装饰的类
    public void attachBase(Sword mBase) {
        this.mBase = mBase;
    }
    //给大宝剑们上Buff！
    @Override
    public void showProperty() {
        mBase.showProperty();
        System.out.println("+8 稀有品质！");
    }
}
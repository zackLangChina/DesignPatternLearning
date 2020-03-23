//定义流程的抽象类
abstract class TempPattern {
    public void templateMethod() {
        firstMethod();
        secondMethod();
        lastMethod();
    }

    //抽象方法不能有函数体，且子类必须实现抽象方法
    abstract protected void firstMethod();
    abstract protected void secondMethod();
    abstract protected void lastMethod();
}

//模板实现类，可以自定义流程中具体做什么
class TempClass extends TempPattern {
    protected void firstMethod() {
        System.out.println("first, do something");
    }
    protected void secondMethod() {
        System.out.println("second, do something");
    }
    protected void lastMethod() {
        System.out.println("last, do something");
    }
}
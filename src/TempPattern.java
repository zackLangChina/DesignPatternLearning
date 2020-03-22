//定义流程的抽象类
abstract class TempPattern {
    public void templateMethod() {
        firstMethod();
        secondMethod();
        lastMethod();
    }

    protected void firstMethod() {};
    protected void secondMethod() {};
    protected void lastMethod() {};
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
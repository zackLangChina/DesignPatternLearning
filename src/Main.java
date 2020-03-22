public class Main {

    public static void main(final String[] args) {
        //单例模式
        System.out.println("~~~~~单例模式~~~~~");
        SinglePatternHunger singleHunger = SinglePatternHunger.getInstance();
        SinglePatternLazy singleLazy = SinglePatternLazy.getInstance();

        //工厂模式
        System.out.println("~~~~~工厂模式~~~~~");
        NiuBiFactory factory = new NiuBiFactory();
        factory.product();

        //策略模式
        System.out.println("~~~~~策略模式~~~~~");
        new StrategyPattern().doDenoise();

        //命令模式
        System.out.println("~~~~~命令模式~~~~~");
        new commander(new Soldier());

        //观察者模式
        System.out.println("~~~~~观察者模式~~~~~");
        ObserverPattern obPattern = new ObserverPattern();
        obPattern.addObserver(new LaoWang());
        obPattern.addObserver(new ZhangSan());
        obPattern.notifyObserver();

        //备忘录模式
        System.out.println("~~~~~备忘录模式~~~~~");
        MemoPattern memoPattern = new MemoPattern("9点开会");
        System.out.println("计划：" + memoPattern.toString());
        MyMemo memo = memoPattern.createMemo();
        memoPattern.setWhatToDO("9点玩游戏");
        System.out.println("计划：" + memoPattern.toString());
        memoPattern.restore(memo);
        System.out.println("恢复计划后：" + memoPattern.toString());

        //模板模式
        System.out.println("~~~~~模板模式~~~~~");
        TempClass tempClass = new TempClass();
        tempClass.templateMethod();
    }
}

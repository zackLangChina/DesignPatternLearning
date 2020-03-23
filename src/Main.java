public class Main {

    public static void main(final String[] args) {
        //单例模式
        System.out.println("~~~~~单例模式~~~~~");
        //创建实例时，构造函数会有打印
        SinglePatternHunger singleHunger = SinglePatternHunger.getInstance();
        SinglePatternLazy singleLazy = SinglePatternLazy.getInstance();
        //下面获取的是和上面同样的实例，所以不会有新的打印
        SinglePatternHunger singleHunger2 = SinglePatternHunger.getInstance();
        SinglePatternLazy singleLazy2 = SinglePatternLazy.getInstance();

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

        //中介模式
        System.out.println("~~~~~中介模式~~~~~");
        MyMediator mediator = new MyMediator();
        IService service = new MyService();
        mediator.regist(service);
        MyClient client = new MyClient(mediator);
        client.invokeService();
    }
}

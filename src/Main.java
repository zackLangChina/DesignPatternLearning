import java.util.List;

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
        ServiceA serviceA = new ServiceA(mediator);
        ServiceB serviceB = new ServiceB(mediator);
        mediator.addService("ServiceA",serviceA);
        mediator.addService("ServiceB",serviceB);
        serviceA.callService("ServiceB");
        serviceB.callService("ServiceA");


        //代理模式
        System.out.println("~~~~~代理模式~~~~~");
        ProxyService proxyService = new ProxyService();
        IProxyService proxy = ProxyServiceManager.getInstance().getService(proxyService.SERVICE_NAME_PROXYSERVICE);
        proxy.doSomething();

        //适配器模式
        System.out.println("~~~~~适配器模式~~~~~");
        int[] sugers = {4,5};int[] eggs = {1,9};
        CakeAdapter adapter = new CakeAdapter(sugers,eggs);
        List<Cake> cakes =  adapter.productCake();

        //装饰模式
        System.out.println("~~~~~装饰模式~~~~~");
        Sword woodSword = new WoodSword();
        Sword goldSword = new GoldSword();
        SwordDecorator decorator = new SwordDecorator(woodSword);
        decorator.showProperty();
        decorator.attachBase(goldSword);
        decorator.showProperty();

        //享元模式
        System.out.println("~~~~~享元模式~~~~~");
        Library lib = new Library();
        Book mathBook1 = lib.borrowBook(MathBook.class);
        Book comicBook1 = lib.borrowBook(ComicBook.class);
        lib.returnBook(mathBook1);
        lib.returnBook(comicBook1);
        //这时书池中已经有这两本书了，再借就不会触发构造函数
        Book mathBook2 = lib.borrowBook(MathBook.class);
        Book comicBook2 = lib.borrowBook(ComicBook.class);

        //外观模式
        System.out.println("~~~~~外观模式~~~~~");
        Person person = new LiSi();
        person.talk();
        person.hear();
        person.smell();

        //桥接模式
        System.out.println("~~~~~桥接模式~~~~~");
        Color red = new Red();
        Width bigPaint = new BigWidth();
        Style fillStyle = new FillStyle();
        Paint paint = new Paint(red,bigPaint,fillStyle);
        paint.draw();
        paint.setWidth(new LittleWidth());
        paint.setColor(new Green());
        paint.draw();
    }
}

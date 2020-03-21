public class Main {

    public static void main(final String[] args) {
        //单例模式
        System.out.println("单例模式");
        SinglePatternHunger singleHunger = SinglePatternHunger.getInstance();
        SinglePatternLazy singleLazy = SinglePatternLazy.getInstance();

        //工厂模式
        System.out.println("工厂模式");
        NiuBiFactory factory = new NiuBiFactory();
        factory.product();

        //策略模式
        System.out.println("策略模式");
        new StrategyPattern().doDenoise();

        //命令模式
        System.out.println("命令模式");
        new commander(new Soldier());
    }
}

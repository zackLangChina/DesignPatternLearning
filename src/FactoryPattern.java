//具体工厂类
class NiuBiFactory implements Factory{

    @Override
    public Production product() {
        return new MostNiuBiProduction();
    }
}
//工厂接口
interface Factory {
    Production product();
}
//产品基类
abstract class Production {
}
//被淘汰不再生产的产品，从工厂撤下来了
class NiuBiProduction extends Production {
    public NiuBiProduction() {
        System.out.println("product NiuBiProduction");
    }
}
//目前生产的产品，通过工厂生产
class MostNiuBiProduction extends Production {
    public MostNiuBiProduction() {
        System.out.println("product MostNiuBiProduction");
    }
}
/**
 * 工厂模式
 */
class NiuBiFactory implements Factory{

    @Override
    public Production product() {
        return new MostNiuBiProduction();
    }
}

interface Factory {
    Production product();
}

abstract class Production {

}

class NiuBiProduction extends Production {
    public NiuBiProduction() {
        System.out.println("product NiuBiProduction");
    }
}

class MostNiuBiProduction extends Production {
    public MostNiuBiProduction() {
        System.out.println("product MostNiuBiProduction");
    }
}
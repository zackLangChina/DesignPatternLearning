//策略类
public class StrategyPattern {
    private Denoising curDenoiseStrategy = new NiubiDenoising();

    public void doDenoise() {
        //客户端不知道具体用哪个Denoising接口实现类，由策略类选择
        curDenoiseStrategy.doDenoise();
    }
}
//算法接口
interface Denoising {
    void doDenoise();
}
//具体算法
class NiubiDenoising implements Denoising {

    @Override
    public void doDenoise() {
        System.out.println("Do Denoise fast and nice!");
    }
}
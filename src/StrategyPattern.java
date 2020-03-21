/**
 * 策略模式 便于改变具体使用的算法，而不需要客户端修改代码
 */
public class StrategyPattern {
    private Denoising curDenoiseStrategy = new NiubiDenoising();

    public void doDenoise() {
        //客户端不知道具体用哪个Denoising接口实现类，由策略类选择
        curDenoiseStrategy.doDenoise();
    }
}

interface Denoising {
    void doDenoise();
}

class NiubiDenoising implements Denoising {

    @Override
    public void doDenoise() {
        System.out.println("Do Denoise fast and nice!");
    }
}
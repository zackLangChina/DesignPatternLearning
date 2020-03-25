//外观接口
interface Person {
    void talk();
    void hear();
    void smell();
}
//外观类，将三个子系统（嘴耳鼻）整合，并提供对外的接口
class LiSi implements Person {
    private Mouth mMouth;
    private Ear mEar;
    private Nose mNose;

    public LiSi() {
        mMouth = new Mouth();
        mEar = new Ear();
        mNose = new Nose();
    }

    @Override
    public void talk() {
        mMouth.talk();
    }

    @Override
    public void hear() {
        mEar.hear();
    }

    @Override
    public void smell() {
        mNose.smell();
    }
}
//子系统，嘴
class Mouth {
    public void talk() {
        System.out.println("use Mouth to talk");
    }
}
//子系统，耳
class Ear {
    public void hear() {
        System.out.println("use Ear to hear");
    }
}
//子系统，鼻
class Nose {
    public void smell() {
        System.out.println("use Nose to smell");
    }
}
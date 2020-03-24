import java.util.HashMap;
import java.util.Map;

//中介者
class MyMediator {
    private Map<String,IService> mServiceList = new HashMap<String,IService>();
    //加入同事类
    public void addService(String name, IService service) {
        mServiceList.put(name,service);
    }
    //中介调用
    public void invokeService(String name) {
        mServiceList.get(name).receiveCall();
    }
}
//同事类，模仿服务之间相互调用
interface IService {
    void callService(String name);
    void receiveCall();
}
//同事类A,可以调用其他同事类，但不需要耦合其他同事类
class ServiceA implements IService {
    private MyMediator mMediator;

    public ServiceA(MyMediator mMediator) {
        this.mMediator = mMediator;
    }

    @Override
    public void callService(String name) {
        System.out.println("ServiceA callService:" + name);
        mMediator.invokeService(name);
    }

    @Override
    public void receiveCall() {
        System.out.println("ServiceA invoked");
    }
}
//同事类B,可以调用其他同事类，但不需要耦合其他同事类
class ServiceB implements IService {
    private MyMediator mMediator;

    public ServiceB(MyMediator mMediator) {
        this.mMediator = mMediator;
    }

    @Override
    public void callService(String name) {
        System.out.println("ServiceB callService:" + name);
        mMediator.invokeService(name);
    }

    @Override
    public void receiveCall() {
        System.out.println("ServiceB invoked");
    }
}
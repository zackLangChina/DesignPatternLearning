import java.util.HashMap;
import java.util.Map;

//中介者
class MyMediator {
    private Map<String,IService> mServiceList = new HashMap<String,IService>();

    public void regist(IService service) {
        mServiceList.put(service.getServiceName(),service);
    }

    public IService getService(String serviceName) {
        return (IService)mServiceList.get(serviceName);
    }
}
//模仿Android中的服务所定义的接口
interface IService {
    public String getServiceName();
    public void printServiceName();
}
//模仿Android中的服务
class MyService implements IService {
    private final String MY_SERVICE_NAME = "MyService";

    @Override
    public String getServiceName() {
        return MY_SERVICE_NAME;
    }

    @Override
    public void printServiceName() {
        System.out.println("You invoke " + MY_SERVICE_NAME);
    }
}
//模仿Android中调用服务的客户端
//只需要知道服务名就能通过中介者调用服务，不需要耦合具体对象
class MyClient {
    private MyMediator mMediator;
    private final String MY_SERVICE_NAME = "MyService";

    public MyClient(MyMediator mediator) {
        this.mMediator = mediator;
    }

    public void invokeService() {
        IService service = mMediator.getService(MY_SERVICE_NAME);
        service.printServiceName();
    }
}

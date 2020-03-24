import java.util.HashMap;
import java.util.Map;
//模仿android中的ServiceManager，管理所有service（其实管理的是代理proxy）
class ProxyServiceManager {
    private static ProxyServiceManager mInstant = new ProxyServiceManager();
    private Map<String, IProxyService> mProxyList = new HashMap<String, IProxyService>();

    private ProxyServiceManager() {
    }

    public static ProxyServiceManager getInstance() {
        return mInstant;
    }

    public void addService(String name,IProxyService service) {
        mProxyList.put(name,service);
    }

    public IProxyService getService(String name) {
        return mProxyList.get(name);
    }
}
//服务和代理的公用接口。不同服务实现不同的接口。类似于AIDL
interface IProxyService {
    void doSomething();
}
//类似于AIDL生成的代码的结构（没有binder），真正的服务中嵌套一个内部proxy类
class ProxyService implements IProxyService {
    public String SERVICE_NAME_PROXYSERVICE = "proxy";
    private ProxyService mInstant;

    public ProxyService() {
        mInstant = this;
        ProxyServiceManager.getInstance().addService(SERVICE_NAME_PROXYSERVICE,new MyProxy());
    }
    //服务端的接口实现，业务代码放在这
    @Override
    public void doSomething() {
        System.out.println("now, Service do something");
    }
    //内部proxy类，实际上注册到ProxyServiceManager的是它。负责与真正的service通信
    class MyProxy implements IProxyService {
        //proxy的接口实现，只负责通信
        @Override
        public void doSomething() {
            System.out.println("proxy call Service do something...");
            mInstant.doSomething();
        }
    }
}
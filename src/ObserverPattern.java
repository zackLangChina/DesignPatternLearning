import java.util.ArrayList;
import java.util.List;

//通知者
class ObserverPattern {
    private List<IObserver> mObservers = new ArrayList<>();
    //加入观察者
    public void addObserver(IObserver observer) {
        mObservers.add(observer);
    }
    //通知[所有]观察者
    public void notifyObserver() {
        for (IObserver ob : mObservers) {
            ob.callback();
        }
    }
}

//观察者接口
interface IObserver {
    void callback();
}

//具体的观察者
class LaoWang implements IObserver {

    @Override
    public void callback() {
        System.out.println("老王知道了！");
    }
}
//具体的观察者
class ZhangSan implements IObserver {

    @Override
    public void callback() {
        System.out.println("张三知道了！");
    }
}
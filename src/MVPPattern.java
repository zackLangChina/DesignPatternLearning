//V
interface IView {
    //注入Presenter
    void attachPresenter(IPresenter presenter);
    //功能函数
    void clickLogin();
    void showMessage(String message);
}
class LoginView implements IView {
    private IPresenter mPreseter;

    @Override
    public void attachPresenter(IPresenter presenter) {
        mPreseter = presenter;
    }

    @Override
    public void clickLogin() {
        mPreseter.login();
    }

    @Override
    public void showMessage(String message) {
        System.out.println("View msg :" + message);
    }
}
//M
interface ICheckModel {
    boolean checkLogin();
}
class UserCheckModel implements ICheckModel {

    @Override
    public boolean checkLogin() {
        System.out.println("Model checkLogin :" + true);
        return true;
    }
}
interface IDBModel {
    void insertDB();
}
class DBModel implements IDBModel {

    @Override
    public void insertDB() {
        System.out.println("Model insertDB");
    }
}
//外观模式，包含所有Model，集中所有对外暴露的API
interface IDataManager {
    //注入Presenter
    void attachPresenter(IPresenter presenter);
    void login();
}
class DataManager implements IDataManager {
    private IPresenter mPreseter;
    private IDBModel mDBModel;
    private ICheckModel mCheckModel;

    public DataManager(IDBModel mDBModel, ICheckModel mCheckModel) {
        this.mDBModel = mDBModel;
        this.mCheckModel = mCheckModel;
    }

    @Override
    public void attachPresenter(IPresenter presenter) {
        mPreseter = presenter;
    }

    @Override
    public void login() {
        //检查用户合法性并将登陆操作写入DB保存
        mCheckModel.checkLogin();
        mDBModel.insertDB();
    }
}
//P
interface IPresenter<V extends IView> {
    //关联 取消关联View
    void onAttach(V view);
    void onDetach(V view);
    void login();
}
class MVPPresenter<V extends IView> implements IPresenter<V> {
    private IView mView;
    private IDataManager mDataManager;

    public MVPPresenter(IDataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V view) {
        mView = view;
    }

    @Override
    public void onDetach(V view) {
        mView = null;
    }

    @Override
    public void login() {
        //来自View的调用，先调用Model，再向View发消息
        mDataManager.login();
        mView.showMessage("login OK");
    }
}
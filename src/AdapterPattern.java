import java.util.ArrayList;
import java.util.List;
//目标产品
class Cake {
    private int sugers;
    private int eggs;

    public Cake(int sugers, int eggs) {
        this.sugers = sugers;
        this.sugers = eggs;
        System.out.println("I am Cake, made by " +  sugers + " sugers and " + eggs + " eggs");
    }
}
//适配器接口，我们可以有不同的适配器实现
interface ICakeAdapter {
    List<Cake> productCake();
}
//适配器实现，用糖和鸡蛋做蛋糕
class CakeAdapter implements ICakeAdapter{
    private int[] sugerList;
    private int[] eggList;

    public CakeAdapter(int[] sugerList, int[] eggList) {
        if(sugerList.length!=eggList.length) {
            System.out.println("原料数量不匹配");
            return;
        }
        this.sugerList = sugerList;
        this.eggList = eggList;
    }
    //用糖和鸡蛋批量制作蛋糕提供给客户端
    @Override
    public List<Cake> productCake() {
        List<Cake> cakes = new ArrayList<Cake>();
        for(int i=0;i<sugerList.length;i++) {
            cakes.add(new Cake(sugerList[i],eggList[i]));
        }
        sugerList = null;
        eggList = null;
        return cakes;
    }
}


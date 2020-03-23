import java.util.ArrayList;
import java.util.List;
//命令接口
interface Command {
    public void execute();
}
//具体命令：开火！
class FireCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Fire !!");
    }
}
//具体命令：停火！
class StopCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Stop !!");
    }
}
//指挥官，负责下达（实例化）命令给执行者
class commander {
    private List<Command> commandList = new ArrayList<Command>();
    private Soldier mSoldier;

    public commander(Soldier soldier) {
        mSoldier = soldier;
        //将命令放入队列
        commandList.add(new FireCommand());
        commandList.add(new StopCommand());
        //按顺序执行
        for (Command cmd : commandList) {
            soldier.executeCmd(cmd);
        }
    }
}
//命令执行者
class Soldier {
    public void executeCmd(Command cmd) {
        cmd.execute();
    }
}
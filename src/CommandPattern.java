import java.util.ArrayList;
import java.util.List;

interface Command {
    public void execute();
}

class FireCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Fire !!");
    }
}

class StopCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Stop !!");
    }
}

/**
 * 命令生产者
 */
class commander {
    private List<Command> commandList = new ArrayList<Command>();
    private Soldier mSoldier;

    public commander(Soldier soldier) {
        mSoldier = soldier;
        commandList.add(new FireCommand());
        commandList.add(new StopCommand());
        for (Command cmd : commandList) {
            soldier.executeCmd(cmd);
        }
    }
}

/**
 * 命令消费者
 */
class Soldier {
    public void executeCmd(Command cmd) {
        cmd.execute();
    }
}
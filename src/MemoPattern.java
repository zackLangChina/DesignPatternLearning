//要备份状态的对象
class MemoPattern {
    private String mWhatToDO;
    private MyMemo mMemo;

    public MemoPattern(String whatToDO) {
        this.mWhatToDO = whatToDO;
    }

    public void setWhatToDO(String whatToDO) {
        this.mWhatToDO = whatToDO;
    }

    public String toString() {
        return mWhatToDO;
    }

    //使用当前状态创建memo
    public MyMemo createMemo() {
        return new MyMemo(mWhatToDO);
    }

    //使用memo恢复状态
    public void restore(MyMemo memo) {
        mWhatToDO = memo.getmWhatToDo();
    }
}

//备忘录，用于存储状态
class MyMemo {
    private String mWhatToDo;

    public MyMemo(String whatToDo) {
        this.mWhatToDo = whatToDo;
    }

    public String getmWhatToDo() {
        return mWhatToDo;
    }
}
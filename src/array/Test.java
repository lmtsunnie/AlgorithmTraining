package array;

class Obj {
    public void setStr(String str) {
        this.str = str;
    }
    private String str = "default value";
    public String getStr() {
        return str;
    }
}
public class ChangeObj implements Cloneable{
    private Obj obj = new Obj();
    private int a = 0;
    public Obj getObj() {
        return obj;
    }

    public int getInt() {
        return a;
    }
    public void changeObj(Obj obj) {
        obj.setStr("changed value");
    }

    public void changeInt(int a) {
        a = 1;
    }

    public static void main(String[] args) {
        ChangeObj changeObj = new ChangeObj();
        System.out.println("调用changeObj()前：" + changeObj.getObj().getStr());
        changeObj.changeObj(changeObj.getObj());
        System.out.println("调用changeObj()后：" + changeObj.getObj().getStr());
        System.out.println("调用changeInt()前：" + changeObj.getInt());
        changeObj.changeInt(changeObj.getInt());
        System.out.println("调用changInt()后：" + changeObj.getInt());
        Object object = new Object();
        object.clone()
    }
}

/**
 * @author ：hongyan
 * @date ：Created in 2022/9/19 16:08
 * @description：a
 */
public class Father {
    protected String name;
    Father(String name) {
        this.name = name;
    }

    public void m() {}
}

class Child extends Father{
    Child(String name) {
//        super(name);
//        this.name = name;
//        super.m();

//        this.name = name;
//        super(name);
//        super.m();

        super(name);
        super.m();
        this.name = name;

    }
}

package InheritancePlayground;

public class JavaChild extends JavaFather{
    private String nickName;

    public JavaChild(String name, String nickName) {
        super(name);
        this.nickName = nickName;
    }

    @Override
    public void publicPrintName() {
        printName();
    }

    // final method cannot be overridden

    @Override
    protected void protectedPrintName() {
        printName();
    }

    private void printName() {
        System.out.println(super.getName() + " " + nickName + " from child class");
    }
}

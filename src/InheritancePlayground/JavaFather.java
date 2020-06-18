package InheritancePlayground;

class JavaFather {
    private String name;

    public JavaFather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void publicPrintName() {
        printName();
    }

    final public void finalPublicPrintName() {
        printName();
    }

    protected void protectedPrintName() {
        printName();
    }

    private void printName() {
        System.out.println(name + " from Father class");
    }
}

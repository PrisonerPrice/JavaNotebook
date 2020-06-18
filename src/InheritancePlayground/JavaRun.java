package InheritancePlayground;

public class JavaRun {

    public static void main(String[] args) {
        JavaFather javaChild1 = new JavaChild("Tom", "Shark");
        JavaChild javaChild2 = new JavaChild("Jack", "Panda");

        javaChild1.finalPublicPrintName();
        javaChild1.publicPrintName();
        javaChild1.protectedPrintName();

        javaChild2.finalPublicPrintName();
        javaChild2.publicPrintName();
        javaChild2.protectedPrintName();

        /*
        Output:
        Tom from Father class
        Tom Shark from child class
        Tom Shark from child class
        Jack from Father class
        Jack Panda from child class
        Jack Panda from child class
         */
    }
}

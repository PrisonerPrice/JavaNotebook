package InheritancePlayground

fun main() {
    val kotlinChild1: KotlinFather = KotlinChild("Tom", "Shark")
    val kotlinChild2: KotlinChild = KotlinChild("Jack", "Panda")

    // protected = private + subclass

    kotlinChild1.publicPrintName()
    kotlinChild1.finalPublicPrintName()
    // cannot do kotlinChild1.protectedPrintName()

    kotlinChild2.publicPrintName()
    kotlinChild2.finalPublicPrintName()
    // cannot do kotlinChild2.protectedPrintName()

    /*
    Output:
    Tom Shark from child class
    Tom from father class
    Jack Panda from child class
    Jack from father class
     */
}
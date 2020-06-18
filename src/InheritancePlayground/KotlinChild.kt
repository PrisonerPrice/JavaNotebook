package InheritancePlayground

class KotlinChild(name: String, private val nickName: String) : KotlinFather(name) {

    override fun publicPrintName() {
        privatePrintName()
    }

    override fun protectedPrintName() {
        privatePrintName()
    }

    private fun privatePrintName() {
        //val name = super.getName()
        println("$name $nickName from child class")
    }
}
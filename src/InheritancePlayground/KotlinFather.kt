package InheritancePlayground

// in kotlin, only class with open can be inherited
open class KotlinFather(protected val name: String) {

    // in kotlin, only function with open can be overridden
    open fun publicPrintName() {
        privatePrintName()
    }

    // final keyword is useless to denote a function cannot be overridden
    fun finalPublicPrintName() {
        privatePrintName()
    }

    open protected fun protectedPrintName() {
        privatePrintName()
    }

    private fun privatePrintName() {
        println("$name from father class")
    }
}
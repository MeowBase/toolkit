package com.meowool.sweekt

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class LazyInit


@Suppress("unused")
fun Any.resetLazyValue() {
    throw UnsupportedOperationException("Implemented by compiler plugin")
}

fun resetLazyValues(vararg lazyProperties: Any) {
    throw UnsupportedOperationException("Implemented by compiler plugin")
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Info(
    val generateCopy: Boolean = true,
    val generateEquals: Boolean = true,
    val generateHashCode: Boolean = true,
    val generateToString: Boolean = true,
    val generateComponentN: Boolean = true,

    val joinPrivateProperties: Boolean = false,
    val joinPrimaryProperties: Boolean = true,
    val joinBodyProperties: Boolean = true,

    val callSuperEquals: Boolean = true,
    val callSuperHashCode: Boolean = true,
) {
    @Target(AnnotationTarget.PROPERTY)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Invisible(
        val generateCopy: Boolean = false,
        val generateEquals: Boolean = false,
        val generateHashCode: Boolean = false,
        val generateToString: Boolean = false,
        val generateComponentN: Boolean = false,
    )

    interface Synthetic {

        /**
         * Invokes the `equals` method generated by the compiler for the [Info] class.
         *
         * Note that this annotation depends on [Info]. This method can only be invoked in the class annotated with [Info],
         * otherwise the Kotlin's compiler will report an error.
         */
        @Suppress("UNUSED_PARAMETER")
        fun infoEquals(other: Any?): Boolean = true

        /**
         * Invokes the `hashCode` method generated by the compiler for the [Info] class.
         *
         * Note that this annotation depends on [Info]. This method can only be invoked in the class annotated with [Info],
         * otherwise the Kotlin's compiler will report an error.
         */
        fun infoHashCode(): Int = 0

        /**
         * Invokes the `toString` method generated by the compiler for the [Info] class.
         *
         * Note that this annotation depends on [Info]. This method can only be invoked in the class annotated with [Info],
         * otherwise the Kotlin's compiler will report an error.
         */
        fun infoToString(): String = ""
    }
}
fun main() {

    val fraction1 = Fraction(2,3)
    val fraction2 = Fraction(1,5)

    val result = fraction1.multiply(fraction2)

    println(result)

}

class Fraction (private var numerator: Int, private var denominator: Int) {
    init {
        if (denominator == 0) {
            throw Exception("Denominator should not be 0")
        }

    }

    fun multiply(fraction: Fraction) : Fraction {
        val n = this.numerator * fraction.numerator
        val d = this.denominator * fraction.denominator

        //reduce
        val f: Int = gcd(n, d)

        return Fraction(n/f, d/f)
    }


    private fun gcd(n: Int, d: Int): Int {
        return if (d != 0)
            gcd(d, n % d)
        else
            n
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

}
package src

import kotlin.math.pow

class Polynomial() {

    fun calculateAt(x:Double): Double {
        var result: Double = 0.0;
        for(i in 0..power) {
            result += x.pow(i)*coefficients[i]
        }
        return result
    }

    var coefficients: MutableList<Double> = mutableListOf()
        get() = field
        set(givenCoefficients) {
            field = givenCoefficients
            power = givenCoefficients.size
        }

    var power: Int = this.coefficients.size
        get() = field

    constructor(coefficients: MutableList<Double>) : this() {
        this.coefficients = coefficients
        this.power = coefficients.size
    }
}
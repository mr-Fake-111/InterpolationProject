package src_current

import SLAE_methods_functions.*
import kotlin.math.pow

class Interpolator {
    companion object {
        fun interpolationPolynomialNewton(nodes: HashMap<Double, Double>): Polynomial {
            val newtonPolynomial = Polynomial()


            return newtonPolynomial
        }

        fun interpolationPolynomialLagrange(nodes: Array<DoubleArray>): Polynomial {
            val n =  nodes.size

            var matrix = Array<DoubleArray>(n) {DoubleArray(n) }
            var vector = Array<DoubleArray>(n) {DoubleArray(1) }
            for(i in 0..(n-1)) {
                for(j in 0..(n-1)) {
                    matrix[i][j] = nodes[i][0].pow(n-j-1)
                }
            }
            for(i in 0..(n-1)) {
                vector[i][0] = nodes[i][1]
            }

            val preCoefficients = SLAEAccurateMethods.ReflectionMethod(matrix, vector)
            val coefficients = MutableList<Double>(n) {0.0}
            for(i in 0..(n-1)) {
                coefficients[i] = preCoefficients[i][0]
            }

            return Polynomial(coefficients)
        }

        fun interpolationSPLine(nodes: HashMap<Double, Double>): Polynomial {

            return Polynomial()
        }
    }
}
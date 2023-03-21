package src_current

import SLAE_methods_functions.*
import kotlin.math.pow

class Interpolator {
    companion object {

        fun interpolationPolynomialSLAE(nodes: Array<DoubleArray>): Polynomial {

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

        //данный метод не возвращает полином в явном виде, а лишь сводит вычисление сложной функции к полиномиальным вычислениям
        //то есть возвращает значение в точке, обусловленное таблицей узлов и спецификой построения полинома
        //я мог бы перегрузить метод, чтобы он был хоть как-то применим за пределами задания, но .... пока не судьба
        fun interpolationPolynomialLagrange(nodes: Array<DoubleArray>, spot: Double): Double {
            var spotVal = 0.0

            for( i in 0..(nodes.size-1)) {
                var currPart = 1.0
                for(j in 0.. (i-1)){
                    currPart *= (spot - nodes[j][0])/(nodes[i][0] - nodes[j][0])
                }
                for(j in (i+1).. (nodes.size-1)){
                    currPart *= (spot - nodes[j][0])/(nodes[i][0] - nodes[j][0])
                }
                currPart *= nodes[i][1]
                spotVal += currPart
            }

            return spotVal
        }

        //как и с предыдущим методом, в явном виде найти полином сложно, так что возвращаем только значение в точке
        fun interpolationPolynomialNewton(nodes: Array<DoubleArray>, spot:Double): Double {
            var spotVal = 0.0

            for(k in 0..(nodes.size-1)) {
                var currSumPart = 0.0

                //использована альтернативная формула разделенной разности
                for(i in 0..k) {
                    var currMultPart = nodes[i][1]

                    for (j in 0..(i - 1)) {
                        currMultPart /= (nodes[i][0] - nodes[j][0])
                    }
                    for (j in (i + 1)..k) {
                        currMultPart /= (nodes[i][0] - nodes[j][0])
                    }
                    currSumPart += currMultPart
                }

                //после чего c найденной разделенной разностью производим домножение на множители вида (x-xi), где i = 0..(k-1)
                for(i in 0..(k-1)) {
                    currSumPart *= (spot - nodes[i][0])
                }
                //добавляем слагаемое из предсталения полинома Ньютона в результирующую переменную
                spotVal += currSumPart
            }

            return spotVal
        }

        fun interpolationSPLineLinear(nodes: HashMap<Double, Double>): Polynomial {

            return Polynomial()
        }
    }
}
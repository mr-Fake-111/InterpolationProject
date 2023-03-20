import src.Interpolator

fun main(args: Array<String>) {
    val properties = Array<DoubleArray>(4) {DoubleArray(2)}
    for(i in 0..3) {
        properties[i][0] = i.toDouble()
        properties[i][1] = Math.pow(i.toDouble(), 3.0) - 3.0
    }

    val poly = Interpolator.interpolationPolynomialLagrange(properties)
    print(poly.coefficients)
}
import src_current.Interpolator
import src_current.UserFunction
import src_current.*

fun main(args: Array<String>) {


    val nodes = NodeGenerator.getStandartNodes(0.0, Math.PI, 6)
    val properties = UserFunction.getNodes(nodes)
    val poly = Interpolator.interpolationPolynomialSLAE(properties)
    println(poly.toString())
    println(Interpolator.interpolationPolynomialNewton(properties, 3.0))
    println(Interpolator.interpolationPolynomialLagrange(properties, 3.0))
    Interpolator.interpolationSplineLinear(properties)
}
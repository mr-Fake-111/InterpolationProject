import src_current.Interpolator
import src_current.UserFunction
import src_current.*

fun main(args: Array<String>) {


    val properties = UserFunction.getNodes(getStandartNodes(0.0, 5*Math.PI, 6))
    val poly = Interpolator.interpolationPolynomialLagrange(properties)
    print(poly.toString())
}
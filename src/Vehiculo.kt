import java.util.*

/**
 * Clase base Vehiculo
 *
 * @property nombre String será el nombre asignado al vehículo.
 * @property marca String Es el nombre de la marca vehículo.
 * @property modelo String Es el nombre del modelo del vehículo.
 * @property capacidadCombustible Float Es la capacidad total del tanque de gasolina.
 * @property combustibleActual Float Es la cantidad de combustible que hay en ése momento en el tanque.
 * @property kilometrosActuales Float Es la cantidad de km que ha recorrido el vehículo.
 */
open class Vehiculo(
    nombre: String,
    open val marca: String,
    open val modelo: String,
    open val capacidadCombustible: Float,
    open var combustibleActual: Float,
    open var kilometrosActuales: Float
) {
    private var nombre: String = nombre
        set(value) {
            require(value.isNotBlank()) { "No puedes ingresar un valor vacío." }
            require(value.lowercase(Locale.getDefault()) != field.lowercase(Locale.getDefault())) { "El nombre '$value' ya está en uso." }
            field = value
        }
    companion object {
        const val KM_POR_LITRO = 10f
    }

    //METODOS DE CLASE:
    /**
     * Obtener Informacion:
     * @return Devuelve un mensaje con los km que aún puede realizar el vehículo con el combustibleActual.
     */
    open fun obtenerInfo(): String {
        return ("Con el combustible actual, el vehiculo puede recorrer aún: ${kilometrosActuales * KM_POR_LITRO}km.")
    }

    /**
     * Calcular autonomía:
     * Cada vehículo tiene una autonomía de 10km por cada litro de combustible.
     * @return Float Devuelve la cantidad de km que el vehículo puede realizar
     */
    open fun calcularAutonomia(): Float {
        return combustibleActual * KM_POR_LITRO
    }

    /**
     * Realizar viaje:
     * @param distancia Es la cantidad de km que deberá recorrer el vahículo.
     * @return 0.0 si ha conseguido recorrer la distancia, o aquellos km que no ha conseguido recorrer por falta de combustible.
     */
    //Realiza un viaje hasta donde da combustibleActual.
    // Ajusta el combustible gastado y el kilometraje realizado de
    // acuerdo con el viaje. Devuelve la distancia restante.
    open fun realizaViaje(distancia: Float): Float {
        if (distancia < 0) {
            throw IllegalArgumentException ("La distancia no puede ser menor a 0.")
        }
        if (calcularAutonomia() > distancia) {
            kilometrosActuales += distancia
            combustibleActual -= (distancia / KM_POR_LITRO)
            return 0.0f
        } else {
            kilometrosActuales += calcularAutonomia()
            combustibleActual = 0.0f
            return distancia - calcularAutonomia()
        }

    }

    /**
     * Repostar: Incrementa combustibleActual en la cantidad que va a repostarse o en capacidadCombustible si el tanque se llena.
     * @return La cantidad de litros que se han repostado.
     */
    //si el combustibleActual es = capacidadCombustible, debera repostar 0 y devolvera la cantidad, que no ha sido repostada
    open fun repostar(cantidad: Float = 0.0f): Float {

        if (cantidad <= 0) {
            combustibleActual = capacidadCombustible
            return capacidadCombustible //Se ha repostado el tanque completo.
        } else {
            if (cantidad > capacidadCombustible) {
                val cantidadRepostada = capacidadCombustible - combustibleActual
                combustibleActual = capacidadCombustible
                return cantidadRepostada //Devuelve los litros de la capacidad del tanque, ya que se ha llenado al completo.
            } else if (combustibleActual == capacidadCombustible) {
                return 0.0f //No devuelve nada, ya que el tanque ya estaba lleno y no se ha repostado.
            } else if (combustibleActual < capacidadCombustible && ((combustibleActual + cantidad) < capacidadCombustible)) {
                combustibleActual += cantidad
                return cantidad //Devuelve la cantidad que se ha repostado.
            } else if (cantidad + combustibleActual > capacidadCombustible) {
                val cantRepostada = capacidadCombustible - combustibleActual
                return cantRepostada //Devuelve los litros que no entran en el tanque tras llenarse.
            }
        }
        return 0.0f //Si no se cumplen ninguna de las anteriores condiciones devolveremos 0 litros repostados.
    }

    /**
     * To String
     * @return Devolvemos una cadena de texto con la información requerida para el programa principal.
     */
    override fun toString(): String {
        return ("El vehículo de marca $marca, modelo $modelo y una capacidad total de $capacidadCombustible ${obtenerInfo()}")
    }
}
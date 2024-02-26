/**
 * Clase derivada Motocicleta
 *
 * @property cilindrada Int El número de cilindrada de la motocicleta.
 * @property marca String Nombre de la marca de la motocicleta.
 * @property modelo String El nombre del modelo de la marca.
 * @property capacidadCombustible Float Es la capacidad total del tanque de combustible de la motocicleta.
 * @property combustibleActual Float La cantidad de litros que contiene en ése momento el tanque de combustible.
 * @property kilometrosActuales Float Es la cantidad de km que la motocicleta ha recorrido ya.
 */
open class Motocicleta(

    cilindrada: Int,
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float

) : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    private var cilindrada: Int = cilindrada
        set(value) {
            require(cilindrada in 125..1000) { "La cilindrada sólo puede comprenderse entre 125cc y 1000cc." }
            field = value
        }

    companion object {
        const val KM_POR_LITRO = 20f
        const val CONSUMO_CABALLITO = 6.5f / 20f
    }

    //METODOS DE CLASE:
    /**
     * Calcular autonomia:
     * Calcula los km que puede recorrer la motocicleta, teniendo en cuenta la cilindrada del vehículo.
     * @return La distancia en km que puede recorrer la motocicleta, según cilindrada y combustible disponible.
     */
    override fun calcularAutonomia(): Float {
        if (cilindrada >= 1000) {
            return super.calcularAutonomia() * KM_POR_LITRO
        } else if (cilindrada < 1000) {
            return (super.calcularAutonomia() * KM_POR_LITRO) / cilindrada
        }
        return 0.0f
    }

    /**
     * Realizar viaje: Ajusta el cálculo de combustible necesario para viajes basándose en su autonomía específica.
     */
    override fun realizaViaje(distancia: Float): Float {
        return realizaViaje(distancia)
    }

    /**
     * Realizar caballito: realiza una gasto adicional en el combustible, retornando el combustible restante.
     * El gasto equivale a haber realizado 6,5 kilómetros.
     *
     */
    private fun realizarCaballito(): Float {
        if (combustibleActual > CONSUMO_CABALLITO) {
            combustibleActual -= CONSUMO_CABALLITO
            return combustibleActual
        }else if (combustibleActual < CONSUMO_CABALLITO){
            combustibleActual = 0.0f
            return combustibleActual
        }
        return 0.0f
    }

    override fun toString(): String {
        return ("El vehículo de marca $marca, modelo $modelo y una capacidad total de $capacidadCombustible con una autonomia de ${calcularAutonomia()}km. ${obtenerInfo()}. Tiene una cilindrada de ${cilindrada}cc")
    }
}
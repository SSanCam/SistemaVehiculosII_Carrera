/**
 * Clase derivada Automovil
 *
 * @param esHibrido Boolean Devuelve true si es híbrido, false si no lo és.
 * @param condicionBritanica Boolean Indica si el coche está configurado para la conducción británica.
 * @param marca String Nombre de la marca del automóvil.
 * @param modelo String El nombre del modelo de la marca.
 * @param capacidadCombustible Float Es la capacidad total del tanque de combustible del automóvil.
 * @param combustibleActual Float La cantidad de litros que contiene en ése momento el tanque de combustible.
 * @param kilometrosActuales Float Es la cantidad de km que el automóvil ha recorrido ya.
 */
open class Automovil(
    private val esHibrido: Boolean,
    private val condicionBritanica: Boolean,
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float
) : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    //METODOS DE CLASE:
    /**
     * Cambiar condicion britanica:
     * Método de clase que permite modificar la configuración de conducción británica para todos los automóviles.
     * @param nuevaCondicion Recibe la nueva condición a la que deberá cambiar el automóvil.
     * @return Devuelve el estado de la nueva condicion: true si tiene la condicion britanica, devuelve false en caso contrario.
     */
    fun cambiarCondicionBritanica(nuevaCondicion: Boolean): Boolean {
        return nuevaCondicion
    }

    /**
     * Calcular autonomia:
     * @return Devuelve la cantidad de km que puede recorrer según el combustible actual.
     */
    override fun calcularAutonomia(): Float {
        return if (!esHibrido) {
            super.calcularAutonomia()
        } else {
            super.calcularAutonomia() * 2
        }
    }

    /**
     * Realizar derrape:
     *  método que simula un derrape. Realiza una gasto adicional en el combustible, retornando el combustible restante.
     *  El gasto equivale a haber realizado 7,5 km o 6,25 km si es híbrido
     *  @return Float devuelve la cantidad de combustible que se ha usado para realizar el derrape.
     */
    fun realizaDerrape(): Float {
        if (esHibrido) {
            val combustibleRequerido = (6.25 * KM_POR_LITRO).toFloat()
            if (combustibleRequerido > combustibleActual) {
                return 0.0f
            } else if (combustibleRequerido < combustibleActual) {
                combustibleActual -= combustibleRequerido
                return combustibleActual
            }

        } else if (!esHibrido) {
            val combustibleRequerido = (7.5 * KM_POR_LITRO).toFloat()
            if (combustibleRequerido > combustibleActual) {
                return 0.0f
            } else if (combustibleRequerido < combustibleActual) {
                combustibleActual -= combustibleRequerido
                return combustibleActual
            }
        }
        return 0.0f //Se agrega un return adicional al final por petición del compilador.
    }

    /**
     * Función con al que devolveremos con forma de texto si un automívul es híbrido o no.
     * @param esHibrido Recibe el dato de si el coche es híbrido o no.
     * @return "si" Si el coche es híbrido, "no" en caso contrario.
     */
    private fun hibridacion(esHibrido: Boolean): String {
        return if (esHibrido) {
            "si"
        } else {
            "no"
        }
    }
    /**
     * Función con al que devolveremos con forma de texto si un automívul tiene conducción británica o no.
     * @param condicionBritanica Recibe el dato de si el coche tiene conducción británica o no.
     * @return "si" Si el coche tiene condicción británica, "no" en caso contrario.
     */
    private fun conduccionBritanica(condicionBritanica: Boolean): String {
        return if (condicionBritanica){
            "si"
        }else{
            return "no"
        }
    }

    override fun toString(): String {
        return ("El vehículo de marca ${super.marca}, modelo ${super.modelo} y una capacidad total de ${super.capacidadCombustible}, con una autonomia de ${calcularAutonomia()}km. ${obtenerInfo()}. Es híbrido: ${
            hibridacion(esHibrido)}. Tiene conducción británica: ${conduccionBritanica(condicionBritanica)}")
    }
}
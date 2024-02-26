/**
 * Clase carrera:
 * Gestiona el seguimiento de los movimientos y posiciones de los vehículos, el historial de sus acciones.
 *
 * @property nombreCarrera: String Es el nombre que identifica a la carrera.
 * @property distanciaTotal: String Es la distancia total que los vehículos deben recorrer para acabar la carrera.
 * @property participantes: List<Vehiculo> Una lista que contiene todos los vehículos que participan en la carrera.
 * @property estadoCarrera: Boolean Indicador de si la carrera está en curso o ha finalizado.
 * @property historialAcciones: MutableMap<String, MutableList<String>> Un mapa para registrar el historial de acciones de cada vehículo.
 *                                                                  La clave es el nombre del vehículo y el valor es una lista de strings describiendo sus acciones.
 * @property posiciones: MutableMap<String, Int>  Diccionario para mantener un registro de la posición y los kilómetros recorridos por cada vehículo.
 */
class Carrera(
    private val nombreCarrera: String,
    private val distanciaTotal: Float,
    private val participantes: List<Vehiculo>,
    private val estadoCarrera: Boolean,
    private val historialAcciones: MutableMap<String, MutableList<String>>,
    private val posiciones: MutableMap<String, Int>
) {

    /**
     * Iniciar carrera:  Inicia la carrera, estableciendo estadoCarrera a true y comenzando el ciclo de iteraciones
     * donde los vehículos avanzan y realizan acciones.
     */
    private fun iniciarCarrera() {
        //TODO  Inicia la carrera, estableciendo estadoCarrera a true y comenzando el ciclo de iteraciones
        //TODO donde los vehículos avanzan y realizan acciones.
    }

    /**
     * Repostar vehiculo:
     *
     */
    private fun repostarVehiculo(vehiculo: Vehiculo, cantidad: Float) {
        //TODO  Reposta el vehículo seleccionado, incrementando su combustibleActual y registrando la acción en historialAcciones.
    }

    /**
     * Realizar fuiligrana: Determina aleatoriamente si un vehículo realiza una filigrana y registra la acción.
     *
     * @param vehiculo Es el vehículo que realizará la filigrana.
     *
     */
    private fun realizarFiligrana(vehiculo: Vehiculo) {
        //TODO Determina aleatoriamente si un vehículo realiza una filigrana (derrape o caballito) y registra la acción.
    }

    /**
     * Actualizar posiciones:  Actualiza posiciones con los kilómetros recorridos por cada vehículo después de cada iteración,
     * manteniendo un seguimiento de la competencia.
     *
     */
    private fun actualizarPosiciones() {
        //todo
    }
}
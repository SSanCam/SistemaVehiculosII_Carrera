## Ejercicio: Sistema de Vehículos II (Ampliación)

### 1. Descripción
La actividad se centra en el diseño y desarrollo de un sistema de gestión de vehículos utilizando el paradigma de la programación orientada a objetos. 
Se creará una jerarquía de clases que modelará vehículos genéricos y especializados, tales como automóviles y motocicletas, cada uno con propiedades y 
comportamientos específicos. Además, se integrará una funcionalidad para gestionar una característica particular en los automóviles relacionada con la 
conducción británica, a través del uso de métodos de clase.

### 2. Objetivo
Desarrollar un entendimiento profundo de la herencia y la sobreescritura en la programación orientada a objetos.
Practicar la implementación de métodos de clase para modificar atributos aplicables a toda una categoría de objetos.
Reforzar el manejo de visibilidad y control de acceso a los miembros de las clases.

### 3. Trabajo a realizar

Definir la clase base Vehiculo con propiedades comunes y sus métodos correspondientes.
Implementar la clase derivada Automovil, añadiendo propiedades específicas y un método de clase para gestionar la condición de conducción británica.
Desarrollar la clase derivada Motocicleta, con propiedades únicas y la sobreescritura de métodos para reflejar su comportamiento especializado.

### 4. Estructura de Clases:

4.1. **Clase Base `Vehiculo`**
   - Propiedades: marca (String), modelo (String), capacidadCombustible (Float), combustibleActual (Float), kilometrosActuales (Float).
   - `obtenerInformacion() -> String`, Retorna los kilómetros que el vehículo puede recorrer con el combustible actual *(suponemos que cada litro da para 10 km)*.
   - `calcularAutonomia() -> Float`, que retorna un valor Float *(Suponemos que cada litro da para 10 km.)*.
   - `realizaViaje(distancia: Float) -> Float`:  Realiza un viaje hasta donde da combustibleActual. Ajusta el combustible gastado y el kilometraje realizado de acuerdo con el viaje. Devuelve la distancia restante.
   - `repostar(cantidad: float)-> Float`: Incrementa combustibleActual hasta el máximo de capacidadCombustible si no se pasa cantidad o si cantidad es 0 o negativa. Sino, incrementa en cantidad hasta llegar a capacidadCombustible. Devuelve la cantidad repostada.

***OBSERVACIONES***: 
   - Redondear a dos decimales los cálculos necesarios.
   - Utilizad constantes para definir a nivel de clase valores que no varían durante el programa... cómo pueden ser KM_POR_LITRO, AHORRO_ELECTRICO, etc.

4.2. **Clase Derivada `Automovil`**
   - Propiedades Específicas:
      - `esHibrido (Boolean)`: Indica si el automóvil es híbrido (eléctrico + gasolina) o no (solo gasolina).
      - `condicionBritanica (Boolean)`: Propiedad de clase que indica si los automóviles están configurados para conducción británica (volante a la derecha) o no.
   - Comportamiento Especializado:
      - `calcularAutonomia() -> Float`: Modifica el cálculo de autonomía asumiendo un rendimiento de 5 km más por litro si es híbrido.
   - Comportamiento Adicional:
      - `cambiarCondicionBritanica(nuevaCondicion: Boolean)`: Método de clase que permite modificar la configuración de conducción británica para todos los automóviles.
      - `realizaDerrape()-> Float`:  método que simula un derrape. Realiza una gasto adicional en el combustible, retornando el combustible restante. El gasto equivale a haber realizado 7,5 km o 6,25 km si es híbrido.

3. **Clase Derivada `Motocicleta`**
   - Propiedad específica: cilindrada (Int) (no podrá ser inferior a 125 ni superior a 1000 cc).
   - Comportamiento Especializado:
      - `calcularAutonomia() -> Float`: Modifica el cálculo de autonomía asumiendo un rendimiento de 20 km por litro.
        También afectará la cilindrada de la misma... si es 1000 no afectará, pero el resto de cilindradas menores, restará su valor dividido por 1000.
        Es decir, una motocicleta de 500 cc podrá recorrer 19.5 km por litro, mientras que una de 125 solo 19.125 y una moto de 1000cc recorrerá el máximo... 20 km por litro.
      - `realizaViaje(distancia: Float) -> Float`: Ajusta el cálculo de combustible necesario para viajes basándose en su autonomía específica.
   - Comportamiento Adicional:
      - `realizaCaballito()-> Float`: realiza una gasto adicional en el combustible,  retornando el combustible restante.  El gasto equivale a haber realizado 6,5 kilómetros.

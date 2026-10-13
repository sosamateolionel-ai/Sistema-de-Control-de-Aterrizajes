# Sistema de Control de Aterrizajes

## Descripción

Este proyecto consiste en un sistema de simulación de control de aterrizajes en un aeropuerto. Permite gestionar las solicitudes de aterrizaje de distintos aviones, verificar el estado de vuelo y controlar la disponibilidad de la pista.

La torre de control es responsable de autorizar o rechazar los aterrizajes. Solo permite que un avión ocupe la pista a la vez y la libera cuando recibe la confirmación de que el aterrizaje finalizó.

## Funcionamiento

1. Se crea una torre de control para el Aeropuerto de Mendoza.
2. Se registran tres aviones: AR1234 de Aerolíneas Argentinas, LA8070 de LATAM y FB5001 de Flybondi.
3. Los tres aviones comienzan en estado `"En vuelo"`.
4. El avión AR1234 solicita permiso y recibe autorización porque la pista está libre.
5. Los aviones LA8070 y FB5001 solicitan permiso, pero sus solicitudes son rechazadas porque la pista está ocupada.
6. AR1234 completa el aterrizaje y la torre libera la pista.
7. LA8070 vuelve a solicitar permiso y es autorizado, mientras que FB5001 debe continuar esperando.
8. AR1234 intenta solicitar permiso nuevamente, pero la torre rechaza la solicitud porque el avión ya está en tierra.
9. Finalmente, se muestran los estados de los tres aviones.

## Clase `Avion`

Representa un avión que solicita permiso para aterrizar en un aeropuerto.

### Atributos

* `codigoVuelo`: identificador del vuelo.
* `aerolinea`: nombre de la compañía aérea.
* `estadoVuelo`: estado actual del avión. Puede ser `"En vuelo"`, `"Aterrizando"` o `"En tierra"`.

### Métodos principales

* `getCodigoVuelo()`: devuelve el código del vuelo.
* `getAerolinea()`: devuelve el nombre de la aerolínea.
* `getEstadoVuelo()`: devuelve el estado actual del avión.
* `cambiarEstado(String nuevoEstado)`: actualiza el estado del avión e informa el cambio.
* `solicitarAterrizaje(TorreControl torre)`: solicita autorización a la torre de control y comunica si el permiso fue denegado.
* `completarAterrizaje(TorreControl torre)`: informa que el avión llegó a la pista y solicita la confirmación del aterrizaje.

## Clase `TorreControl`

Representa el sistema encargado de administrar los permisos de aterrizaje y la disponibilidad de la pista.

### Atributos

* `aeropuerto`: nombre del aeropuerto.
* `pistaLibre`: indica si la pista está disponible.
* `avionEnPista`: referencia al avión que tiene asignada la pista. Su valor es `null` cuando no hay ningún avión asignado.

### Métodos principales

* `autorizarAterrizaje(Avion avion)`: verifica que el avión esté en vuelo y que la pista esté libre. Si ambas condiciones se cumplen, asigna la pista, cambia el estado del avión a `"Aterrizando"` y devuelve `true`. En caso contrario, rechaza la solicitud y devuelve `false`.
* `confirmarAterrizaje(Avion avion)`: verifica que el avión que confirma sea el mismo que tiene asignada la pista. Si coincide, cambia su estado a `"En tierra"` y libera la pista.

## Ejemplo de funcionamiento

El programa utiliza tres aviones y una única pista de aterrizaje.

| Código de vuelo | Aerolínea             | Estado final |
| --------------- | --------------------- | ------------ |
| AR1234          | Aerolíneas Argentinas | Aterrizando  |
| LA8070          | LATAM                 | Aterrizando  |
| FB5001          | Flybondi              | En vuelo     |

Estos estados corresponden al final del programa: AR1234 ya aterrizó y liberó la pista; luego LA8070 recibió autorización, pero todavía no completó su aterrizaje. FB5001 continúa esperando.

## Conceptos de programación utilizados

* **Programación orientada a objetos (POO):** representación de aviones y torre de control mediante clases.
* **Encapsulamiento:** atributos privados y métodos públicos para consultar y modificar estados.
* **Asociación entre clases:** los aviones interactúan con un objeto `TorreControl`.
* **Métodos con parámetros:** permiten enviar objetos como argumentos entre clases.
* **Valores booleanos:** `autorizarAterrizaje()` devuelve `true` o `false` según el resultado de la solicitud.
* **Condicionales `if`:** validan el estado del avión y la disponibilidad de la pista.
* **Comparación de referencias:** `avion != avionEnPista` comprueba que se trate del mismo objeto.
* **Valor `null`:** representa que no hay ningún avión asignado a la pista.
* **Control de estados:** cada avión cambia de estado según las decisiones de la torre.
* **Separación de responsabilidades:** el avión solicita y comunica acciones, mientras que la torre controla la autorización y la pista.

## Tecnologías utilizadas

* Lenguaje: Java.
* Entorno de desarrollo recomendado: IntelliJ IDEA.

## Ejecución

<img width="791" height="532" alt="image" src="https://github.com/user-attachments/assets/f0b0cd55-de25-488c-b9e7-6a2afa9fb813" />
<img width="1007" height="607" alt="image" src="https://github.com/user-attachments/assets/9edfc94c-aa38-46ce-86a0-50924ecf4141" />



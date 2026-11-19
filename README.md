# Plataforma de transporte urbano

Actividad de Aprendizaje de la Unidad 4 de Programación Orientada a Objetos, Universidad de Cartagena.

Ejercicio asignado: 6. Plataforma de transporte urbano.

Estudiante: Felipe Cueto Linares (7502610047)

## Descripción

Sistema orientado a objetos que modela una plataforma de transporte urbano. Una empresa opera rutas y dispone de vehículos (convencionales, eléctricos y articulados), cada uno con su propia forma de calcular el costo de un recorrido. Las rutas pasan por estaciones mediante paradas con posición, tiempo y distancia acumulada, y algunas estaciones son de transferencia. Los conductores se asignan a vehículos mediante turnos, y los usuarios ingresan por las estaciones pagando con tarjeta prepago o billetera digital.

## Modelo

- Código PlantUML: `docs/modelo.puml`
- Diagrama de clases: `docs/diagrama.png`

## Estructura

- `src/`: clases del modelo y `Main.java` con la demostración.
- `docs/`: modelo PlantUML y diagrama generado.

## Cómo ejecutar

Requisitos: JDK 17 o superior.

Desde la raíz del proyecto:

```
javac -d out src/*.java
java -cp out Main
```

También se puede abrir el proyecto en IntelliJ IDEA y ejecutar `Main.main()`.

## Qué muestra la demostración

- Caso principal: rutas con su distancia y tiempo total, costo por tipo de vehículo, costo total de operación, turno de un conductor e ingreso de un usuario por una estación.
- Caso de prueba distinto: estación de transferencia con dos rutas, pago con saldo insuficiente, límite diario de la billetera, recarga de tarjeta y rechazo de un turno que se cruza.

/*
*
* Premisas y Requisitos:

El nombre del plato no puede ser vacío.
El precio del plato debe ser mayor que 0.
El tiempo de preparación no podrá ser igual o inferior a 1.
Un ingrediente no puede ser vacío.
Considerar el uso de propiedades de Kotlin para validar automáticamente estas restricciones tanto al crear un plato
cómo al modificar sus valores.
* */

class Plato(nombre: String, precio: Double, tiempoPreparacion: Int, val ingredientes: MutableList<String>) {
    init {
        require(nombre.trim().isNotEmpty()) {"El nombre no puede estar vacío."}
        require(precio > 0) {"El precio debe ser mayor que 0."}
        require(tiempoPreparacion > 1) {"El tiempo de preparación debe ser mayor que 1."}
        require((ingredientes.contains(" ") or ingredientes.isEmpty()) == false) {"No puede haber un ingrediente vacío."}
    }

    var nombre: String = nombre
        get() = field
        set(value) {
            require(value.trim().isNotEmpty()) {"El nombre no puede estar vacío."}
            field = value
        }

    var precio: Double = precio
        get() = field
        set(value) {
            require(value > 0) {"El precio debe ser mayor que 0."}
            field = value
        }

    var tiempoPreparacion: Int = tiempoPreparacion
        get() = field
        set(value) {
            require(value > 1) {"El tiempo de preparación debe ser mayor que 1."}
            field = value
        }


    fun agregarIngrediente(ingrediente: String): Pair<String, MutableList<String>>? {
        if (ingrediente.isNotEmpty()) {
            ingredientes.add(ingrediente)
            return ingrediente to ingredientes
        } else {
            return null
        }
    }

        override fun toString(): String {
        return "Nombre del plato: ${nombre}, precio: ${precio}, ingredentes: ${ingredientes}, tiempo estimado de preparación, ${tiempoPreparacion}."
    }
}

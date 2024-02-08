class Pedido {
    companion object {
        var contPedidos = 0
    }

    val numero: Int = ++contPedidos
    val platos: MutableList<Plato> = mutableListOf()
    var estado: String = "pendiente"

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String) {
        platos.removeAll { it.nombre == nombrePlato }
    }

    fun calcularPrecio(): Double {
        return platos.sumByDouble { it.precio }
    }

    fun calcularTiempo(): Int {
        return platos.sumBy { it.tiempoPreparacion }
    }

    override fun toString(): String {
        return platos.joinToString("\n") { it.toString() }
    }
}

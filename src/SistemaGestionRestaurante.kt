class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val mesa = mesas.find { it.numero == numeroMesa }
        requireNotNull(mesa) { "La mesa no existe." }
        require(mesa.estado == "ocupada") { "La mesa no está ocupada." }
        mesa.agregarPedido(pedido)
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        val mesa = mesas.find { it.numero == numeroMesa }
        requireNotNull(mesa) { "La mesa no existe." }
        val pedido = if (numeroPedido == null) mesa.pedidos.lastOrNull() else mesa.pedidos.find { it.numero == numeroPedido }
        requireNotNull(pedido) { "El pedido no existe." }
        pedido.estado = "servido"
    }

    fun cerrarMesa(numeroMesa: Int) {
        val mesa = mesas.find { it.numero == numeroMesa }
        requireNotNull(mesa) { "La mesa no existe." }
        if (mesa.pedidos.all { it.estado == "servido" }) {
            mesa.liberarMesa()
        }
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}
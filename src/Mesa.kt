class Mesa(
    val numero: Int,
    var capacidad: Int
) {
    var estado: String = "libre"
    val pedidos: MutableList<Pedido> = mutableListOf()

    init {
        require(capacidad in 1..6) { "La capacidad de la mesa debe estar entre 1 y 6." }
    }

    fun ocuparMesa() {
        require(estado == "libre") { "La mesa no está libre." }
        estado = "ocupada"
    }

    fun ocuparReserva() {
        require(estado == "reservada") { "La mesa no está reservada." }
        estado = "ocupada"
    }

    fun liberarMesa() {
        estado = "libre"
    }

    fun agregarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }
    override fun toString(): String {
        return "Mesa $numero - Estado: $estado - Capacidad: $capacidad"
    }
}

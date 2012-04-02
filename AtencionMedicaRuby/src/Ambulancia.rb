#
# Ambulancia que posee un equipo medico
#
class Ambulancia < Prestador
  def initialize(medicos) 
    @medicos = medicos
    @pedidos_asignados = []
  end

  def sos_apto_para_atender(pedido) 
    @medicos.any? do |it| it.podes_atender(pedido) end
  end

  def tiene_disponibilidad_para(pedido) 
    @pedidos_asignados.empty || misma_zona(pedido)
  end

  def asignar_pedido(pedido) 
    @pedidos_asignados.add(pedido)
  end

  def finalizar_pedido(pedido) 
    @pedidos_asignados.remove(pedido)

  end

  def misma_zona(pedido_nuevo) 
    ultimo_pedido.direccion.esCercaDe(pedido_nuevo.direccion)
  end

  def ultimo_pedido 
    @pedidos_asignados[pedidosAsignados.size - 1]
  end

end

class Medico < Prestador
  def initialize(especialidad, pager)
    @especialidad = especialidad
    @pager = pager
  end

  def sos_apto_para_atender(pedido)
    pedido.especialidad == especialidad
  end

  def tiene_disponibilidad_para(pedido)
    @pedido_asignado == nil
  end

  def asignar_pedido(pedido)
    @pedido_asignado = pedido
    begin
      pager.notificar(pedido)
    rescue NoSePuedeNotificarException => e
      @pedido_asignado = nil
      throw e
    end
  end

  def finalizar_pedido(pedido)
    @pedido_asignado = nil
  end
end

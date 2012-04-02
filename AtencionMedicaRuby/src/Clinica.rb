class Clinica

  attr_reader :mapa
  def initialize(mapa, prestadores)
    @mapa = mapa
    @prestadores = prestadores
  end

  def ingresar_pedido(pedido)
    prestadores_para(pedido).each do
      begin
        prestador.asignar_pedido(pedido)
        return prestador
      rescue NoSePuedeNotificarException
        #nada, pasamos al proximo
      end
      throw NoHayPrestadorDisponibleException.new
    end
  end

  def prestadores_para(un_pedido)
    @prestadores.select do |it| it.podes_atender(un_pedido) end
  end

  def self.get_instance
    @clinica
  end

  def self.inicializar(mapa, prestadores)
    @clinica = Clinica.new(mapa, prestadores)
  end
end

class NoHayPrestadorDisponibleException < Exception
end

class NoSePuedeNotificarException < Exception
end

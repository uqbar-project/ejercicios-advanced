class Pedido
  attr_reader :especialidad
  attr_reader :direccion
  
  def initialize(especialidad, direccion)
    @especialidad = especialidad
    @direccion = direccion
  end
end

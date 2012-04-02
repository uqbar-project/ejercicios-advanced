#  Author:: flbulgarelli
class Direccion

  attr_accessor :calle
  attr_accessor  :numero
  def initialize(calle,numero)
    @calle = calle
    @numero = numero
  end

  def esCercaDe(otraDireccion)
    Clinica.get_instance.mapa.sonCercanas(self, otraDireccion)
  end
end

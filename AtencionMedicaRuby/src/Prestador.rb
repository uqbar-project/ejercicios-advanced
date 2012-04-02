# 
# Prestador es cualquier elemento del 
# sistema que puede ser asignado apra
# atender un pedido.
#
class Prestador
   
#TODO protected
  
  def podes_atender(pedido) 
    sos_apto_para_atender(pedido) && tiene_disponibilidad_para(pedido)
  end

end

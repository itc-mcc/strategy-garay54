package miTiendita.descuento;

import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class FrutaDescuento implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        float desc=0;
        for (LineaDeDetalle producto : v.getLd()){
            if(producto.getP().getClave()==6 || producto.getP().getClave()==7 ){
                desc+=(producto.getP().getPunit()* producto.getCtd()*0.15);
            }
        }
        return desc;
    }
}
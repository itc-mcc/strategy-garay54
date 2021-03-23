package miTiendita.descuento;

import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class MenonitaDescuento implements IDesctoStrategy {

    @Override
    public float getDescto(Venta v) {
        float desc=0;
        for (LineaDeDetalle producto : v.getLd()){
            if(producto.getP().getClave()==1 || producto.getP().getClave()==2 || producto.getP().getClave()==3 || producto.getP().getClave()==5 ){
                desc+=(producto.getP().getPunit()* producto.getCtd()*0.1);
            }
        }
        return desc;
    }
}
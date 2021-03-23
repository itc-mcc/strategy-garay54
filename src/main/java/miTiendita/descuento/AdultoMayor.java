package miTiendita.descuento;

import miTiendita.venta.LineaDeDetalle;
import miTiendita.venta.Venta;

public class AdultoMayor implements IDesctoStrategy {
    @Override
    public float getDescto(Venta v) {
        // TODO Auto-generated method stub
        float desc=0;
        for (LineaDeDetalle producto : v.getLd()){
            desc+=(producto.getP().getPunit()* producto.getCtd()*0.05);
        }
        //desc=desc*0.05;
        System.out.println("El descuento es de: " + desc);
        return desc;
    }
}
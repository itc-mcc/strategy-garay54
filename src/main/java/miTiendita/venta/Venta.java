package miTiendita.venta;

import miTiendita.descuento.*;
import miTiendita.productos.Producto;
import java.util.*;

public class Venta {
    int diaSemana;
    boolean terceraEdad;
    List<LineaDeDetalle> ld = new ArrayList<LineaDeDetalle>();
    IDesctoStrategy IDescto;

    public List<LineaDeDetalle> getLd() {
        return ld;
    }

    public Venta(int diaSemana, boolean terceraEdad)
    {
        this.diaSemana = diaSemana;
        this.terceraEdad = terceraEdad;

        addDescto();
    }

    public void addProducto(Producto p, double ctd)
    {
        ld.add(new LineaDeDetalle(p,ctd));
    }

    public void addDescto()
    {
        switch (diaSemana){
            //Lunes
            case 1:
                IDescto = new AdultoMayor();
                break;
            case 2:
                IDescto = new SinDescuento();
                break;
            case 3:
                IDescto = new MenonitaDescuento();
                break;
            case 4:
                IDescto = new FrutaDescuento();
                break;
            case 5:
                IDescto = new EmbutidosLacteos();
                break;
            case 6:
                IDescto = new SinDescuento();
                break;
            //domingo
            case 7:
                IDescto = new AdultoMayor();
                break;
        }

    }

    public double getTotal()
    {
        float sumaP=0;
        for (LineaDeDetalle producto : ld){
            sumaP+=(producto.p.getPunit() * producto.ctd);
        }
        double totalVenta=((sumaP)-(IDescto.getDescto(this)))*1.16;
        System.out.println("TOTAL= "+totalVenta);

        return totalVenta;
    }
}
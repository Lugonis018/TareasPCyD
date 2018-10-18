/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteWS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AUTONOMA
 */
@WebService(serviceName = "ServiciosWeb")
@Stateless()
public class ServiciosWeb {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularBasePerimAreaRectangulo")
    public String CalcularBasePerimAreaRectangulo(@WebParam(name = "diagonal") double diagonal, 
            @WebParam(name = "altura") double altura, @WebParam(name = "medida") String medida) {
        //TODO write your implementation code here:
        double base=Math.sqrt((Math.pow(diagonal,2))-(Math.pow(altura, 2)));
        double perimetro=2*base+2*altura;
        double area= base*altura;
        String resultado="La BASE es: "+base+" "+medida+
                " su PERIMETRO es: "+perimetro+" "+medida
                +" y su AREA es: "+area+" "+ medida+"^2";
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularPerimAreaTriangulo")
    public String CalcularPerimAreaTriangulo(@WebParam(name = "base") double base, 
            @WebParam(name = "altura") double altura, @WebParam(name = "medida") String medida) {
        //TODO write your implementation code here:
        
        String resultado="";
        double lado=Math.sqrt((Math.pow(base*0.5, 2))+(Math.pow(altura, 2)));
        double perimetro=(2*lado)+base;
        double area;
        area=base*altura*0.5;
        
        resultado="El PERIMETRO DEL TRIANGULO ES: "+perimetro+" "+medida+
                " y su AREA es: "+area+" "+medida+"^2";
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalculaLadoPerimCuadrado")
    public String CalculaLadoPerimCuadrado(@WebParam(name = "area") double area, 
            @WebParam(name = "medida") String medida) {
        //TODO write your implementation code here:
        double lado=Math.sqrt(area);
        double perimetro=lado*4;
        String resultado="El LADO del cuadrado es : "+lado+" "+medida+
                " y su PERIMETRO es: "+perimetro+" "+medida;
        return resultado;
    }
}

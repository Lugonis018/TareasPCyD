/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesWeb;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AUTONOMA
 */
@WebService(serviceName = "ServiceWeb")
@Stateless()
public class ServiceWeb {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularSuma")
    public String CalcularSuma(@WebParam(name = "n1") double n1, @WebParam(name = "n2") double n2) {
        //TODO write your implementation code here:
        String resolve;
        double sum=0;
        sum=n1+n2;
        resolve="El resultado es "+sum;
       
        
        return resolve;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularResta")
    public String CalcularResta(@WebParam(name = "m1") double m1, @WebParam(name = "m2") double m2) {
        //TODO write your implementation code here:
        String resolve;
        double sub=0;
        sub=m1-m2;
        resolve="El resultado es "+sub;
       
        
        return resolve;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularMultiplicacion")
    public String CalcularMultiplicación(@WebParam(name = "q1") double q1, @WebParam(name = "q2") double q2) {
        //TODO write your implementation code here:
        String resolve;
        double multi=0;
        multi=(double)q1*q2;
        resolve="El resultado es "+multi;
       
        
        return resolve;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CalcularDivision")
    public String CalcularDivisión(@WebParam(name = "h1") double h1, @WebParam(name = "h2") double h2) {
        //TODO write your implementation code here:
        String resolve;
        double multi=0;
        multi=h1/h2;
        resolve="El resultado es "+multi;
       
        
        return resolve;
    }

}

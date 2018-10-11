/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AUTONOMA
 */
@WebService(serviceName = "CasaCambioWS")
@Stateless()
public class CasaCambioWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ChangeDolarToSoles")
    public String ChangeDolarToSoles(@WebParam(name = "rode") double rode) {
        //TODO write your implementation code here:
        String resolve;
        double change=0;
        change=rode*3.32;
        resolve="El cambio en Soles es: "+change;
        return resolve;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ChangeSolesToDolares")
    public String ChangeSolesToDolares(@WebParam(name = "rode") double rode) {
        //TODO write your implementation code here:
        String resolve;
        double change=0;
        change=rode*0.3;
        resolve="El cambio en Dolares es: "+change;
        return resolve;
    }
}

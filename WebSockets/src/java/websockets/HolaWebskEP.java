/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websockets;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author AUTONOMA
 */
@ServerEndpoint("/endpoint")
public class HolaWebskEP {
    
    static final Logger LOGGER= Logger.getLogger(HolaWebskEP.class.getName());
    @OnOpen
    public void IniciaConexion(){
        LOGGER.info("Iniciando conexión");
        
    }
    @OnClose
    public void finConexion(){
        LOGGER.info("Terminando conexion");
    }
    @OnMessage
    public String onMessage(String mensaje) {
        LOGGER.log(Level.INFO,"Recibinedo mensaje:{0}",mensaje);
        return "Hola a todos con este mensaje"+mensaje;
    }
    
}

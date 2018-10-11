/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author AUTONOMA
 */
@ServerEndpoint("/holaWebsk")
public class HolaWebskEP {
    
    static final Logger LOGGER= Logger.getLogger(HolaWebskEP.class.getName());
    private static final List<Session> conectados=new ArrayList<>();
    @OnOpen
    public void IniciaConexion(Session sesion){
        LOGGER.info("Iniciando conexión");
        conectados.add(sesion);
    }
    @OnClose
    public void finConexion(Session sesion){
        LOGGER.info("Terminando conexion");
        conectados.remove(sesion);
    }
    @OnMessage
    public void onMessage(String mensaje) throws IOException, EncodeException {
        LOGGER.log(Level.INFO,"Recibiendo mensaje:{0}",mensaje);
        for (Session sesion:conectados){
            sesion.getBasicRemote().sendText(mensaje);
        }
        
    }
    
}

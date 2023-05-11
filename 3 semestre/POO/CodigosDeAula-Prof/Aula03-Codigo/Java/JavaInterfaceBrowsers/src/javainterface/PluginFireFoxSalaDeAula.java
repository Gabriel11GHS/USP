/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainterface;

/**
 *
 * @author Rodrigues
 */
public class PluginFireFoxSalaDeAula implements FireFoxPlugin{

    public String verifyUser() {
        return "Estamos em sala de aula";
    }

    public int getOS() {
        return 42;
    }

    public void prepareAndEnterGraphMode(FireFoxBrowser aFireFoxBrowser) {
        aFireFoxBrowser.setGraphicalStatus(false);
    }
    
}

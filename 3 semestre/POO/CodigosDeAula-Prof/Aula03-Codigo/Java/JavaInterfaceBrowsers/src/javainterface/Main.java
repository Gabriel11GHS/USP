/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javainterface;

/**
 *
 * @author Junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FireFoxBrowser fUmBroser = new FireFoxBrowser();
        UmFireFoxPlugin fp = new UmFireFoxPlugin();
        fUmBroser.executePlugin(fp);
        System.out.println("");
        
        PluginFireFoxSalaDeAula aulaPlugin = new PluginFireFoxSalaDeAula();
        fUmBroser.executePlugin(aulaPlugin);
       
        
        
        /*fUmBroser.executePlugin(new GenericPlugin());
        System.out.println("");
        
        ChromeBrowser cUmBroser = new ChromeBrowser();
        cUmBroser.executePlugin(new UmChromePlugin());
        System.out.println("");
        cUmBroser.executePlugin(new GenericPlugin());
        System.out.println("");*/

    }

}

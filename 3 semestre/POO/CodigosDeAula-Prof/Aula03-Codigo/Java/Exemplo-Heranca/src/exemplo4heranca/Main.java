/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo4heranca;

/**
 *
 * @author Junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal a1 = new Animal("Cachorro");     
        System.out.println(a1.getsNome());
        
        Terrestres t1 = new Terrestres("Macaco", 4);
        System.out.println(t1.getsNome());
        
        Aquaticos aq1 = new Aquaticos("Dourado",3);
        System.out.println(aq1.getsNome());

        System.out.println("-----------------------");
        Animal[] animais = new Animal[3];
        animais[0] = a1;
        animais[1] = t1;
        animais[2] = aq1;
        for(int i = 0; i < 3; i++)
            System.out.println(animais[i].getsNome());
        
        /*dynamic biding*/
        
        //animais[2].getMinsDeFolego();
        
        /*
        
        Animal a3 = new Terrestres("Cavalo",4);
        System.out.println(a3.getsNome());
               
        Terrestres t2 = (Terrestres)a3;  
        System.out.println(t2.getiNrPatas());
        
        Aquaticos aq1 = new Aquaticos("Dourado",3);
        System.out.println("Folego do " + aq1.getsNome() + " é de " + aq1.getMinsDeFolego() + " minutos");
        
        Cachorro c1 = new Cachorro("Lesse",4,"Labrador");
        System.out.println(c1.getsRaca());

        */
        
        
        /*Animal meuAnimal = new Animal("Michelangelo");
        Terrestres umTerrestre = new Terrestres("Donatelo",4);
       
        
        
        
        
        
        
        Cachorro umCao = new Cachorro("Dog",4);
        System.out.println(umCao.getsNome() + " - " + umCao.getiNrPatas());

        Lambari umPeixe = new Lambari("Nemo",10);
        System.out.println(umPeixe.getsNome() + " - " + umPeixe.getMinsDeFolego());
       */
    }

}

package libreria;

import limpiarPantalla.LimpiarAnt;

/**
 *
 * @author Ezequiel
 */
public class MainLibreria {

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("LIBRERIA VIRTUAL\n");
            Menu.menuGeneral();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + "\n");
            e.getStackTrace();
            LimpiarAnt.presionar();
            Menu.menuGeneral();
        }

    }

}

package libreria;

import libreria.servicios.LimpiarPantalla;

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
            LimpiarPantalla.limpiarAnt();
            Menu.menuGeneral();
        }

    }

}

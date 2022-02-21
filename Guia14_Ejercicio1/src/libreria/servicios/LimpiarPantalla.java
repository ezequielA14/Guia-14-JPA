package libreria.servicios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;

/**
 *
 * @author Ezequiel
 */
public class LimpiarPantalla {
    
    public static void limpiarAnt() throws InterruptedException {

        try {
            System.out.println("\n Presione Enter para continuar");
            new java.util.Scanner(System.in).nextLine();

            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);
            sleep(100);
        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }

    }
    
    public static void limpiarAntInstantaneo() throws InterruptedException {

        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);
            sleep(100);
        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }

    }
    
}

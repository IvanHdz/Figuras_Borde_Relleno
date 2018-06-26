/**
 *
 * @author Jesus Ivan
 */
import java.awt.Color;
import java.awt.Graphics;

public interface Dibujable {
    public abstract void dibujar(Graphics g);
    public abstract void dibujar(Graphics g, Color cFondo);
}
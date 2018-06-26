/**
 *
 * @author Jesus Ivan
 */
import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Figura{
    public Rectangulo(int x1, int y1, int largo, int ancho, Color cBorde, Color cFondo){
        super(x1, y1, largo, ancho, cBorde, cFondo);
    }
    
    public void dibujar(Graphics g){
        g.setColor(getCBorde());
        g.drawRect(getX1(), getY1(), getLargo(), getAncho());
    }
    
    public void dibujar(Graphics g, Color cFondo){
        g.setColor(cFondo);
        g.fillRect(getX1(), getY1(), getLargo(), getAncho());
        
        g.setColor(getCBorde());
        g.drawRect(getX1(), getY1(), getLargo(), getAncho());
    }
}
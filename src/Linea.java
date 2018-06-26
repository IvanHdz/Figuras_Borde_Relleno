/**
 *
 * @author Jesus Ivan
 */
import java.awt.Color;
import java.awt.Graphics;

public class Linea implements Dibujable{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color cBorde;
    
    public Linea(int x1, int y1, int x2, int y2, Color cBorde){
        cambiarPosicion(x1, y1);
        cambiarTamaño(x2, y2);
        cambiarColor(cBorde);
    }
    
    private void cambiarPosicion(int x1, int y1){
        this.setX1(x1);
        this.setY1(y1);
    }
    
    private void cambiarTamaño(int x2, int y2){
        this.setX2(x2);
        this.setY2(y2);
    }
    
    private void cambiarColor(Color cBorde){
        this.setCBorde(cBorde);
    }
    
    public void dibujar(Graphics g){
        g.setColor(getCBorde());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    public void dibujar(Graphics g, Color cFondo){        
    }
    
    //******************* MÉTODOS set Y get
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getCBorde() {
        return cBorde;
    }

    public void setCBorde(Color cBorde) {
        this.cBorde = cBorde;
    }
}
/**
 *
 * @author Jesus Ivan
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private int x1;
    private int y1;
    private int ancho;
    private int largo;
    private int relleno;
    private int figuraDibujar;
    private int colorActual;
    private Color cBorde;
    private Color cFondo;
    private Dibujable figura;
    
        public Panel(){
        x1 = 0;
        y1 = 0;
        largo = 1;
        ancho = 1;
        relleno = 0;
        figuraDibujar = 0;
    }
    @Override
       public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color[] colores = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN};
        g.setColor(cBorde);
        
        switch(figuraDibujar){
            case 0: figura = new Circulo(x1, y1, largo, cBorde, cFondo);
                    break;
            case 1: figura = new Ovalo(x1, y1, largo, ancho, cBorde, cFondo);
                    break;
            case 2: figura = new Rectangulo(x1, y1, largo, ancho, cBorde, cFondo);
                    break;
            case 3: figura = new Linea(x1, y1, largo, ancho, cBorde);
                    break;
        }
        
        
        if(relleno == 0)
            figura.dibujar(g);
        else
            figura.dibujar(g, cFondo);
    }
       
      public void dibujar(int colorActual){
        this.colorActual = colorActual;
        repaint();
    }

      public void dibujar(){
        repaint();
    }
    // MÉTODOS set Y get
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

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getRelleno() {
        return relleno;
    }

    public void setRelleno(int relleno) {
        this.relleno = relleno;
    }

    public Color getCBorde() {
        return cBorde;
    }

    public void setCBorde(Color cBorde) {
        this.cBorde = cBorde;
    }

    public Color getCFondo() {
        return cFondo;
    }

    public void setCFondo(Color cFondo) {
        this.cFondo = cFondo;
    }

    public int getFiguraDibujar() {
        return figuraDibujar;
    }

    public void setFiguraDibujar(int figuraDibujar) {
        this.figuraDibujar = figuraDibujar;
    }
}
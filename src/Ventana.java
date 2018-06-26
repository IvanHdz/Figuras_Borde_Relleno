/**
 *
 * @author Jesus Ivan
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame{
    private Container contenedor;
    private JButton bLimpiar;
    private Panel miPanel;
    private JPanel pPrincipal;
    private JPanel pFigura;
    private JPanel pBorde;
    private JPanel pRelleno;
    private JRadioButton rCirculo;
    private JRadioButton rOvalo;
    private JRadioButton rRectangulo;
    private JRadioButton rLinea;
    private JComboBox cColorB;
    private JComboBox cColorF;
    private JCheckBox relleno;
    
    public Ventana(){
        super("Viruz Blog: Figuras con Borde y Relleno");
        contenedor = getContentPane();
        setSize(700, 600);
        setBackground(Color.YELLOW);
        addComponentes();
        addEventosRaton();
        addEventos();
        setVisible(true);
    }
        
    private void addComponentes(){
            miPanel = new Panel();
            pPrincipal = new JPanel();
            pFigura = new JPanel();
            pBorde = new JPanel();
            pRelleno = new JPanel();
            bLimpiar = new JButton(": : Limpiar Área de Dibujo : :");
            
            //Llama alos Metodos de los paneles creados.
             crearPanelFigura();
             crearPanelBorde();
             crearPanelRelleno();
        
        miPanel.setBackground(Color.WHITE);
        pPrincipal.setLayout(new GridLayout(1,3));
        
        //adición paneles a panel principal
        pPrincipal.add(pFigura);
        pPrincipal.add(pBorde);
        pPrincipal.add(pRelleno);
        
         //adición de componentes a la ventana o contenedor.
        contenedor.add(pPrincipal, BorderLayout.NORTH);
        contenedor.add(miPanel, BorderLayout.CENTER);
        contenedor.add(bLimpiar, BorderLayout.SOUTH);
        }
        
    public void crearPanelFigura(){
        ButtonGroup grupoRadio = new ButtonGroup();
        
        //creación de botones de radio
        rCirculo = new JRadioButton("Círculo", true);
        rOvalo = new JRadioButton("Óvalo");
        rRectangulo = new JRadioButton("Rectángulo");
        rLinea = new JRadioButton("Línea");
        
        //asignación de oyentes
        rCirculo.addItemListener(new ManejadorRadioBoton(0));
        rOvalo.addItemListener(new ManejadorRadioBoton(1));
        rRectangulo.addItemListener(new ManejadorRadioBoton(2));
        rLinea.addItemListener(new ManejadorRadioBoton(3));
        
        //adición a grupo de botones
        grupoRadio.add(rCirculo);
        grupoRadio.add(rOvalo);
        grupoRadio.add(rRectangulo);
        grupoRadio.add(rLinea);
        
        //borde con título
        pFigura.setBorder(new TitledBorder(": : Figura"));
        pFigura.setLayout(new GridLayout(4,1));
        
        //adición de componentes
        pFigura.add(rCirculo);
        pFigura.add(rOvalo);
        pFigura.add(rRectangulo);
        pFigura.add(rLinea);
    }
       
   public void crearPanelBorde(){
        String[] nombreColor = {"NEGRO","AZUL","CYAN","VERDE"};
        cColorB = new JComboBox(nombreColor);
        
        //MaximumRowCount hace ver el numero de opciones que aparescan primero
        cColorB.setMaximumRowCount(3);
        cColorB.addItemListener(new ManejadorSeleccion());
        
        pBorde.setBorder(new TitledBorder(": : Color de Borde"));
        pBorde.add(cColorB);
    }
      
       public void crearPanelRelleno(){
        relleno = new JCheckBox("Relleno");
        String[] nombreColor = {"NEGRO","AZUL","CYAN","VERDE"};
        cColorF = new JComboBox(nombreColor);
        
        cColorF.setMaximumRowCount(3);
        cColorF.setEnabled(false);
         
        //adición de oyente
        relleno.addItemListener(new ManejadorSeleccion());
        cColorF.addItemListener(new ManejadorSeleccion());
        
        pRelleno.setBorder(new TitledBorder(": : Color de Fondo"));
        pRelleno.add(relleno);
        pRelleno.add(cColorF);
    }
       
           
    //Eventos de ItemListener de JRadioButton
    class ManejadorRadioBoton implements ItemListener{
        private int opc;
        
        public ManejadorRadioBoton(int x){
            opc = x;
        }
        
        public void itemStateChanged(ItemEvent evento){
            miPanel.setFiguraDibujar(opc);
            
            if(opc == 3){
                relleno.setEnabled(false);
                cColorF.setEnabled(false);
                miPanel.setRelleno(0);
            }else{
                relleno.setEnabled(true);
                cColorF.setEnabled(true);
                if(relleno.isSelected())
                    miPanel.setRelleno(1);
                else
                    miPanel.setRelleno(0);
            }
        }
    }
       
    private void addEventos(){
           //oyente anónimo del botón
        bLimpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                repaint();
            }
        });
      }
    
   //Eventos ItemListener de JComboBox
    class ManejadorSeleccion implements ItemListener{
        Color[] colores = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN};
        
        public void itemStateChanged(ItemEvent evento){
            if(relleno.isSelected()){
                cColorF.setEnabled(true);
                miPanel.setCFondo(colores[cColorF.getSelectedIndex()]);
                miPanel.setRelleno(1);
            }else{
                cColorF.setEnabled(false);
                miPanel.setRelleno(0);
            }
            
            miPanel.setCBorde(colores[cColorB.getSelectedIndex()]);
        }
    }
    
       //Eventos de RATON.
       private void addEventosRaton(){ 
        addMouseListener(new MouseAdapter(){
            @Override
             public void mousePressed(MouseEvent evento){
            miPanel.setX1(evento.getX() - 9);
            miPanel.setY1(evento.getY() - 150);
            
            if(miPanel.getFiguraDibujar() == 3){
                miPanel.setLargo(miPanel.getX1());
                miPanel.setAncho(miPanel.getY1());
            }else{
                miPanel.setLargo(0);
                miPanel.setAncho(0);
            }
            
            miPanel.dibujar();
        }
         });
         
         addMouseMotionListener(new MouseMotionAdapter(){
            @Override
        public void mouseDragged(MouseEvent  evento){
            if(miPanel.getFiguraDibujar() == 3){
                miPanel.setLargo(evento.getX() - 9);
                miPanel.setAncho(evento.getY() - 150);
            }else{
                miPanel.setLargo(evento.getX() - miPanel.getX1() - 9);
                miPanel.setAncho(evento.getY() - miPanel.getY1() - 150);
            }
            
            miPanel.dibujar();
          }
         });
     }
}
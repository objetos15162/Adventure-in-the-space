import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase ayuda, encargada de mostrar una imagen con las instrucciones
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Ayuda extends World
{
    private Boton regresar;
    /**
     * Constructor clase Menu.
     * 
     */
    public Ayuda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 600, 1);//-560-600-750,550
        setBackground("ayuda1.jpg");
        muestraBoton();
    }
    
    /**
     * Método que siempre se esta ejecutando
     * Esta encargada de esperar el momento de reedirigir al menu
     */
    public void act()
    {
        dirigePagina();
    }
    
    /**
     * Método encargado de mostrar botón regresar 
     */
    public void muestraBoton()
    {
        regresar = new Boton(3);
        addObject(regresar,630,550);
    }
    
    /**
     * Método que espera a que se oprima el botón, redirige hacia el menu
     */
    public void dirigePagina()
    {
        if(Greenfoot.getMouseInfo()!=null)
        {
            if(Greenfoot.mousePressed(regresar))
            {
                Greenfoot.setWorld(new Menu());
            }
        }
    }
}

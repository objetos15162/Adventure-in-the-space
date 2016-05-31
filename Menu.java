import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase menu, encargada de mostrar los botones hacia nivel 1 y ayuda
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Menu extends World
{
    private Boton inicio;
    private Boton ayuda;
    /**
     * Constructor clase Menu.
     * 
     */
    public Menu()
    { 
        super(750, 600, 1);
        setBackground("menu.jpg");
        muestraBotones();
    }
    
    /**
     * Método que siempre se esta ejecutando
     * Esta encargada de esperar el momento de reedirigir a la ayuda o nivel 1
     */
    public void act()
    {
        dirigePagina();
    }
    
    /**
     * Método encargado de mostrar los botones jugar y ayuda 
     */
    public void muestraBotones()
    {
        inicio = new Boton(1);
        addObject(inicio,120,100);
        ayuda = new Boton(2);
        addObject(ayuda,120,180);
    }
    
    /**
     * Método que espera a que se oprima algun botón, redirige hacia el nuvel1 o ayuda
     */
    public void dirigePagina()
    {
        if(Greenfoot.getMouseInfo()!=null)
        {
            if(Greenfoot.mousePressed(inicio))
            {
                Greenfoot.setWorld(new Nivel1());
            }
            if(Greenfoot.mousePressed(ayuda))
            {
                Greenfoot.setWorld(new Ayuda());
            }
        }
    }
}


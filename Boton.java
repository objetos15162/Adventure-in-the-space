import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Boton, permite crear los botones que nos permitiran cambiar de escenario
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Boton extends Actor
{
    private int n;
    /**
     * Constructor Boton
     */
    public Boton(int n)
    {
        this.n=n;
    }
    
    /**
     * Metodo que muestra los botones definidos, a traves del metodo muestra
     */
    public void act() 
    {
        // Add your action code here.
        muestra(n);
    }
    
    /**
     * Método que crea botones ya definidos dependiendo del parámetro que llega
     */
    public void muestra(int n)
    {
        if(n==1)
            setImage("images/jugar.png");
        else
            if(n==2)
                setImage("images/ayuda.png");
            else
                setImage("images/regresar.png");
    }
}

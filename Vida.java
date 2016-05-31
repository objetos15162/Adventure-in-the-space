import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Items
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Vida extends Items
{
    /**
     * Constructor clase Vida
     */
     public Vida(int y, int n)
    {
        super(y, n);
    }
    
    /**
     *Metodo que siempre se ejecuta, manda llamar el metodo toca del padre
     */
    public void act() 
    {
        // Add your action code here.
        super.toca(y, n);
    }    
}
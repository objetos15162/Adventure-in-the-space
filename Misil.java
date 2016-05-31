import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Clase Misil usada por el heroe
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Misil extends Disparo
{
    /**
     * Constructor Misil
     */
    public Misil(int a, int b, int speed, char c, int d, int nivel)
    {
        super(a,b,speed,'c',d, nivel);
    }
    
    /**
     * Método que ejecuta constantemente los métodos de mueve y checaOrilla del padre
     */
    public void act() 
    {
        // Add your action code here.
        aaa(a, b, speed, 'm',d, nivel);
        super.checaOrilla();
    }    
}

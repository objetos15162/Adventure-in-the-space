import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Bala usada por el heroe
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Bala extends Disparo
{
    /**
     * Constructor Bala
     */
    public Bala(int a, int b, int speed, char c, int d, int nivel)
    {
        super(a,b,speed,'c', d, nivel);
    }
    
    /**
     * Método que ejecuta constantemente los métodos de mueve y checaOrilla del padre
     */
    public void act() 
    {
        aaa(a, b, speed, 'd', d, nivel);
        super.checaOrilla();
    }    
}

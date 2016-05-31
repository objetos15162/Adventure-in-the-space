import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase BalaFlota usada por los alien y flota
 * 
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class BalaFlota extends Disparo
{
    private Nivel1 mundo;
    private Nivel2 mundo2;
    private Nivel3 mundo3;
    private boolean isFlota=false;
    public int x;
    /**
     * Constructor BalaFlota
     */
    public BalaFlota(int a, int b, int speed, char c, int d, int nivel)
    {
        super(a,b,speed,'c', d, nivel);
    }
    
    /**
     * Método que remueve este objeto si se toco a la clase heroe 
     */
    public void act() 
    {
        aaa(a, b, speed, 'f',d,nivel);
        Actor Heroe = getOneObjectAtOffset(0,0,Heroe.class);
        if(nivel==0)//era 1
        {
            if(Heroe!= null)
            {
                Nivel1 mundo = (Nivel1)getWorld();
                getWorld().removeObject(this);
                Greenfoot.playSound("explosion.wav");
            }
            else
            {
                if(getY() >= getWorld().getHeight()-5 || getY() <= 5)
                {
                    getWorld().removeObject(this);
                }
            }
        }
        
        if(nivel==1)//era 2
        {
            if(Heroe!= null)
            {
                Nivel2 mundo2 = (Nivel2)getWorld();
                getWorld().removeObject(this);
                mundo2.vidasN2.decrementa(0);
                Greenfoot.playSound("explosion.wav");
            }
            else
            {
                if(getY() >= getWorld().getHeight()-5 || getY() <= 5)
                {
                    getWorld().removeObject(this);
                }
            }
        }
    }
}

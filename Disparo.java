import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase disparo, contiene los métodos cumunes de las subclases,
 * el movimiento y checaOrilla todas las clases hijas los usan 
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Disparo extends Actor
{
    int shotImage=1;
    int a, b, speed, d, nivel;
    char c;
    private Nivel1 mundo;
    private Nivel2 mundo2;
    private Nivel3 mundo3;
    
    
    /**
     * Constructor disparo, rtecibe los parametros necesarios
     * para actuar de manera específica dependiendo de la subclase que la llame
     */
    public Disparo(int a, int b, int speed, char c, int d, int nivel)
    {
        this.a=a;
        this.b=b;
        this.speed=speed;
        this.c='c';
        this.d=d;
        this.nivel=nivel;
    }
    
    /**
     * Método que siempre ejecuta el movimiento cuando sea llamado 
     */
    public void act() 
    {
        // Add your action code here.
        aaa(a,  b, speed, 'c',d,nivel);
        //checaOrilla();
    }   
    
    /**
     * Metodo que contiene las instrucciones como debe actuar la clase disparo
     */
    public void aaa(int a, int b, int speed, char c, int d, int nivel)
    {
            
            setImage("images/"+c+shotImage+".png");//propios del objeto
            if(d==0)
                setLocation(getX(),getY()+speed);
            else
                setLocation(getX(),getY()-speed);
                
                if(shotImage<a)
                shotImage++;
                else
                shotImage=b;
             
    }
     
    /**
     * Método que elimina esta clase si es que se llego al extremo
     */
       public void checaOrilla()
    {
        if(nivel==0)
        {
            mundo = (Nivel1)getWorld();        
            if(this.isAtEdge())
            {
                mundo.removeObject(this);
            }
        }
        
        if(nivel==1)
        {
            mundo2 = (Nivel2)getWorld();        
            if(this.isAtEdge())
            {
                mundo2.removeObject(this);
            }
        }
        
        if(nivel==2)
        {
            mundo3 = (Nivel3)getWorld();        
            if(this.isAtEdge())
            {
                mundo3.removeObject(this);
            }
        }
    }
   
    /**
     * Método que regresa 1 si esta clase esta tocando a la clase heroe
     */
    public int tocandoHeroe()
    {
        int x=0;
        if(this.isTouching(Heroe.class))
            x=1;
        return(x);
    }
    
  
}
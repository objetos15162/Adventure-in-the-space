import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 *En esta clase se inicializan y crean los objetos que interactuaran en el nivel, en este caso solo es el jefe final
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Nivel3 extends World
{
    private Heroe usuario3 = new Heroe(3);
    private Jefe jefe = new Jefe();
    Letrero puntosN3;
    Letrero vidasN3;
    Letrero rocketN3;
    Letrero balasN3;
    /**
     * Constructor Nivel3.
     * 
     */
    public Nivel3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 600, 1); 
        construyeNivel3();
    }
    
    /**
     * Método que inicializa todos los objetos que se crearan en el nivel 
     */
    public void construyeNivel3()
    {
        addObject(usuario3,435,550);
        addObject(jefe,160,70);
        
        puntosN3=new Letrero(0,"puntaje:");
        vidasN3=new Letrero(4,"vidas:");
        rocketN3=new Letrero(50,"Rocket:");
        balasN3=new Letrero(80,"Balas:");
        
        //addObject(puntosN3,110,85);
        //addObject(vidasN3,110,115);
        addObject(rocketN3,110,145);
        addObject(balasN3,110,175);
        
        setBackground("space.png");
        //Greenfoot.playSound("Imperial.wav");
    }
    
    /**
     * Ciclo que siempre se esta ejecutando
     * En este se checa la validacion de puntos para ganar el juego
     * Mientras no se cumplan las condiciones especificadas se ejecutaran los métodos, activaObjetosN3 y enemigoAlcanzado
     */
    public void act()
    {   
        if(puntosN3.obtenerValor()<30)//VA A SER 50
        {
          activaObjetosN3();
          enemigoAlcanzado();
        }
        else
        {
            elimina_escenario();
            JuegoGanado g=new JuegoGanado();
            addObject(g,((getWidth()/2)+30),((getHeight()/2)+150));
        } 
    }
    
    /**
     * Método que reactiva a la posicion inicial al enemigo, si este llega a un borde  
     */
    public void activaObjetosN3()
    {
        if(jefe.borde()==1)
        {
            removeObject(jefe);
            addObject(jefe,160,70);
        }
    }
    
    /**
     * Método que puntua en 1, si el método alcanzado del objeto jefe es igual a 1 
     */
    public void enemigoAlcanzado()
    {
        if(jefe.alcanzado()==1)
        {
            Greenfoot.playSound("Explosion1.wav");
            puntosN3.incrementa(1);
        }
    }
    
    /**
     * Metodo que elimina todos los objetos del nivel
     */
    public void elimina_escenario()
    {
        List lista_mundo = getObjects(null);
        Iterator i = lista_mundo.iterator();
        while(i.hasNext())
        {
            Actor a = (Actor) i.next();
            if( a!= null ) 
            {
                removeObject(a);
            }
        }    
    }
    
    /**
     * Método que hace posible quitar 1 vida al usuario,
     * las vidas se almacenan gracias a la clase letrero
     */
    public void heroeAlcanzado()
    {
        usuario3.pierdeUnaVida();
    }
}

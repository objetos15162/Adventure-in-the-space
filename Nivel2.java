import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * En esta clase se inicializan y crean los objetos que interactuaran en el nivel
 * Contiene los metodos que activan los objetos en el nivel
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Nivel2 extends World
{
    private SimpleTimer timerAdd = new SimpleTimer();
    private Heroe usuario2 = new Heroe(2);
    private Items r2 = new Rocket(0,2);
    private Items m2 = new Municion(2,2);
    private Items v2 = new Vida(1,2);
    private Flota f1 = new Flota();
    private Flota f2 = new Flota();
    private Flota f3 = new Flota();
    private alien alien1 = new alien();
    private alien alien2 = new alien();
    private alien alien3 = new alien();
    private alien alien4 = new alien();
    Letrero puntosN2;
    Letrero vidasN2;
    Letrero rocketN2;
    Letrero balasN2;
    
    /**
     * Constructor Nivel2
     * 
     */
    public Nivel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 600, 1); 
        construyeNivel2();
    }
    
    /**
     * Método que inicializa todos los objetos que se crearan en el nivel 
     */
    public void construyeNivel2()
    {
        addObject(usuario2,435,550);
        
        addObject(f1,200,20);
        addObject(f2,350,20);
        addObject(f3,600,20);
        addObject(alien1,120,20);
        addObject(alien2,300,20);
        addObject(alien3,480,20);
        addObject(alien4,660,20);
        
        addObject(m2,120,0);
        addObject(r2,300,0);
        addObject(v2,500,0);
        
        setBackground("space.png");
        
        puntosN2=new Letrero(0,"puntaje:");
        vidasN2=new Letrero(30,"vidas:");
        rocketN2=new Letrero(20,"Rocket:");
        balasN2=new Letrero(70,"Balas:");
        
        addObject(puntosN2,110,85);
        addObject(vidasN2,110,115);
        addObject(rocketN2,110,145);
        addObject(balasN2,110,175);
        //Greenfoot.playSound("Imperial.wav");
        
    }
    
    /**
     * Ciclo que siempre se esta ejecutando
     * En este se checa la validacion de puntos para acceder al siguiente nivel
     * Ejecutando de igual manera el método enemigosAlcanzado
     */
    public void act()
    {   
        if(puntosN2.obtenerValor()<1)
        {
          activaObjetosN2();
          enemigosAlcanzadosN2();
        }
        else
        {
            elimina_escenario();
            Greenfoot.setWorld(new Nivel3());
        }
        
    }
    
    /**
     * Metodo que Eliminara los objetos del nivel, cuando el metodo borde del objeto sea 1
     * De igual manera, los Reactivara , para que aparezcan en un lugar aleatorio en x  
     */
    public void activaObjetosN2()
    {
        int u=0,v=0,w=0,x,y,z,a=0,b=0,c=0,d=0,e=0;
        
        if(alien1.borde()==1)
        {
            removeObject(alien1);
            addObject(alien1,120,20);
            Greenfoot.playSound("ufo.wav");
        }
        
        if(alien2.borde()==1)
        {
            removeObject(alien2);
            addObject(alien2,120,20);
            Greenfoot.playSound("ufo.wav");
        }
        
        if(alien3.borde()==1)
        {
            removeObject(alien3);
            addObject(alien3,120,20);
            Greenfoot.playSound("ufo.wav");
        }
        
        if(alien4.borde()==1)
        {
            removeObject(alien4);
            addObject(alien4,120,20);
            Greenfoot.playSound("ufo.wav");
        }
        
        if(f1.borde()==1)
        {
            removeObject(f1);
            do
            {
                u=Greenfoot.getRandomNumber(735);
            }while(u<119);
            addObject(f1,u,20);
        }
        
        if(f2.borde()==1)
        {
            removeObject(f2);
            do
            {
                v=Greenfoot.getRandomNumber(735);
            }while(v<119);
            addObject(f2,v,20);
        }
        
        if(f3.borde()==1)
        {
            removeObject(f3);
            do
            {
                w=Greenfoot.getRandomNumber(735);
            }while(w<119);
            addObject(f3,w,20);
        }
        
        if(r2.getWorld ()!= null)
         {
              if(r2.borde()==1)
                {
                   removeObject(r2);
                }
         }
         else 
         {
             if(r2.getWorld ()==null && timerAdd.millisElapsed()>90000 )
             {
                 x=Greenfoot.getRandomNumber(749);
                 if(x>119)
                    addObject(r2,x,1);
             }
         }
         
         if(m2.getWorld ()!= null)
         {
              if(m2.borde()==1)
                {
                   removeObject(m2);        
                }
         }
         else 
         {
             if(m2.getWorld ()==null && timerAdd.millisElapsed()>10000 )
             {
                 y=Greenfoot.getRandomNumber(749);
                 if(y>119)
                    addObject(m2,y,1);
             }
         }
         
         if(v2.getWorld ()!= null)
         {
              if(v2.borde()==1)
                {
                   removeObject(v2);           
                }
         }
         else 
         {
             if(v2.getWorld ()==null && timerAdd.millisElapsed()>70000 )
             {
                 z=Greenfoot.getRandomNumber(749);
                 if(z>119)
                    addObject(v2,z,1);
             }
         }
    }
    
    /**
     * Cuando el método alcanzado de los enemigos es igual a 1, se puntua con 1
     * Se remueve el objeto y reactiva en la posición inicial
     */
    public void enemigosAlcanzadosN2()
    {
        int c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0;
        
        if(alien1.alcanzado()==1)
        {
            Greenfoot.playSound("Explosion1.wav");
            removeObject(alien1);
            puntosN2.incrementa(1);
            addObject(alien1,119,20);
        }  
        
        if(alien2.alcanzado()==1)
        {
            Greenfoot.playSound("Explosion1.wav");
            removeObject(alien2);
            puntosN2.incrementa(1);
            addObject(alien2,119,20);
        }
        
        if(alien3.alcanzado()==1)
        {
            Greenfoot.playSound("Explosion1.wav");
            removeObject(alien3);
            puntosN2.incrementa(1);
            addObject(alien3,119,20);
        }  
        
        if(alien4.alcanzado()==1)
        {
            Greenfoot.playSound("Explosion1.wav");
            removeObject(alien4);
            puntosN2.incrementa(1);
            addObject(alien4,119,20);
        }  
        
        if(f1.alcanzado()==1)
        {
            removeObject(f1);
            puntosN2.incrementa(1);
            do
            {
                c=Greenfoot.getRandomNumber(735);
            }while(c<119);
            addObject(f1,c,20);
        } 
        
        if(f2.alcanzado()==1)
        {
            removeObject(f2);
            puntosN2.incrementa(1);
            do
            {
                d=Greenfoot.getRandomNumber(735);
            }while(d<119);
            addObject(f2,d,20);
        } 
        
        if(f3.alcanzado()==1)
        {
            removeObject(f3);
            puntosN2.incrementa(1);
            do
            {
                e=Greenfoot.getRandomNumber(735);
            }while(e<119);
            addObject(f3,e,20);
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
        usuario2.pierdeUnaVida();
    }
}

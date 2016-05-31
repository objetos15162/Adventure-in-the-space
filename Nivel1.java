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
public class Nivel1 extends World
{
    private int bMusic=0;
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer timerAdd = new SimpleTimer();
    private Items r1 = new Rocket(0,1);
    private Items m1 = new Municion(2,1);
    private Items v1 = new Vida(1,1);
    private Heroe usuario = new Heroe(1);
    private Asteroide a1 =new Asteroide();
    private Asteroide a2 =new Asteroide();
    private Asteroide a3 =new Asteroide();
    private Asteroide a4 =new Asteroide();
    private Asteroide a5 =new Asteroide();
    
    Letrero puntos;
    Letrero vidas;
    Letrero rocket;
    Letrero balas;
    
    /**
     * Constructor Nivel1.
     * 
     */
    public Nivel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 600, 1);
        construyeNivel1();
    }
    
    /**
     * Método que inicializa todos los objetos que se crearan en el nivel 
     */
    public void construyeNivel1()
    {
        setBackground("space.png");
        addObject(usuario,435,550);
        
        addObject(m1,120,0);
        addObject(r1,300,0);
        addObject(v1,500,0);
        
        addObject(a1,160,0);
        addObject(a2,240,0);
        addObject(a3,390,0);
        addObject(a4,590,0);
        addObject(a5,720,0);
  
        puntos=new Letrero(0,"puntaje:");
        vidas=new Letrero(15,"vidas:");
        rocket=new Letrero(10,"Rocket:");
        balas=new Letrero(60,"Balas:");
        
        addObject(puntos,110,85);
        addObject(vidas,110,115);
        addObject(rocket,110,145);
        addObject(balas,110,175);
        
    }
    
    /**
     * Ciclo que siempre se esta ejecutando
     * En este se checa la validacion de puntos para pasar al siguiente nivel
     * Mientras no se cumplan las condiciones especificadas se ejecutaran los métodos, activaObjetos, enemigoAlcanzado
     * y tocando asteroides
     */
    public void act()
    {
        if(puntos.obtenerValor()<1)//
        {
          activaObjetos();
          enemigosAlcanzados();
          tocandoAsteroide();
          
        }
        else
        {
            elimina_escenario();
            Greenfoot.setWorld(new Nivel2());
        }
    }
    
    /**
     * Método que hace posible quitar 1 vida al usuario,
     * las vidas se almacenan gracias a la clase letrero
     */
    public void heroeAlcanzado()
    {
        usuario.pierdeUnaVida();
    }
    
    /**
     * Metodo que Eliminara los objetos del nivel, cuando el metodo borde del objeto sea 1
     * De igual manera, los Reactivara , para que aparezcan en un lugar aleatorio en x  
     */
    public void activaObjetos()//activaItems
    {
        int u=0,v=0,w=0,x,y,z,a=0,b=0,c=0,d=0,e=0; 
        bMusic = 1;
         if(r1.getWorld ()!= null)
         {
              if(r1.borde()==1)
                {
                   removeObject(r1);
                }
         }
         else 
         {
             if(r1.getWorld ()==null && timerAdd.millisElapsed()>90000 )
             {
                 x=Greenfoot.getRandomNumber(749);
                 if(x>119)
                    addObject(r1,x,1);
             }
         }
         
         if(m1.getWorld ()!= null)
         {
              if(m1.borde()==1)
                {
                   removeObject(m1);        
                }
         }
         else 
         {
             if(m1.getWorld ()==null && timerAdd.millisElapsed()>10000 )
             {
                 y=Greenfoot.getRandomNumber(749);
                 if(y>119)
                    addObject(m1,y,1);
             }
         }
         
         if(v1.getWorld ()!= null)
         {
              if(v1.borde()==1)
                {
                   removeObject(v1);           
                }
         }
         else 
         {
             if(v1.getWorld ()==null && timerAdd.millisElapsed()>70000 )
             {
                 z=Greenfoot.getRandomNumber(749);
                 if(z>119)
                    addObject(v1,z,1);
             }
         }
        
        if(a1.borde()==1)
        {
            removeObject(a1);
            do
            {
                a=Greenfoot.getRandomNumber(735);
            }while(a<119);
            addObject(a1,a,0);
        }
        
        if(a2.borde()==1)
        {
            removeObject(a2);
            do  
            {
                b=Greenfoot.getRandomNumber(735);
            }while(b<119);
            addObject(a2,b,0);
        }
        
        if(a3.borde()==1)
        {
            removeObject(a3);
            do  
            {
                c=Greenfoot.getRandomNumber(735);
            }while(c<119);
            addObject(a3,c,0);
        }
              
        if(a4.borde()==1)
        {
            removeObject(a4);
            do  
            {
                d=Greenfoot.getRandomNumber(735);
            }while(d<119);
            addObject(a4,d,0);
        }      
        
        if(a5.borde()==1)
        {
            removeObject(a5);
            do  
            {
                e=Greenfoot.getRandomNumber(735);
            }while(e<119);
            addObject(a5,e,0);
        }
    }
    
    /**
     * Cuando el método alcanzado de los enemigos es igual a 1, se puntua con 1
     * Se remueve el objeto y reactiva en la posición inicial
     */
    public void enemigosAlcanzados()
    {
        int c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0;
        if(a1.alcanzado()==1)
        {
            removeObject(a1);
            puntos.incrementa(1);
            do  
            {
                f=Greenfoot.getRandomNumber(598);
            }while(f<119);
            addObject(a1,f,0);
        }  
        
        if(a2.alcanzado()==1)
        {
            removeObject(a2);
            puntos.incrementa(1);
            do  
            {
                g=Greenfoot.getRandomNumber(598);
            }while(g<119);
            addObject(a2,g,0);
        } 
        
        if(a3.alcanzado()==1)
        {
            removeObject(a3);
            puntos.incrementa(1);
            do  
            {
                h=Greenfoot.getRandomNumber(598);
            }while(h<119);
            addObject(a3,h,0);
        } 
        
        if(a4.alcanzado()==1)
        {
            removeObject(a4);
            puntos.incrementa(1);
            do  
            {
                i=Greenfoot.getRandomNumber(598);
            }while(i<119);
            addObject(a4,i,0);
        } 
        
        if(a5.alcanzado()==1)
        {
            removeObject(a5);
            puntos.incrementa(1);
            do  
            {
                j=Greenfoot.getRandomNumber(598);
            }while(j<119);
            addObject(a5,j,0);
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
     * Método que resta en 1 las vidas cuando el método toca de asteroide es 1
     * De igual manera remueve el objeto y lo reactiva en una posición aleatoria
     */    
    public void tocandoAsteroide()
        {
         int j,k,l,m,n;
         if(a1.toca()==1)
         {
            Greenfoot.playSound("explosion.wav");
            removeObject(a1);
            vidas.decrementa(0);
            do  
            {
                j=Greenfoot.getRandomNumber(598);
            }while(j<119);
            addObject(a1,j,0);
         } 
         if(a2.toca()==1)
         {
             Greenfoot.playSound("explosion.wav");
             removeObject(a2);
             vidas.decrementa(0);
             do  
             {
                k=Greenfoot.getRandomNumber(598);
             }while(k<119);
             addObject(a2,k,0);
         }
         if(a3.toca()==1)
         {
             Greenfoot.playSound("explosion.wav");
             removeObject(a3);
             vidas.decrementa(0);
             do  
             {
                l=Greenfoot.getRandomNumber(598);
             }while(l<119);
             addObject(a3,l,0);
         } 
         if(a4.toca()==1)
         {
             Greenfoot.playSound("explosion.wav");
             removeObject(a4);
             vidas.decrementa(0);
             do  
             {
                m=Greenfoot.getRandomNumber(598);
             }while(m<119);
             addObject(a4,m,0);
         } 
         if(a5.toca()==1)
         {
            Greenfoot.playSound("explosion.wav");
            removeObject(a5);
            vidas.decrementa(0);
            do  
             {
                n=Greenfoot.getRandomNumber(598);
             }while(n<119);
            addObject(a5,n,0);
         }
    }
}



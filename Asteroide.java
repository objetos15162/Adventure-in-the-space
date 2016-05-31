import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Asteroide
 * si toca al usuario se perdera mandara una bandera para indicar que se ha perdido una vida
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */

public class Asteroide extends Enemigo
{
    int asteroidImage = 1;
    int speedDown = 6;
    private Nivel1 mundo;
    public int x;
    /**
     * Ciclo que se ejecuta constante mente
     * Se ejecuta el método toca, al igual que los métodos borde y alcanzado del padre
     */
    public void act() 
    {
       toca();//2
       super.borde();
       super.alcanzado();
    }
    
    /**
     * Método que regresa 1 y remueve este obeto, si se esta tocando a la clase heroe
     */
     public int toca()
    {
        mundo = (Nivel1)getWorld();
        x=0;
          if(this.getWorld ()!= null)
           {
               muevete();//4setLocation(getX(),getY()+1);
               borde();
                  if(this.isTouching(Heroe.class))
               {
                 //mundo.removeObject(this);
                 x=1;
               }
           }
        return(x);
    }
    
    /**
     * Método utilizado para hacer que el objeto se mueva
     */
    public void muevete()
    {
            setImage("images/a"+asteroidImage+".png");//propios del objeto
            setLocation(getX(),getY()+4);//propios del objeto//speedDown
            
                if(asteroidImage<27)
                    asteroidImage++;
                else
                    asteroidImage=1;
       }
    
    
}
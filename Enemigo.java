import greenfoot.*;
/**Clase Enemigo, contiene los métodos que heredaran las subclases
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */

public class Enemigo extends Actor
{    
   /**
    * Método encargado de regresar 1, si un objeto enemigo llega a algun borde
    */ 
   public int borde()
    {
        int x=0;
        if(this.getX()==0)
        {
            x=1;
        }
        if(this.getX()==749)
        {
            x=1;
        }
        if(this.getY()==599)
        {
            x=1;
        }
        if(this.getY()==0)
        {
            x=1;
        }
        return(x);
    }
    
   /**
    * Metodo que regresa 1, si alguna subclase de enemigo fue alcanzada por una bala o misil 
    */ 
   public int alcanzado()
   {
         int x=0;
         
         if(this.isTouching(Misil.class))
         {
             x=1;
             removeTouching(Misil.class);
         }
         else
            if(this.isTouching(Bala.class))
            {
             x=1;
             removeTouching(Bala.class);
            }
         
        return(x);
   }

      
}
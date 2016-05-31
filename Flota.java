import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Flota
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Flota extends Enemigo
{
    private boolean isFlota=false;
    private boolean exist = true;
    private int x=0;
    /**
     * Ciclo que siempre se ejecuta, cada cierto tiempo manda llamar al método setShot
     * tambien ejecuta el metodo borde del padre 
     */
    public void act() 
    {
        // Add your action code here.
        muevete();
       int x = 0;
        x= Greenfoot.getRandomNumber(2);
        if(x == 1 || x == 0)
        {
            setShot();
        }
        super.borde();
        //eraseObjetoBorde();
    }
    
    /**
     * Metodo que da el movimiento a la clase
     */
    public void muevete()
    {
        setLocation(getX(),getY()+6);
    }
    
    /**
     * 
     * Método empleado para disparar y agregar objetos BalaFlota cada cierto tiempo
     */
    public void setShot()
    {
        x=Greenfoot.getRandomNumber(50);
        if(isFlota && (x==8))//<>
        {
            BalaFlota bf1 = new BalaFlota(6,1,8,'f',0,1);//0 abajo//0-2
            BalaFlota bf2 = new BalaFlota(6,1,8,'f',0,1);//0 abajo
            BalaFlota bf3 = new BalaFlota(6,1,8,'f',0,1);//0 abajo
            getWorld().addObject(bf1,getX()-35,getY()+50);//ubicaciob de bala
            getWorld().addObject(bf2,getX()+35,getY()+50);
            getWorld().addObject(bf3,getX(),getY()+50);
            isFlota = false;
           Greenfoot.playSound("laser.wav");
            //Greenfoot.playSound("shot.wav");
        } 
        
        if(!isFlota && x!=8){
            isFlota=true;
        }
    } 
    
    public void eraseObjetoBorde()
    {
        if(getX() >= getWorld().getWidth()-5&& exist)
        {
            getWorld().removeObject(this);
        }
        else
        {
            if(getY() >= getWorld().getHeight()-5)
            {
                getWorld().removeObject(this);
            }
        }
    }

}
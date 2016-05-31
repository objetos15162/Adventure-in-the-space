import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Alien 
 * si toca al usuario se perdera mandara una bandera para indicar que se ha perdido una vida
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class alien extends Enemigo
{
    private boolean isAlien=false;
    int alien = 0;
    int x,y ;
    
    /**
     *Ciclo que ejecuta el método disparo
     *Los metodos borde y alcanzado del padre
     */
    public void act() 
    {
        // Add your action code here.
        muevete();
        y= Greenfoot.getRandomNumber(2);
        if(y == 1 || y == 0)
        {
            setShot();
        }
        super.borde();
        super.alcanzado();
    }   
    
    /**
     * Método que permite moverse  de manera única al aobjeto alien
     */
    public void muevete()
    {
        setImage("images/alien"+alien+".png");//propios del objeto
        setLocation(getX()+1,getY());
        if(alien<8)
            alien++;
        else
            alien=0;   
    }
    
    /**
     * Método empleado para disparar y agregar objetos BalFlota cada cierto tiempo
     */
    public void setShot()
    {
        x=Greenfoot.getRandomNumber(50);
        if(isAlien && (x==8))//<>
        {
            //BalaFlota bfa = new BalaFlota(6,1,8,'f',0,1);//0 abajo//0-2
            BalaFlota bfa = new BalaFlota(6,1,8,'f',0,1);
            getWorld().addObject(bfa,getX(),getY()+50);
            isAlien = false;
           Greenfoot.playSound("laser.wav");
            //Greenfoot.playSound("shot.wav");
        } 
        
        if(!isAlien && x!=8){
            isAlien=true;
        }
    }
}
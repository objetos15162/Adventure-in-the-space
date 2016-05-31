import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Jefe solo aparece en el nivel 3
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Jefe extends Enemigo
{
    private boolean isJefe=false;
    int jefe = 1;
    int a,b ;
    /**
     * Ciclo que siempre se ejecuta, los metodos llamados son muevete, setShot y borde y alcanzado del padre
     */
    public void act() 
    {
        muevete();
        setShot();
        super.borde();
        super.alcanzado();
    } 
    
    /**
     * Método que da el movimiento característico a la clase
     */
    public void muevete()
    {
        setImage("images/jefe"+jefe+".png");//propios del objeto
        setLocation(getX()+4,getY());
        if(jefe<31)
            jefe++;
        else
            jefe=9;   
    }
    
    /**
     * Método empleado para disparar y agregar objetos BalJefe cada cierto tiempo
     */
    public void setShot()
    {
        a=Greenfoot.getRandomNumber(20);
        if(isJefe && (a==8))//<>
        {
            BalaJefe bj1 = new BalaJefe(6,1,12,'f',0,2);
            getWorld().addObject(bj1,getX(),getY()+100);
            isJefe = false;
           Greenfoot.playSound("laser.wav");
        } 
        
        if(!isJefe && a!=8){
            isJefe=true;
        }
    }
}

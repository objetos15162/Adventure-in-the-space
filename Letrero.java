import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

public class Letrero extends Actor
{
    GreenfootImage imagen;
    int cont;
    String mensaje;
    
    public Letrero(int c,String msj)
    {
        cont=c;
        mensaje=msj;
        imagen=new GreenfootImage(250,150);
        imagen.setColor(new Color(200,200,0,255));
        imagen.setFont(new Font("Verdana",Font.BOLD,16));
        dibuja();
    }
    
    public void dibuja()
    {
        imagen.clear();
        imagen.drawString(mensaje+cont,20,20);
        setImage(imagen);
    }
    
    public void incrementa(int y)
    {
        if(y==0)
            cont=cont+2;
        else
            if(y==1)
                cont=cont+1;
            else
                cont=cont+4;
        dibuja();
    }
    
    public void decrementa(int x)
    {
        if(x==0)
            cont--;
        else
            cont=cont-2;
        dibuja();
    }
    
    public int obtenerValor()
    {
        return(cont);
    }
    
}

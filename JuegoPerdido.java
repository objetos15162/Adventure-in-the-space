import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase JuegoPerdido
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */

public class JuegoPerdido extends Actor
{
    GreenfootImage imagen;
    String mensaje;
    
    /**
     * Constructor Clase JuegoPerdido
     * Permite que cuando se pierde en el juego aparezca un letrero de: "Fin del juego"
     */
    public JuegoPerdido()
    {
        imagen=new GreenfootImage(250,150);
        imagen.setColor(new Color(250,100,0,255));
        imagen.setFont(new Font("Verdana",Font.BOLD,34));
        imagen.drawString("Fin Del Juego",0,30);
        setImage(imagen);
        Greenfoot.stop();     
    }   
}
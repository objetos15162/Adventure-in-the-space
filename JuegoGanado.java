import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase JuegoGanado
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */

public class JuegoGanado extends Actor
{
    GreenfootImage imagen;
    String mensaje;
    
    /**
     * Constructor Clase JuegoGanado
     * Permite que cuando se gana en el juego aparezca un letrero de: "Ganaste"
     */
    public JuegoGanado()
    {
        imagen=new GreenfootImage(250,150);
        imagen.setColor(new Color(250,100,0,255));
        imagen.setFont(new Font("Verdana",Font.BOLD,34));
        imagen.drawString("GANASTE",0,30);
        setImage(imagen); 
    }
}


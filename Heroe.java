import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase principal
 * Contiene los metodos necesarios para hacer todo el control de teclas
 * Tambien los métodos que hacen posibles los incrementos y decrementos de vidas y potenciadores
 * Jorge Arredondo Santiago 
 * version 1.0
 * 30/05/16
 * POO UASLP
 */
public class Heroe extends Actor
{
    private Nivel2 mundo2;
    private Nivel3 mundo3;
    private Nivel1 mundo;
    public GreenfootImage sprite1;
    public GreenfootImage sprite2;
    public GreenfootImage sprite3;
    public GreenfootImage sprite4;
    public GreenfootImage sprite5;
    public GreenfootImage sprite6;
    public GreenfootImage spriteArmy;
    private int nivel;
    int paso = 3;//era4
    long pauseTime = 0;//saves the time when we can start moving again
    boolean isShot = false;//
    boolean isRocket = false;//
    
    /**
     * Constructor clase heroe
     */
    public Heroe(int nivel)
    {
        this.nivel=nivel;
        sprite1 = new GreenfootImage("rAstroo.png");
        sprite2 = new GreenfootImage("rAstroo2.png");
        sprite3 = new GreenfootImage("rAstroo3.png");
        sprite4 = new GreenfootImage("rAstroo4.png");
        sprite5 = new GreenfootImage("rAstroo5.png");
        sprite6 = new GreenfootImage("rAstroo6.png");
        spriteArmy = new GreenfootImage("rAstrooArmy.png");
        setImage(sprite1);
        
    }
    
    /**
     * Metodo que siempre se ejecuta, ejecuta los metodos control, setShot, setRocket y controldeVidas
     */
    public void act() 
    {
      if(running())
      {
          control();    
          setShot();
          setRocket();
          verificaAlcanzado();
          contadordeVidas();
          //verificarTocarCaja();
      }
    }
    
    public boolean running() //are we running or are we paused
    {
        long time = System.currentTimeMillis();
        return time > pauseTime;
    }
    
        public void pause(long delay) //delay represents how long we are delaying for
    {
        long time = System.currentTimeMillis();
        pauseTime = time+delay;//redefine pauseTime so it is in the future-exactly delay milliseconds in the future
    }
    
    /**
     * Permite el manejo de movimiento y cambio de sprites
     * A traves de las teclas
     */
    public void control()
    {
        if(Greenfoot.isKeyDown("right"))
              if (getX()==720)//535
                  move(0);
              else{
                    //setRotation(0);
                  move(paso);}

      
          if(Greenfoot.isKeyDown("left"))
              if (getX()==132)//35
                  move(0);
              else
                  move(-paso);
         
          if(Greenfoot.isKeyDown("z"))
          {
              if ( getImage() == sprite1 )
                  setImage(sprite2);
              else
                  if ( getImage() == sprite2 )
                      setImage(sprite3);
                  else
                      if ( getImage() == sprite3 )
                          setImage(sprite4);
                      else
                          if ( getImage() == sprite4 )
                              setImage(sprite5);
                          else
                              setImage(sprite6);
          }
          
          if(Greenfoot.isKeyDown("x"))
          {
              if ( getImage() == sprite6 )
                  setImage(sprite5);
              else
                  if ( getImage() == sprite5 )
                      setImage(sprite4);
                  else
                      if ( getImage() == sprite4 )
                          setImage(sprite3);
                      else
                          if ( getImage() == sprite3 )
                              setImage(sprite2);
                          else
                              setImage(sprite1);
          }
          
          if(Greenfoot.isKeyDown("c"))
              setImage(spriteArmy);
    }
    
    /**
     * Método empleado para disparar y agregar objetos Bala cada cierto tiempo
     */
    public void setShot()
    {
        if(nivel==1)
        {
            mundo=(Nivel1)getWorld();
            if ( getImage() == sprite6 )
            {
                if(isShot && Greenfoot.isKeyDown("a")&& mundo.balas.obtenerValor()>0)
                {
                    Bala b1 = new Bala(6,1,5,'d',1,0);//era8
                    getWorld().addObject(b1,getX(),getY()-25);
                    pierdeUnaBala();
                    isShot = false;
                    Greenfoot.playSound("shot.wav");
                } 
         
                if(!isShot && !Greenfoot.isKeyDown("a")){
                    isShot=true;
                }
            }
        }
        
        if(nivel==2)
        {
            mundo2=(Nivel2)getWorld();
            if ( getImage() == sprite6 )
            {
                if(isShot && Greenfoot.isKeyDown("a")&& mundo2.balasN2.obtenerValor()>0)
                {
                    Bala b2 = new Bala(6,1,5,'d',1,1);
                    getWorld().addObject(b2,getX(),getY()-25);
                    pierdeUnaBala();
                    isShot = false;
                    Greenfoot.playSound("shot.wav");
                } 
         
                if(!isShot && !Greenfoot.isKeyDown("a")){
                    isShot=true;
                }
            }
        }
        
        if(nivel==3)
        {
            mundo3=(Nivel3)getWorld();
            if ( getImage() == sprite6 )
            {
                if(isShot && Greenfoot.isKeyDown("a")&& mundo3.balasN3.obtenerValor()>0)
                {
                    Bala b3 = new Bala(6,1,5,'d',1,2);
                    getWorld().addObject(b3,getX(),getY()-25);
                    pierdeUnaBala();
                    isShot = false;
                    Greenfoot.playSound("shot.wav");
                } 
         
                if(!isShot && !Greenfoot.isKeyDown("a")){
                    isShot=true;
                }
            }
        }
    } 

    /**
     * Método empleado para disparar y agregar objetos misil cada cierto tiempo
     */
    public void setRocket()
    {
        if(nivel==1)
        {
            mundo=(Nivel1)getWorld();
            if ( getImage() == spriteArmy )
            {
                if(isRocket && Greenfoot.isKeyDown("s") && mundo.rocket.obtenerValor()>0)
                {
                    Misil m1 = new Misil(20,11,8,'m',1,0);
                    Misil m2 = new Misil(20,11,8,'m',1,0);
                    getWorld().addObject(m1,getX()-25,getY()-55);
                    getWorld().addObject(m2,getX()+25,getY()-55);
                    pierdeRocket();
                    isRocket = false;
                    Greenfoot.playSound("rocket.wav");
                } 
         
                if(!isRocket && !Greenfoot.isKeyDown("s")){
                    isRocket=true;
                }
            }
        }
        
        if(nivel==2)
        {
            mundo2=(Nivel2)getWorld();
            if ( getImage() == spriteArmy )
            {
                if(isRocket && Greenfoot.isKeyDown("s") && mundo2.rocketN2.obtenerValor()>0)
                {
                    Misil m3 = new Misil(20,11,8,'m',1,1);
                    Misil m4 = new Misil(20,11,8,'m',1,1);
                    getWorld().addObject(m3,getX()-25,getY()-55);
                    getWorld().addObject(m4,getX()+25,getY()-55);
                    pierdeRocket();
                    isRocket = false;
                    Greenfoot.playSound("rocket.wav");
                } 
         
                if(!isRocket && !Greenfoot.isKeyDown("s")){
                    isRocket=true;
                }
            }
        }
        
        if(nivel==3)
        {
            mundo3=(Nivel3)getWorld();
            if ( getImage() == spriteArmy )
            {
                if(isRocket && Greenfoot.isKeyDown("s") && mundo3.rocketN3.obtenerValor()>0)
                {
                    Misil m5 = new Misil(20,11,8,'m',1,2);
                    Misil m6 = new Misil(20,11,8,'m',1,2);
                    getWorld().addObject(m5,getX()-25,getY()-55);
                    getWorld().addObject(m6,getX()+25,getY()-55);
                    pierdeRocket();
                    isRocket = false;
                    Greenfoot.playSound("rocket.wav");
                } 
         
                if(!isRocket && !Greenfoot.isKeyDown("s")){
                    isRocket=true;
                }
            }
        }
    }
    
    
    /**
     * Metodo que permite restar vidas cuando el metodo sea llamado
     */
    public void pierdeUnaVida()
    {
       if(nivel == 1)
       {
           Nivel1 mundo=(Nivel1)getWorld();
           mundo.vidas.decrementa(0);
       }
       
       if(nivel == 2)
       {
           Nivel2 mundo2=(Nivel2)getWorld();
           mundo2.vidasN2.decrementa(0);
       }
       
       if(nivel == 3)
       {
           Nivel3 mundo3=(Nivel3)getWorld();
           mundo2.vidasN2.decrementa(0);
       }
    }
    
    /**
     * Metodo que permite restar balas cuando el metodo sea llamado
     */
    public void pierdeUnaBala()
    {
       if(nivel == 1)
       {
           Nivel1 mundo=(Nivel1)getWorld();
           mundo.balas.decrementa(0);
       }
       
       if(nivel == 2)
       {
           Nivel2 mundo2=(Nivel2)getWorld();
           mundo2.balasN2.decrementa(0);
       }
       
       if(nivel == 3)
       {
           Nivel3 mundo3=(Nivel3)getWorld();
           mundo3.balasN3.decrementa(0);
       }
    }
    
    /**
     * Metodo que permite restar misiles cuando el metodo sea llamado
     */
    public void pierdeRocket()
    {
       if(nivel == 1)
       {
           Nivel1 mundo=(Nivel1)getWorld();
           mundo.rocket.decrementa(1);
       }
       
       if(nivel == 2)
       {
           Nivel2 mundo2=(Nivel2)getWorld();
           mundo2.rocketN2.decrementa(1);
       }
       
       if(nivel == 3)
       {
           Nivel3 mundo3=(Nivel3)getWorld();
           mundo3.rocketN3.decrementa(1);
       }
    }
    
    /**
     * Metodo que detecta cuando el heroe es alcanzado por un asteroide, BalaFlota
     */
    public void verificaAlcanzado()
    {
        if(nivel==1)
        {
            mundo = (Nivel1)getWorld();  
            if(this.isTouching(Asteroide.class))//if(this.isTouching(Enemigo.class))
            {
                mundo.heroeAlcanzado();
            }
        
            if(this.isTouching(Asteroide.class))
            {
                mundo.heroeAlcanzado();
                mundo.enemigosAlcanzados();
            }
        }  
        
        if(nivel==2)
        {
            mundo2 = (Nivel2)getWorld(); 
            if(this.isTouching(BalaFlota.class))//if(this.isTouching(Enemigo.class))
            {
                mundo2.heroeAlcanzado();
            }
        }
        
        if(nivel==3)
        {
            mundo3 = (Nivel3)getWorld(); 
            if(this.isTouching(BalaFlota.class))//if(this.isTouching(Enemigo.class))
            {
                mundo3.heroeAlcanzado();
            }
        }
    }
    
    /**
     * Metodo que cuenta las vidas, permite mostrar el letrero de "Fin del Juego", cuando ya no quedan vidas
     */
    public void contadordeVidas()
    {
        if(nivel==1)
        {
            Nivel1 mundo=(Nivel1)getWorld();
            if(mundo.vidas.obtenerValor()<=0)
            {
                JuegoPerdido t=new JuegoPerdido();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
               
                //Greenfoot.setWorld(new Menu());
            }
        }
        
        if(nivel==2)
        {
            Nivel2 mundo2=(Nivel2)getWorld();
            if(mundo2.vidasN2.obtenerValor()<=0)
            {
                JuegoPerdido t=new JuegoPerdido();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
            }
        }
        
        if(nivel==3)
        {
            Nivel3 mundo3=(Nivel3)getWorld();
            if(mundo3.vidasN3.obtenerValor()<=0)
            {
                JuegoPerdido t=new JuegoPerdido();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
            }
        }
    }    
}    

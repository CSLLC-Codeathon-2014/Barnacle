import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player
{
    private Image sprite;
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int score;
    private boolean canBeHit;
    
    public Player() throws SlickException{
        sprite=new Image("resources/images/chickun1.png");
        x=0;
        y=0;
        xVel=0;
        yVel=0;
        score=0;
        canBeHit=true;
    }
    public Player(String filename) throws SlickException{
        this();
        sprite=new Image(filename);
        x=0;
        y=0;
        xVel=0;
        yVel=0;
        score=0;
        canBeHit=true;
    }
    
    public Player(String filename, int initX, int initY) throws SlickException{
        this(filename);
        x=initX;
        y=initY;
        x=0;
        y=0;
        xVel=0;
        yVel=0;
        score=0;
        canBeHit=true;
    }

    // Getters
    public Image getSprite(){
        return sprite;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getXVel(){
        return xVel;
    }
    public int getYVel(){
        return yVel;
    }
    public int getScore(){
        return score;
    }
    public boolean canBeHit(){
        return canBeHit;
    }

    // Setters
    public void setSprite(Image newSprite) throws SlickException{
        sprite= newSprite;
    }
    
    public void setSprite(String filename) throws SlickException{
        sprite=new Image(filename);
    }

    public void setX(int newX){
        x=newX;
    }
    public void setY(int newY){
        y=newY;
    }
    public void setPos(int newX, int newY){
        x=newX;
        y=newY;
    }

    public void setXVel(int newXVel){
        xVel=newXVel;
    }
    public void setYVel(int newYVel){
        yVel=newYVel;
    }
    public void setVel(int newXVel, int newYVel){
        xVel=newXVel;
        yVel=newYVel;
    }

    public void score(){
        ++score;
    }
    public void resetScore(){
        score=0;
    }

    public void setCanBeHit(boolean newHit){
        canBeHit=newHit;
    }
}

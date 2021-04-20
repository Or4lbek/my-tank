import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class DrawTank extends MyPlayer {


        Map map;
        Bullet bullet;
        Position position;
        Rectangle tank = new Rectangle(20,15);
        Rectangle gun = new Rectangle(6,10);

        DrawTank(Map map){
            tank.setFill(Color.RED);
            tank.setStroke(Color.BLACK);
            gun.setFill(Color.BLUE);
    
            this.map=map;
            map.getChildren().addAll(tank, gun);
            this.position=map.getStartPosition();
            
            gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-3);         
            gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)); 
            tank.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-10);          
            tank.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-7.5);   
    
        }
    
        @Override
        public void moveRight() {
    
            position.setX((position.getX() + 1));
    
            if (position.getX()<=map.getSize()-1) {
    
                if (map.getValue(position.getY(), position.getX()) == 0 || map.getValue(position.getY(),  position.getX()) == 2) {
                    tank.setX(tank.getX() + 31);
                    tank.setRotate(90);
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-27); 
                    gun.setX(gun.getX() + 31);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-5); 
                    gun.setRotate(270);
                    tank.setFill(Color.RED);
                    tank.setStroke(Color.RED);
                    gun.setFill(Color.BLUE);
                    
                }else if (map.getValue(position.getY(), position.getX()) == 5){
                    tank.setX(tank.getX() + 31);
                    tank.setRotate(90);
                    tank.setFill(Color.rgb(156,235,0));
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-27); 
                    gun.setX(gun.getX() + 31);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-5); 
                    gun.setRotate(270);
                    gun.setFill(Color.rgb(156,235,0));
                    tank.setStroke(Color.rgb(156,235,0));
                }
                else {
                    position.setX((position.getX() - 1));
                }
            }
            else{position.setX(position.getX()-1);}
        }           //moves  to the right
    
        @Override
        public void moveLeft() {
    
            position.setX((position.getX() - 1));
    
            if (position.getX()>=0) {
    
                if (map.getValue(position.getY(), position.getX()) == 0 || map.getValue(position.getY(),  position.getX()) == 2) {
                    tank.setX(tank.getX() - 31);
                    tank.setRotate(-90);
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)+20); 
                    gun.setX(gun.getX() - 31);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-5); 
                    gun.setRotate(270);
                    tank.setFill(Color.RED);
                    tank.setStroke(Color.RED);
                    gun.setFill(Color.BLUE);
                } else if (map.getValue(position.getY(), position.getX()) == 5){
                    tank.setX(tank.getX() - 31);
                    tank.setRotate(90);
                    tank.setFill(Color.rgb(156,235,0));
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)+20); 
                    gun.setX(gun.getX() - 31);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-5); 
                    gun.setRotate(270);
                    gun.setFill(Color.rgb(156,235,0));
                    tank.setStroke(Color.rgb(156,235,0));
                }else {
                    position.setX((position.getX() + 1));
                }
            }
            else{position.setX(position.getX()+1);}
        }           //moves  to the left
    
        @Override
        public void moveUp() {
    
            position.setY((position.getY() - 1));
    
            if (position.getY()>=0) {
    
                if (map.getValue(position.getY(), position.getX()) == 0 || map.getValue(position.getY(),  position.getX()) == 2) {
                    tank.setY(tank.getY() - 31);
                    tank.setRotate(180);
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-3);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)+20); 
                    gun.setY(gun.getY() - 31);
                    gun.setRotate(180);
                    tank.setStroke(Color.RED);
                    tank.setFill(Color.RED);
                    gun.setFill(Color.BLUE);
                } else if (map.getValue(position.getY(), position.getX()) == 5){
                    tank.setY(tank.getY() - 31);
                    tank.setRotate(180);
                    tank.setFill(Color.rgb(156,235,0));
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-3);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)+20); 
                    gun.setY(gun.getY() - 31);
                    gun.setRotate(180);
                    gun.setFill(Color.rgb(156,235,0));
                    tank.setStroke(Color.rgb(156,235,0));
                }else {
                    position.setY((position.getY() + 1));
                }
            }
            else{position.setY(position.getY()+1);}
        }           //moves  upward
    
        @Override
        public void moveDown() {
    
            position.setY((position.getY() + 1));
    
            if (position.getY()<=map.getSize()-1) {
    
                if (map.getValue(position.getY(), position.getX()) == 0 || map.getValue(position.getY(),  position.getX()) == 2) {
                    tank.setY(tank.getY() + 31);
                    tank.setFill(Color.RED);
                    tank.setStroke(Color.RED);
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-3);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-30); 
                    gun.setY(gun.getY() + 31);
                    gun.setFill(Color.BLUE);
                    tank.setRotate(0);
                    gun.setRotate(0);


                } else if (map.getValue(position.getY(), position.getX()) == 5){
                    tank.setY(tank.getY() + 31);
                    tank.setFill(Color.rgb(156,235,0));
                    tank.setStroke(Color.rgb(156,235,0));
                    gun.setX(position.getX()*map.getUnit()+(map.getUnit()/2)-3);
                    gun.setY(position.getY()*map.getUnit()+(map.getUnit()/2)-30); 
                    gun.setY(gun.getY() + 31);
                    gun.setFill(Color.rgb(156,235,0));
                    tank.setRotate(0);
                    gun.setRotate(0);
                }else {
                    position.setY((position.getY() - 1));
                }
            }
            else{position.setY(position.getY()-1);}
        }   

        //fire method
        public void fire(){

            bullet=new Bullet();
            double x,y,dx,dy;
    
            x=gun.getX();
            y=gun.getY();
            bullet.setCenterX(x);
            bullet.setCenterY(y);
    
            dx=0;
            dy=0;    
            if (tank.getRotate() == 180.0){
                System.out.println(tank.getRotate());
                dx=x;
                dy=0;
                //System.out.println("position: "+getPosition());
                  //  System.out.println("p x:"+getPosition().getX() + "p y:"+getPosition().getY());


                for(int i=getPosition().getY();i>=0;i--){
                    int j=getPosition().getX();
                    if(map.getValue(i,j) == 6){
                        dy=(i+1)*30;
                        //System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Steel wall");
                        break;
                    }
                    else if(map.getValue(i,j)== 3){
                        dy=(i+1)*30;
                        //System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the  Brick wall");
                        break;
                    }
                }
            }
            else if (tank.getRotate() == 90.0){
                dy=y;
                dx=(map.getSize())*30;
                //    System.out.println("position: "+getPosition());
                  //  System.out.println("p x:"+getPosition().getX() + "p y:"+getPosition().getY());

                for(int i=getPosition().getX();i<map.getSize();i++){
                    int j=getPosition().getY();
                    if(map.getValue(j,i)==6){
                        dx=(i)*30;
                      //  System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Steel wall");
                        break;
                    }
                    else if(map.getValue(j,i)== 3) {
                        dx=(i)*30;
                        //System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Brick wall");
                        break;
                    }
                }
            }
            else if (tank.getRotate() == 0.0){
                //System.out.println(tank.getRotate());
                dx=x;
                dy=(map.getSize())*30;
                    
                    //System.out.println("position: "+getPosition());
                    //System.out.println("p x:"+getPosition().getX() + "p y:"+getPosition().getY());
                for(int i=getPosition().getY();i<map.getSize();i++){
                    int j=getPosition().getX();
                    if(map.getValue(i,j)==6){
                        dy=(i)*30;
                        //    System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Steel wall");
                        break;
                    }
                    else if(map.getValue(i,j)== 3) {
                        dy=(i)*30;
                           // System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Brick wall");
                        break;
                    }
                }
            }
            else if(tank.getRotate() == -90.0){
                //System.out.println(tank.getRotate());
                dy=y;
                dx=0;
                //System.out.println("position: "+getPosition());
                //System.out.println("p x:"+getPosition().getX() + "p y:"+getPosition().getY());
                for(int i=getPosition().getX();i>=0;i--){
                    int j=getPosition().getY();
                    if(map.getValue(j,i)==6){
                        dx=(i+1)*30;
                        //    System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Steel wall");
                        break;
                    }
                    else if(map.getValue(j,i)==3) {
                        dx=(i+1)*30;
                        //System.out.println("dx dy"+dy + " " + dx + "x y " + x + " " +y);
                        System.out.println("fire stopped at the Brick wall");
                        break;
                    }
                }
            }
            
            map.getChildren().add(bullet);
    
            PathTransition animation=new PathTransition();
            animation.setPath(new Line(x,y,dx,dy));
            animation.setNode(bullet);
            animation.setDuration(Duration.millis(250));
            animation.setCycleCount(1);
            animation.play();
    
            animation.setOnFinished(e->{
                for(int i=0;i<map.getChildren().size();i++){
                    if (map.getChildren().get(i) instanceof Bullet){
                        map.getChildren().remove(map.getChildren().get(i));
                    }
                }
            });
            
        }       
    
        @Override
        public Position getPosition() {
            return position;
        }
        public double getrotate(){
            return tank.getRotate();
        }
    }
    
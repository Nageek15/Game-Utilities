package graphics.screen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

public class SPanel extends JPanel implements ActionListener{
	    protected Timer t;
	    protected final int TIMER_DELAY=10;
	    protected Hashtable<String,Screen>screens;
	    protected Screen currentScreen;
	    

	    public SPanel(){

	        setFocusable(true);
	        screens=new Hashtable<>();

	        

	        t=new Timer(TIMER_DELAY,this);
	        t.start();
	        setDoubleBuffered(true);
	        setBackground(Color.BLACK);
	    }

	    public void paintComponent(Graphics g){
	        //draw background color
	        g.setColor(getBackground());
	        g.fillRect(0,0,getWidth(),getHeight());
	        currentScreen.paint(g);
	    }



	    @Override
	    public void actionPerformed(ActionEvent e) {
	        repaint();
	        currentScreen.update();
	    }

	    public void setScreen(String name){
	        currentScreen.setDeinit();
	        currentScreen=screens.get(name);
	        currentScreen.setInit();
	    }

	    public void addScreen(Screen s,String name){
	        screens.put(name,s);
	    }

	    protected class TAdapter extends KeyAdapter{
	        public void keyPressed(KeyEvent e){
	            currentScreen.keyPressed(e);
	        }

	        public void keyReleased(KeyEvent e) {
	            currentScreen.keyReleased(e);
	        }
	    }

	    protected class MAdapter extends MouseAdapter{

	        public void mousePressed(MouseEvent e){
	            currentScreen.mousePressed(e);
	        }

	        public void mouseReleased(MouseEvent e){
	            currentScreen.mouseReleased(e);
	        }

	        public void mouseMoved(MouseEvent e){
	            currentScreen.mouseMoved(e);
	        }

	    }

}


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class View extends Canvas implements Observer{
	Presenter presenter;  
	int stepNumber = 0;
	
	public View(Presenter presenter) {
		this.presenter=presenter;
	}
	
	public void paint(Graphics g) {  
		g.setColor(Color.red);   
		g.fillOval(presenter.xPosition, presenter.yPosition, presenter.BALL_SIZE,     
				presenter.BALL_SIZE);   
		presenter.showStatus("Step " + (stepNumber++) + ", x = "
				+ presenter.xPosition + ", y = " + presenter.yPosition);  
		}   
	
	public void update(Observable obs, Object arg) {   
		repaint();  
		}
}

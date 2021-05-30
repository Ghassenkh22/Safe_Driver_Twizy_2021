package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import classes.AnalyseVideo;

public class PauseButton extends JButton implements MouseListener{
	Icon pressed,rolled;
	AnalyseVideo analyse;
	public PauseButton(Icon icon) {
		super(icon);
		pressed  = new ImageIcon("UI/button/pause1_p1.png");
		rolled  = new ImageIcon("UI/button/pause1_p.png");
		 this.setPreferredSize(new Dimension(50, 50));	
			this.setPreferredSize(new Dimension(50, 50));	
			this.setBorderPainted(false);
			this.setBorder(null);
			this.setMargin(new Insets(0, 0, 0, 0));
			this.setContentAreaFilled(false);
			this.setRolloverIcon(rolled);
			this.setPressedIcon(pressed);
			this.addMouseListener(this);
		 }
	@Override
	public void mouseClicked(MouseEvent e) {
		AnalyseVideo.continueVideo=false;
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setAnalyse(AnalyseVideo analyse) {
		this.analyse=analyse;
	}
}

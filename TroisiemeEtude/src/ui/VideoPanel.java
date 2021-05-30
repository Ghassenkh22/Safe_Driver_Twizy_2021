package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VideoPanel extends JPanel {
	Image image;
	public VideoPanel() {
	}
	public VideoPanel(Image in_image) throws IOException {
		this.image=in_image;
	}
	public void setImage(Image in_image) {
		this.image=in_image;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

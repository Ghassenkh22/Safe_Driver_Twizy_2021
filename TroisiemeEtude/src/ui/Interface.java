package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

import classes.AnalyseVideo;

public class Interface extends JFrame implements ActionListener{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu= new JMenu("Fichier");
	
	private JMenuItem menuItem = new JMenuItem("Ouvrir");
	private JPanel container1 = new JPanel();
	private JPanel container2 = new JPanel();
	private VideoPanel panel1 = new VideoPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new VideoPanel();
	private PanneauxPanel panel3_image = new PanneauxPanel();
	private JLabel panel3_text = new JLabel();
	private JPanel panel3_text_container = new JPanel();
	private JPanel groupe_bouton = new JPanel();
	private LectureButton lecture;
	private PauseButton pause;
	private RestartButton recommencer;
	
	File fichier;
	public boolean fileSelected=false;
	public AnalyseVideo analyse;
	public Image frame;
	public int width,height;
	public int panneauxWidth;
	private Image icone;
	public Interface(){
		this.setTitle("Interface Twizzy");
		width=1300;
		height=700;
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.agencementFenetre();
		try {
			icone= ImageIO.read(new File("icone.ico"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(icone);
		
		while(true) {
			if(this.fileSelected) {
				this.fileSelected=false;
				this.analyse = new AnalyseVideo(this.fichier,this.panel1,this.panel3_image, this.pause,this.lecture,this.recommencer);
				
			}
			System.out.println("J'attends un fichier !");
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser dialogue =new JFileChooser(new File("."));
		//create a FileFilter and override its accept-method
		FileFilter mp4Filefilter = new FileFilter() 
		{
		      //Override accept method
		      public boolean accept(File file) {
		              
		             //if the file extension is .log return true, else false
		             if (file.getName().endsWith(".mp4")) {
		                return true;
		             }
		             return false;
		      }

			@Override
			public String getDescription() {
				
				return "Fichier vidéo (mp4)";
			}
		};
		dialogue.setFileFilter(mp4Filefilter);
		if(dialogue.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			this.fichier=dialogue.getSelectedFile();
			System.out.println(fichier.getName());
			
			this.fileSelected=true;
			}
		
	}
	private void agencementFenetre() {
		container1.setLayout(new BoxLayout(container1, BoxLayout.Y_AXIS));
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));
		
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		
		panel3_image.setPreferredSize(new Dimension(254,254));
		panel3_image.setMaximumSize(new Dimension(254,254));
		panel1.setPreferredSize(new Dimension(this.getWidth()-254,this.getHeight()-50));
		panel3_text.setText("Panneaux Détecté");
		panel3_text_container.setMaximumSize(new Dimension(254,40));
		panel3_text_container.add(panel3_text);
		
		panel1.setBackground(Color.blue);
		panel3.setBorder(BorderFactory.createRaisedBevelBorder());
		panel2.setBorder(BorderFactory.createRaisedBevelBorder());
		panel3_text_container.add(panel3_image);
		panel3.add(panel3_text_container);
		panel3.add(panel3_image);
		panel3.add(new JPanel());
		container1.add(panel1);
		container1.add(panel2);
		container2.add(container1);
		container2.add(panel3);
		
		
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		menuItem.addActionListener(this);
		
		
		
		groupe_bouton.setLayout(new BoxLayout(groupe_bouton, BoxLayout.X_AXIS));
		
		Icon pauseIcon = new ImageIcon("UI/button/pause1.png");
		Icon lectureIcon = new ImageIcon("UI/button/lecture1.png");
		Icon restartIcon = new ImageIcon("UI/button/restart1.png"); 
		pause=new PauseButton(pauseIcon);
		lecture=new LectureButton(lectureIcon);
		recommencer = new RestartButton(restartIcon);
		groupe_bouton.add(recommencer);
		groupe_bouton.add(lecture);
		groupe_bouton.add(pause);
		
		panel2.add(groupe_bouton);
		
		this.setContentPane(container2);
		pack();
		
	}
	public void setFrame(Image image) {
		this.frame=image;
	}
	
}

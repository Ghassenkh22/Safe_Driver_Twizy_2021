package classes;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
//import org.opencv.highgui.Highgui;
//import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import ui.LectureButton;
import ui.PanneauxPanel;
import ui.PauseButton;
import ui.RestartButton;
import ui.VideoPanel;

import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.videoio.VideoCapture;
import utilitaireAgreg.*;
public class AnalyseVideo {
	JFrame jframe = new JFrame("Detection de panneaux sur un flux vidéo");
	public JLabel vidpanel = new JLabel();
	public PanneauxPanel panneauxPanel;
	public VideoPanel videoPanel;
	ImageIcon image;
	Image image_30;
	Image image_50;
	Image image_70;
	Image image_90;
	Image image_110;
	Image image_stop;
	static Mat imag = null;
	public VideoCapture camera;
	int video_length;
	PauseButton pauseButton; 
	LectureButton lectureButton; 
	RestartButton restartButton;
	public static boolean continueVideo;

	public AnalyseVideo(File fichier, VideoPanel videoPanel, PanneauxPanel panneauxPanel, PauseButton pauseButton, LectureButton lectureButton, RestartButton restartButton){
		this.continueVideo=true;
		try {
			this.initImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setPanel(videoPanel, panneauxPanel);
		//jframe.setContentPane(vidpanel);
		//jframe.setSize(1000, 500);
		//jframe.setVisible(true);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		int nbr30=0;
		int nbr50=0;
		int nbr70=0;
		int nbr90=0;
		int nbr110=0;
		int nbrdep=0;
		int valeurprec=0;
		//Mat frame =Highgui.imread("p8.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		
		camera = new VideoCapture(fichier.getPath());
		video_length =(int) (camera.get(Videoio.CAP_PROP_FRAME_COUNT));
		this.pauseButton=pauseButton;
		this.lectureButton=lectureButton;
		this.restartButton=restartButton;
		this.pauseButton.setAnalyse(this);
		this.lectureButton.setAnalyse(this);
		this.restartButton.setAnalyse(this);
		
		 /*if (!camera.isOpened()) {
	            System.out.println("Error! Camera can't be opened!");
	            return;
	        }*/
		Mat PanneauAAnalyser = null;
		Mat frame=new Mat();
			while (camera.read(frame)) {
			//A completer
		//MaBibliothequeTraitementImageEtendue.afficheImage("Image testée", frame);
		Mat transformee=MaBibliothequeTraitementImageEtendue.transformeBGRversHSV(frame);
		//la methode seuillage est ici extraite de l'archivage jar du meme nom 
		Mat saturee=MaBibliothequeTraitementImageEtendue.seuillage(transformee, 6, 170, 110);
		Mat objetrond = null;

		//Création d'une liste des contours à partir de l'image saturée
		List<MatOfPoint> ListeContours= MaBibliothequeTraitementImageEtendue .ExtractContours(saturee);
		//System.out.println("nbr contour"+ListeContours.size()+"\n");
		int i=0;
		int k=0;
		int indice;
		int mode=1;
	
		double [] scores=new double [6];
		//Pour tous les contours de la liste
		for (MatOfPoint contour: ListeContours  ){
			i++;
			objetrond=MaBibliothequeTraitementImageEtendue.DetectForm(frame,contour);
			
			if (objetrond!=null && objetrond.cols()>6 && objetrond.rows()>6){
				//MaBibliothequeTraitementImageEtendue.afficheImage("Objet rond detécté", objetrond);
				if(mode==1) {
					//System.out.println("mode= "+mode+"\n");
					indice=MaBibliothequeTraitementImageEtendue.identifiepanneau(objetrond);
					//System.out.println("indice max"+indice+"\n");
					switch(indice){
					case -1:System.out.println("Aucun panneau détécté");break;
					case 0:{
							if (valeurprec!=30)
							  nbr30=0;
						      nbr30++;
						//System.out.println("nbr 30= "+nbr30+"\n");
						if (nbr30==5)
						{  nbr30=0;
							System.out.println("Panneau 30 détécté");
							this.panneauxPanel.setImage(image_30);
							this.panneauxPanel.repaint();}
						valeurprec=30;
						break;
						}
					
					case 1:
						{if (valeurprec!=50)
						nbr50=0;
							nbr50++;
						//System.out.println("nbr 50= "+nbr50+"\n");
						if (nbr50==5)
						{  nbr50=0;
							System.out.println("Panneau 50 détécté");
							this.panneauxPanel.setImage(image_50);
							this.panneauxPanel.repaint();}
						valeurprec=50;
						break;}
					case 2:
					{   if (valeurprec!=70)
						nbr70=0;
						nbr70++;
					//System.out.println("nbr 70= "+nbr70+"\n");
					if (nbr70==3)
					{  nbr70=0;
						System.out.println("Panneau 70 détécté");
						this.panneauxPanel.setImage(image_70);
						this.panneauxPanel.repaint();}
					valeurprec=70;
					break;}
					case 3:
						{if (valeurprec!=90)
							nbr90=0;
							nbr90++;
					//System.out.println("nbr 90= "+nbr90+"\n");
					if (nbr90==3)
					{  nbr90=0;
						System.out.println("Panneau 90 détécté");
						this.panneauxPanel.setImage(image_90);
						this.panneauxPanel.repaint();}
					valeurprec=90;
					break;}
					case 4:
					{ if (valeurprec!=110)
						nbr110=0;
						nbr110++;
					//System.out.println("nbr 110= "+nbr110+"\n");
					if (nbr110==3)
					{  nbr110=0;
						System.out.println("Panneau 110 détécté");
						this.panneauxPanel.setImage(image_110);
						this.panneauxPanel.repaint();}
					valeurprec=110;
					break;}
					case 5:
						{if (valeurprec!=1)
							nbrdep=0;
							nbrdep++;
					if (nbrdep==3)
					{  nbrdep=0;
						System.out.println("Panneau interdiction de dépasser détécté");
						this.panneauxPanel.setImage(image_stop);
						this.panneauxPanel.repaint();}
					valeurprec=1;
					break;}
						
						
						
					}
					
				}
				else {
					
				indice=MaBibliothequeTraitementImageEtendue.identifiepanneau_matching(objetrond);
				//System.out.println("indice max"+indice+"\n");
				switch(indice){
				case -1:System.out.println("Aucun panneau détécté");break;
				case 0:{
						if (valeurprec!=30)
						  nbr30=0;
					      nbr30++;
					//System.out.println("nbr 30= "+nbr30+"\n");
					if (nbr30==3)
					{  nbr30=0;
						System.out.println("Panneau 30 détécté");
						this.panneauxPanel.setImage(image_30);
						this.panneauxPanel.repaint();
						
						}
						
					valeurprec=30;
					break;
					}
				
				case 1:
					{if (valeurprec!=50)
					nbr50=0;
						nbr50++;
					//System.out.println("nbr 50= "+nbr50+"\n");
					if (nbr50==3)
					{  nbr50=0;
						System.out.println("Panneau 50 détécté");
						this.panneauxPanel.setImage(image_50);
						this.panneauxPanel.repaint();
						}
						
					valeurprec=50;
					break;}
				case 2:
				{   if (valeurprec!=70)
					nbr70=0;
					nbr70++;
				//System.out.println("nbr 70= "+nbr70+"\n");
				if (nbr70==3)
				{  nbr70=0;
					System.out.println("Panneau 70 détécté");
					this.panneauxPanel.setImage(image_70);
					this.panneauxPanel.repaint();
					}
				
				valeurprec=70;
				break;}
				case 3:
					{if (valeurprec!=90)
						nbr90=0;
						nbr90++;
				//System.out.println("nbr 90= "+nbr90+"\n");
				if (nbr90==3)
				{  nbr90=0;
					System.out.println("Panneau 90 détécté");
					this.panneauxPanel.setImage(image_90);
					this.panneauxPanel.repaint();
					}
				valeurprec=90;
				break;}
				case 4:
				{ if (valeurprec!=110)
					nbr110=0;
					nbr110++;
				//System.out.println("nbr 110= "+nbr110+"\n");
				if (nbr110==3)
				{  nbr110=0;
					System.out.println("Panneau 110 détécté");
					this.panneauxPanel.setImage(image_110);
					this.panneauxPanel.repaint();
					}
				valeurprec=110;
				break;}
				case 5:
					{if (valeurprec!=1)
						nbrdep=0;
						nbrdep++;
				if (nbrdep==3)
				{  nbrdep=0;
					System.out.println("Panneau interdiction de dépasser détécté");
					this.panneauxPanel.setImage(image_stop);
					this.panneauxPanel.repaint();
					}
				valeurprec=1;
				break;}
					
					
					
				}
				}	
			}
				//System.out.println("object rond n "+k+"\n");
			}


			this.image = new ImageIcon(MaBibliothequeTraitementImageEtendue.Mat2bufferedImage(frame));
			this.videoPanel.setImage(getFrame());
			this.videoPanel.repaint();
			//vidpanel.setIcon(image);
			//vidpanel.repaint();
			while(!this.continueVideo) {
				System.out.println("La vidéo est en pause");
			}
			}
	}
	public Image getFrame() {
		return this.image.getImage();
	}
	public void setPanel(VideoPanel panel, PanneauxPanel panneauxPanel) {
		this.videoPanel=panel;
		this.panneauxPanel=panneauxPanel;
	}
	public void initImage() throws IOException {
		 this.image_30=ImageIO.read(new File("panneaux/ref30.png"));
		 this.image_50=ImageIO.read(new File("panneaux/ref50.png"));
		 this.image_70 =ImageIO.read(new File("panneaux/ref70.png"));
		 this.image_90 =ImageIO.read(new File("panneaux/ref90.png"));
		 this.image_110 =ImageIO.read(new File("panneaux/ref110.png"));
		 this.image_stop =ImageIO.read(new File("panneaux/stop.png"));
	}
	public void restartVideo() {
		camera.set(Videoio.CAP_PROP_POS_FRAMES, 0);
	}
	public void changeFile(File fichier) {
		this.camera = new VideoCapture(fichier.getPath());
	}
	}






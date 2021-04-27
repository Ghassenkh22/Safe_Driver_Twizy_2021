import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import utilitaireAgreg.*;
public class AnalyseVideo {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	static Mat imag = null;

	public static void main(String[] args) {
		JFrame jframe = new JFrame("Detection de panneaux sur un flux vidéo");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel vidpanel = new JLabel();
		jframe.setContentPane(vidpanel);
		jframe.setSize(720, 480);
		jframe.setVisible(true);

		Mat frame =Highgui.imread("p8.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		
		//VideoCapture camera = new VideoCapture("video1.avi");
		Mat PanneauAAnalyser = null;

			//while (camera.read(frame)) {
			//A completer
		MaBibliothequeTraitementImageEtendue.afficheImage("Image testée", frame);
		Mat transformee=MaBibliothequeTraitementImageEtendue.transformeBGRversHSV(frame);
		//la methode seuillage est ici extraite de l'archivage jar du meme nom 
		Mat saturee=MaBibliothequeTraitementImageEtendue.seuillage(transformee, 6, 170, 110);
		Mat objetrond = null;

		//Création d'une liste des contours à partir de l'image saturée
		List<MatOfPoint> ListeContours= MaBibliothequeTraitementImageEtendue .ExtractContours(saturee);
		System.out.println("nbr contour"+ListeContours.size()+"\n");
		int i=0;
		int k=0;
		int indice;
		double [] scores=new double [6];
		//Pour tous les contours de la liste
		for (MatOfPoint contour: ListeContours  ){
			i++;
			objetrond=MaBibliothequeTraitementImageEtendue.DetectForm(frame,contour);
			
			if (objetrond!=null){
				
				indice=MaBibliothequeTraitementImageEtendue.identifiepanneau(objetrond);
				//System.out.println("indice max"+indice+"\n");
				switch(indice){
				case -1:;break;
				case 0:System.out.println("Panneau 30 détécté");break;
				case 1:System.out.println("Panneau 50 détécté");break;
				case 2:System.out.println("Panneau 70 détécté");break;
				case 3:System.out.println("Panneau 90 détécté");break;
				case 4:System.out.println("Panneau 110 détécté");break;
				case 5:System.out.println("Panneau interdiction de dépasser détécté");break;
				}
				}	
				
				//System.out.println("object rond n "+k+"\n");
			}


			ImageIcon image = new ImageIcon(MaBibliothequeTraitementImageEtendue.Mat2bufferedImage(frame));
			vidpanel.setIcon(image);
			vidpanel.repaint();
		}
	//}





}
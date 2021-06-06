package test_pan;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import classes.MaBibliothequeTraitementImageEtendue;

public class test {

	

	@Test
	public void testp1(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p1.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("70"));
		
	
	}
	@Test
	public void testp2(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p2.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("70"));
		
	
	}
	@Test
	public void testp3(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p3.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("110"));
		
	
	}
	@Test
	public void testp4(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p4.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("30"));
		
	
	}
	@Test
	public void testp5(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p5.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("110"));
		
	
	}
	@Test
	public void testp6(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p6.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("30"));
		
	
	}
	@Test
	public void testp7(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p7.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("50"));
		
	
	}
	@Test
	public void testp8(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p8.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("90"));
		
	
	}
	@Test
	public void testp9(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p9.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("30"));
		
	
	}
	@Test
	public void testp10() {
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p10.jpg")	;
		String comp=val.get(0);
		String comp2=val.get(1);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("30"));
		assertTrue(comp2.equalsIgnoreCase("intdep"));
	
	}

	

	@Test
	public void testp13(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p13.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("90"));
		
	
	}
	@Test
	public void testp14(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p14.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("50"));
		
	
	}
	
	@Test
	public void testp15(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p15.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("110"));
		
	
	}
	
	@Test
	public void testp16(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p16.jfif")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("30"));
		
	
	}

	@Test
	public void testp18(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p18.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("50"));
		
	
	}
	
	

		
	
	

	@Test
	public void testp27(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p27.jpg")	;
		String comp=val.get(0);
		String comp2=val.get(1);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("90"));
		assertTrue(comp2.equalsIgnoreCase("90"));
		
	
	}

	@Test
	public void testp29(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p29.jpg")	;
		String comp=val.get(0);
		
		assertTrue(comp.equalsIgnoreCase("50"));
		
	
	}
	@Test
	public void testp30(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p30.png")	;
		String comp=val.get(0);
		
		assertTrue(comp.equalsIgnoreCase("50"));
	}
		@Test
		public void testp31(){
			ArrayList<String> val=new ArrayList<String>();
			val=MaBibliothequeTraitementImageEtendue.etu_pan("p31.jpg")	;
			String comp=val.get(0);
		
			assertTrue(comp.equalsIgnoreCase("50"));}
			@Test
			public void testp32(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p32.jpg")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("30"));
				
			
			}
		
		
			@Test
			public void testp35(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p35.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("90"));
			}
			@Test
			public void testp36(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p36.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("110"));
			}
			@Test
			public void testp37(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p37.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("90"));
			}
		
		
		
			@Test
			public void testp42(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p42.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("50"));
			}
	
			@Test
			public void testp44(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p44.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("70"));
			}
		
			@Test
			public void testp46(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p46.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("70"));
			}
			@Test
			public void testp47(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p47.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("90"));
			}
			@Test
			public void testp48(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p48.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("50"));
			}
			@Test
			public void testp49(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p49.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("30"));
			}
			@Test
			public void testp50(){
				ArrayList<String> val=new ArrayList<String>();
				val=MaBibliothequeTraitementImageEtendue.etu_pan("p50.png")	;
				String comp=val.get(0);
				
				assertTrue(comp.equalsIgnoreCase("50"));
			}
}

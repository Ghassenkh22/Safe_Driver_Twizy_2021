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
	public void testp11(){
		ArrayList<String> val=new ArrayList<String>();
		val=MaBibliothequeTraitementImageEtendue.etu_pan("p11.jpg")	;
		String comp=val.get(0);
		System.out.println(comp);
		assertTrue(comp.equalsIgnoreCase("90"));
		
	
	}
	

}

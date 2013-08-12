package com.dovgan.test;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.dovgan.model.Person;


public class TestPerson {

	@Test
	public void testConstructor1() {
		Person p1 = new Person();
		Person p2 = new Person();
		assertEquals(p1, p2);
		Person p3 = new Person("Surname", "Name");
		Person p4 = new Person("Surname", "DiffName");
		assertFalse(p3.equals(p4));
	}
	
	@Test
	public void testConstructor2(){
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		try {
			Person p5 = new Person("Sur", "Name", format.parse("01/01/80"),'m');
			Person p6 = new Person(p5);
			assertEquals(p5, p6);
			assertTrue(p5.isCorrect());
			p6.setBirth(null);
			assertFalse(p6.isCorrect());
		} catch (ParseException e) {
			System.out.println("Problems with date");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCorrectStrings(){
		Person p7 = new Person();
		assertTrue(p7.isCorrect());
		Person p8 = new Person("\t", "Name");
		assertFalse(p8.isCorrect());
		Person p9 = new Person("Surname", " ");
		assertFalse(p9.isCorrect());
	}
	
	@Test
	public void testCorrectDate(){
		try {
			Person p10 = new Person();
			DateFormat format = new SimpleDateFormat("dd/mm/yy");
			p10.setBirth(format.parse("01/01/1969"));
			assertFalse(p10.isCorrect());
			p10.setBirth(null);
			assertFalse(p10.isCorrect());
			p10.setBirth(format.parse("01/01/1970"));
			assertTrue(p10.isCorrect());
		} catch (ParseException e) {
			System.out.println("Problems with date");
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testSex(){
		Person p11 = new Person("S","N");
		assertTrue(p11.isCorrect());
		p11.setSex('q');
		assertFalse(p11.isCorrect());
		p11.setSex('f');
		assertTrue(p11.isCorrect());
	}

}

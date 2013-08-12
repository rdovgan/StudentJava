package com.dovgan.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dovgan.model.Person;
import com.dovgan.model.PersonContainer;

public class TestPersonContainer {

	public PersonContainer initList() {
		Person p1 = new Person();
		Person p2 = new Person();
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		PersonContainer pc = new PersonContainer(list);
		return pc;
	}

	public PersonContainer initBigList() {
		Person p1 = new Person("Surname1", "Name2");
		Person p2 = new Person("Surname2", "Name2");
		p2.setSex('f');
		Person p3 = new Person("Surname1", "Name1");
		Person p4 = new Person("Surname1", "Name0");
		Person p5 = new Person("Surname1", "Name1");
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		PersonContainer pc = new PersonContainer(list);
		return pc;
	}

	@Test
	public void testConstructor() {
		PersonContainer pc = new PersonContainer();
		assertNotNull(pc.getList());
		pc.setList(null);
		assertNull(pc.getList());
	}

	@Test
	public void testConstructor2() {
		PersonContainer pc = initList();
		assertNotNull(pc.getList());
		Person p1 = new Person("Surname", "Name");
		p1.setSex('f');
		assertTrue(pc.add(p1));
		Person p2 = new Person();
		p2.setSurname("Surname");
		p2.setName("Name");
		assertTrue(pc.remove(p2));
	}

	@Test
	public void testGetters() {
		PersonContainer pc = initList();
		Person p = new Person("Sur", "Nam");
		pc.add(p);
		Person p2 = new Person(p);
		assertEquals(pc.get(p), p2);
		assertFalse(pc.getId(p) == p2.getId());
		assertTrue(pc.getId(p) == p.getId());
	}

	@Test
	public void testListBySurname() {
		PersonContainer pc = initBigList();
		List<Person> list = pc.getBySurname("Surname1");
		assertTrue(list.size() == 4);
		for (Person temp : list)
			assertTrue(temp.getSurname() == "Surname1");
	}

	@Test
	public void testListBySex() {
		PersonContainer pc = initBigList();
		List<Person> list = pc.getBySex('m');
		assertTrue(list.size() == 4);
		for (Person temp : list)
			assertTrue(temp.getSex() == 'm');
		list = pc.getBySex('f');
		assertTrue(list.size() == 1);
		for (Person temp : list)
			assertTrue(temp.getSex() == 'f');
	}
}

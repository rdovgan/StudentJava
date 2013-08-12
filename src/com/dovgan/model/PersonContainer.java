package com.dovgan.model;

import java.util.ArrayList;
import java.util.List;

public class PersonContainer {
	List<Person> list = null;

	public PersonContainer() {
		list = new ArrayList<Person>();
	}

	public PersonContainer(List<Person> newList) {
		if (newList != null)
			list = newList;
	}

	public List<Person> getList() {
		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}

	public boolean add(Person person){
		return list.add(person);
	}
	
	public boolean remove(Person person){
		for(Person temp: list){
			if(temp.equalsName(person))
				return list.remove(temp);
		}
		return false;
	}
	
	public Person removeById(long id){
		for (Person temp : list) {
			if (temp.getId() == id) {
				list.remove(temp);
				return temp;
			}
		}
		return null;
	}
	
	public Person getById(long id){
		for (Person temp : list) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}
	
	public Person get(Person person){
		for (Person temp : list) {
			if (person.equalsName(temp)) {
				return temp;
			}
		}
		return null;
	}
	
	public long getId(Person person){
		for(Person temp:list){
			if(temp.equalsName(person))
				return temp.getId();
		}
		return 0;
	}
	
	public List<Person> getBySurname(String surname){
		List<Person> newList = null;
		for (Person temp : list) {
			if (temp.getSurname() == surname) {
				if (newList == null)
					newList = new ArrayList<Person>();
				newList.add(temp);
			}
		}
		return newList;
	}
	
	public List<Person> getBySex(char sex){
		List<Person> newList = null;
		for (Person temp : list) {
			if (temp.getSex() == sex) {
				if (newList == null)
					newList = new ArrayList<Person>();
				newList.add(temp);
			}
		}
		return newList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonContainer other = (PersonContainer) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
	
}

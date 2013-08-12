package com.dovgan.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.dovgan.compare.SortedByBirth;
import com.dovgan.compare.SortedBySurname;
import com.dovgan.model.Person;
import com.dovgan.model.PersonContainer;


public class PersonCollection implements IPersonCollection {

	PersonContainer data;

	public PersonCollection() {
		data = new PersonContainer();
	}

	public PersonCollection(List<Person> newList) {
		data = new PersonContainer(newList);
	}

	public static boolean isCorrect(Person person) {
		if (person == null)
			return false;
		Date dateBefore = new Date(0);
		Date dateAfter = new Date();
		if ((person.getSurname() == "") || (person.getName() == "")
				|| (person.getBirth().before(dateBefore))
				|| (person.getBirth().after(dateAfter))
				|| ((person.getSex() != 'm') && (person.getSex() != 'f')))
			return false;
		return true;
	}

	@Override
	public boolean add(Person newPerson) {
		if (isCorrect(newPerson)) {
			data.add(newPerson);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Person person) {
		if (isCorrect(person)) {
			data.remove(person);
			return true;
		}
		return false;
	}

	@Override
	public Person removeById(long id) {
		return data.removeById(id);
	}

	@Override
	public boolean change(Person newPerson, Person oldPerson) {
		if (isCorrect(oldPerson) && isCorrect(newPerson)) {
			data.remove(oldPerson);
			data.add(newPerson);
		}
		return false;
	}

	@Override
	public boolean changeById(Person newPerson, long id) {
		if (isCorrect(newPerson)) {
			removeById(id);
			data.add(newPerson);
		}
		return false;
	}

	@Override
	public Person getById(long id) {
		return data.getById(id);
	}

	@Override
	public Person get(Person person) {
		return data.get(person);
	}

	@Override
	public List<Person> getBySurname(String surname) {
		return data.getBySurname(surname);
	}

	@Override
	public List<Person> getBySex(char sex) {
		return data.getBySex(sex);
	}

	@Override
	public boolean sortedBySurname() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedBySurname());
		return true;
	}

	@Override
	public boolean sortedByBirth() {
		if (data == null)
			return false;
		Collections.sort(data.getList(), new SortedByBirth());
		return true;
	}

	@Override
	public List<Person> getList() {
		return data.getList();
	}

}

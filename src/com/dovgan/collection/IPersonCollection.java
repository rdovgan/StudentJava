package com.dovgan.collection;

import java.util.List;

import com.dovgan.model.Person;

public interface IPersonCollection {

	public boolean add(Person newPerson);

	public boolean remove(Person person);

	public Person removeById(long id);

	public boolean change(Person newPerson, Person oldPerson);

	public boolean changeById(Person newPerson, long id);

	public Person getById(long id);

	public Person get(Person person);

	public List<Person> getBySurname(String surname);

	public List<Person> getBySex(char sex);

	public boolean sortedBySurname();

	public boolean sortedByBirth();

	public List<Person> getList();
}

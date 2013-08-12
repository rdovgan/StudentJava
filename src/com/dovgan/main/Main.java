package com.dovgan.main;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dovgan.model.Person;
import com.dovgan.collection.PersonCollection;

public class Main {
	
	static PersonCollection persons = new PersonCollection();

	@SuppressWarnings("resource")
	public static Person inputPerson() throws ParseException {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] strArr = line.split(" ");
		if(strArr.length!=4){
			System.out.println("!!!Wrong line. Try again.");
			return inputPerson();
		}
		String surname = strArr[0];
		String name = strArr[1];
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		Date date = format.parse(strArr[2]);
		char sex = strArr[3].charAt(0);
		Person person = new Person(surname, name, date, sex);
		return person;
	}

	public static void outputPerson(Person person) {
		Format format = new SimpleDateFormat("dd/mm/yy");
		System.out.println(person.getSurname() + "\t\t"
				+ person.getName() + "\t\t" + format.format(person.getBirth()) + "\t"
				+ person.getSex());
	}
	
	public static void outputList(List<Person> list){
		for(Person temp : list){
			outputPerson(temp);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) throws ParseException {
		System.out.print("Input number of students: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Input "+n+" persons (surname, name, birth(dd/mm/yy), sex(m/f)):");
		for(int i=0; i<n; i++){
			Person newPerson = inputPerson();
			persons.add(newPerson);
		}
		System.out.println("\nSorted by surname:");
		persons.sortedBySurname();
		outputList(persons.getList());
		System.out.println("\nSorted by birth:");
		persons.sortedByBirth();
		outputList(persons.getList());		
		
	}
}

package proj;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static StudentCollectionImpl students = new StudentCollectionImpl();

	@SuppressWarnings("resource")
	public static Student inputStudent() throws ParseException {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] strArr = line.split(" ");
		if(strArr.length!=6){
			System.out.println("!!!Wrong line. Try again.");
			return inputStudent();
		}
		String surname = strArr[0];
		String name = strArr[1];
		int group = Integer.parseInt(strArr[2]);
		double mark = Double.parseDouble(strArr[3]);
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		Date date = format.parse(strArr[4]);
		char sex = strArr[5].charAt(0);
		Student student = new Student(surname, name, group, mark, date, sex);
		return student;
	}

	public static void outputStudent(Student student) {
		Format format = new SimpleDateFormat("dd/mm/yy");
		System.out.println(student.getSurname() + "\t\t"
				+ student.getName() + "\t\t" + student.getGroup() + "\t"
				+ student.getMark() + "\t" + format.format(student.getBirth()) + "\t"
				+ student.getSex());
	}
	
	public static void outputList(List<Student> list){
		for(Student temp : list){
			outputStudent(temp);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) throws ParseException {
		System.out.print("Input number of students: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Input "+n+" students (surname, name, group, mark, birth(dd/mm/yy), sex(m/f)):");
		for(int i=0; i<n; i++){
			Student newStudent = inputStudent();
			students.addStudent(newStudent);
		}
		System.out.println("\nSorted by surname:");
		students.sortedBySurname();
		outputList(students.getList());
		System.out.println("\nSorted by birth:");
		students.sortedByBirth();
		outputList(students.getList());
		System.out.println("\nSorted by mark:");
		students.sortedByMark();
		outputList(students.getList());
		System.out.println("\nSorted by group:");
		students.sortedByGroup();
		outputList(students.getList());
		
		
	}
}

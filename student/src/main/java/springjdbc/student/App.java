package springjdbc.student;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.dao.StudentOperations;
import com.student.pojo.Student;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome TO The Spring Core Application !");

		Scanner sc = new Scanner(System.in);
		while (true) {
			ApplicationContext context = new ClassPathXmlApplicationContext("com/student/dbutil/studentConfig.xml");
			StudentOperations studentDao = context.getBean("studentDao", StudentOperations.class);

			Student s1 = new Student();
			System.out.println("Select an option which you want to perform !");
			System.out.println("1 for Addition");
			System.out.println("2 for Deletion");
			System.out.println("3 for Update");
			System.out.println("4 for Show All details");

			int ans = sc.nextInt();

			if (ans == 1) {
				System.out.println("Enter Details of the student :-");
				System.out.println("Id");
				int id = sc.nextInt();
				System.out.println("First Name");
				String fname = sc.next();
				System.out.println("Last Name");
				String lname = sc.next();
				System.out.println("Course:");
				String course = sc.next();

				s1.setId(id);
				s1.setFname(fname);
				s1.setLname(lname);
				s1.setCourse(course);

				int result = studentDao.addStudent(s1);
				if (result > 0) {

					System.out.println("Record Added..." + result);
					pressAnyKeyToContinue(sc);

				}

			}

			if (ans == 2) {
				System.out.println("Enter the id to delete the record ");

				int id = sc.nextInt();

				s1.setId(id);

				int result = studentDao.deleteStudent(id);
				if (result > 0) {

					System.out.println("Record Deleted..." + result);
					pressAnyKeyToContinue(sc);
				}

			}

			if (ans == 3) {
				System.out.println("Enter the id to update the record  ");

				int id = sc.nextInt();

				s1.setId(id);

				System.out.println("First Name");
				String fname = sc.next();
				System.out.println("Last Name");
				String lname = sc.next();
				System.out.println("Course:");
				String course = sc.next();

				s1.setFname(fname);
				s1.setLname(lname);
				s1.setCourse(course);

				int result = studentDao.updateStudent(s1);
				if (result > 0) {

					System.out.println("Record Updated..." + result);
					pressAnyKeyToContinue(sc);
				}

			}

			if (ans == 4) {
				System.out.println("All students list :");

				List<Student> allStudentList = studentDao.showAllStudent();

				if (allStudentList != null) {

					for (Student s : allStudentList) {

						System.out.println(s);
					}
					pressAnyKeyToContinue(sc);
				}

			}

			System.out.println("Press 'Q' to quit or any other key to continue:");
			char userInput = sc.next().charAt(0);

			if (userInput == 'Q' || userInput == 'q') {
				System.out.println("Exiting the program. Goodbye!");
				break;
			}

		}
		sc.close();

	}

	private static void pressAnyKeyToContinue(Scanner scanner) {
		System.out.println("Press any key to continue...");
		scanner.nextLine(); // Consume the newline character from the previous input
		scanner.nextLine(); // Wait for any key press
	}

}

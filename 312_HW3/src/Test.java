public class Test {

	public static void main(String[] args) {
		Professor p1 = new Professor(1111, "Mr. Suresh", "CSE");
		System.out.println(p1);
		p1.createUsername();
		p1.createPassword();
		Professor p2 = new Professor(2222, "Dr. Imran", "CSE");
		System.out.println(p2);
		p2.createUsername();
		p2.createPassword();
		Student s1 = new Student(3333, "Mohammad", "CSE");
		System.out.println(s1);
		s1.createUsername();
		s1.createPassword();
		Student s2 = new Student(4444, "Ali", "CSE");
		System.out.println(s2);
		s2.createUsername();
		s2.createPassword();
		Student s3 = new Student(4555, "Ahmed", "CSE");
		System.out.println(s3);
		s3.createUsername();
		s3.createPassword();
		
	}

}

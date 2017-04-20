package by.htp.Vector;

public class Main {

	public static void main(String[] args) {
		workWithMyVector();
	}

	private static void workWithMyVector() {
		MyVictor<Person> vector = new MyVictor<Person>(11);
		vector.add(new Person("Vasya1", 18));
		vector.add(new Person("Petya2", 21));
		vector.remove(1);
		vector.add(new Person("Vasya3", 18));
		Person person = new Person("Petya4", 21);
		vector.trimToSize();
		Person person2 = new Person("Petddd", 21);
		vector.clear();
		vector.add(person);
		vector.ensureCapacity(1);
		vector.add(new Person("Vasya5", 18));
		vector.add(person);
		vector.add(0, person);
		vector.remove(person2);
		vector.set(2, new Person("Vasya5555", 28));
		System.out.println(vector.indexOf(new Person("Vasya5", 18)));
		System.out.println(vector.contains(new Person("Vasya878", 18)));
		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		}
		System.out.println("-------------------------------------------------------------------------");
		Person[] pers = new Person[5];
		pers = vector.toArray(pers);
		for (int i = 0; i < pers.length; i++) {
			if (pers[i] != null) {
				System.out.println(pers[i]);
			}
		}
	}
}

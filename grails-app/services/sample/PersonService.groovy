package sample

class PersonService {

    Person createPerson(String firstName, String lastName, int age) {
		Person p = new Person()
		p.firstName = firstName
		p.lastName = lastName
		p.age = age
		p.dateOfBirth = new Date();
//		p.dateOfBirth = dateOfBirth
		p.save()
		
		return p

    }
}

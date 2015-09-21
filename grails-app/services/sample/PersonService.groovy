package sample

class PersonService {

    Person createPerson(String firstName, String lastName, int age, double totalAmount) {
		Person p = new Person()
		p.firstName = firstName
		p.lastName = lastName
		p.age = age
		p.dateOfBirth = new Date()
		p.totalAmount = totalAmount
//		p.dateOfBirth = dateOfBirth
		p.save()
		
		return p

    }
	
	Person[] listPerson(){
		
		return Person.list()
		
	}
}

package sample

//bean used to the db persistence
//in this case, the controller will generates the bean objects statically
class Person {
	String firstName
	String lastName
	int age
	Date dateOfBirth
	double totalAmount
	
	static constraints = {
		firstName (blank : false)
		lastName (blank : false)
		age (blank : false)
		totalAmount (blank : false)
		
	}
}

package sample

import javax.swing.text.View;

class HelloController {

	//	sample/index -> index.gsp
    def index() { 
		def personList = [] //this list must be filled by db access
		Person john = new Person(firstName: 'John', lastName:'Doe', age:55)
		Person mike = new Person(firstName: 'Mike', lastName:'de Pablo', age:24)
		Person cristina = new Person(firstName: 'Chris', lastName:'Sanz', age:23)
		personList<<john<<mike<<cristina
		[personList:personList]
//		Person person = new Person(firstName: 'John', lastName:'Doe', age:55)
//		[ person:person ]
	}
	
	//	sample/index/hi 
	def hi(){
		//if we comment render, the controller will return the index.gsp view
		render(view:'index.gsp')
	}
	
	def displayForm(){
		Person personSample = new Person(age:30)
		[personSample : personSample]
		
	}
	
	
	
}

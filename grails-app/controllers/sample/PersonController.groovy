package sample

class PersonController {
	
	static scaffold = true
	def personService
	
	def form(){

	}
	
//	def save(){
//		def person = new Person(params)
//		person.save()
////		render (view : 'index.gsp')
//		redirect (controller : "hello", action : "index" )
//		
//	}	
	
	
	def save(){
		def person = personService.createPerson(params.firstName,params.lastName,Integer.parseInt(params.age))
//		render (view : 'index.gsp')
		redirect (controller : "hello", action : "index" )
		
	}
	
}

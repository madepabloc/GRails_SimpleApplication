package sample

class PersonController {
	
	static scaffold = true
	
	
	def form(){

	}
	
	def save(){
		def person = new Person(params)
		person.save()
//		render (view : 'index.gsp')
		redirect (controller : "hello", action : "index" )
		
	}	
	
}

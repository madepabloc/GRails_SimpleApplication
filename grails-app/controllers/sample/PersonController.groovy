package sample

class PersonController {
	def form(){

	}
	
	def save(){
		def person = new Person(params)
		person.save()
//		render (view : 'index.gsp')
		redirect (controller : "hello", action : "index" )
		
	}	
	
}

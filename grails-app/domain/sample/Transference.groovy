package sample

class Transference {
	Person payer
	Person beneficiary 
	double amount
	
    static constraints = {
		payer (blank : false)
		beneficiary (blank : false)
		amount (blank:false)
	}
}

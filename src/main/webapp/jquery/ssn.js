$(document).ready(function() {
	
	/**
	 * Custom Validator method 
	 */
	$.validator.addMethod("noSpace", function(value, element) {
		return value == '' || value.trim().length != 0
	}, "Spaces are not allowed");

	/*jQuery.validator.addMethod("customEmail", function(value, element) { 
		  return this.optional( element ) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test( value ); 
		}, "Please enter valid email address!");*/
	
	
	/**
	 * Validations
	 */
	$("#ssnreg").validate({
		rules : {
			firstName : {
				required : true,
				noSpace : true
			},
			lastName : {
				required : true,
				noSpace : true
			},
			dob :{
				required :true,
				noSpace:true
				
			},
			gender :{
				required :true,
				noSpace: true
				
			},
			
			phNo : {
				required : true,
				minlength:9,
				  maxlength:12,
				  number: true
			},
			
			state :{
				required:true,
				
				
			},
			
			
		},

		messages : {
			firstName : {
				required : 'Please Enter Your FirstName'
			},
			lastName : {
				required : 'Please Enter Your LastName'
			},
			dob :{
				required :'Please Select DOB number'
			},
			
			gender : {
				required : 'Select Your Gender'
			},
			phNo :{
				required:'Please Enter Phone number'
			},
			state:{
				required:'select your state'
			},
			image:{
				required:'Select image'
			},
			
		},

	})
})

function doValidation(frm){
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptErr").innerHTML="";
	
	let name = frm.name.value;
	let desg = frm.job.value;
	let salary = frm.salary.value;
	let deptno = frm.dept.vale;
	
	let isValid=true;
	if(name=""){
		document.getElementById("nameErr").innerHTML="Employee name is mandatory";
		isValid=false;
	}else if(name.length <5 || name.length<= 15){
		document.getElementById("nameErr").innerHTML="Employee name must contain  >=5 chars and <=15";
		isValid=false;
	}
	if(desg=""){
		document.getElementById("jobErr").innerHTML="Employee job is mandatory";
		isValid=false;
	}else if(desg.length <5 || desg.length<= 15){
		document.getElementById("jobErr").innerHTML="Employee job must contain  >=5 chars and <=15";
		isValid=false;
	}
	if(salary=""){
		document.getElementById("salErr").innerHTML="Employee salary is mandatory";
		isValid=false;
	}else if(salary.isNaN(salary)){
		document.getElementById("salErr").innerHTML="Employee salary is numeric valuey";
		isValid=false;
		
	}
	else if(salary<=10000 || salary >=100000){
		document.getElementById("salErr").innerHTML="Employee salary must be there in the range of 10000 to 100000";
		isValid=false;
	}
	if(deptno=""){
		document.getElementById("deptErr").innerHTML="Employee Department is Mandatory";
		isValid=false;
	}
	return isValid;
}

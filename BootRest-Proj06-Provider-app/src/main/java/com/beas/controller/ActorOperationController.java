package com.beas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beas.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationController {
	@GetMapping("/wish")
	public ResponseEntity<String> diplayWishMessage(){
		
		return new ResponseEntity<String>("Good Morining",HttpStatus.OK);
	}
	@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showMessage(@PathVariable Integer no,@PathVariable String name){

		return new ResponseEntity<String>(no+"  "+name,HttpStatus.OK);
	}
	@GetMapping("/repport1")
	public ResponseEntity<Actor> fetchActor(){
		Actor actor = new Actor(10056, "Ram", 45, 4000000.11, "hero");
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		
		return new ResponseEntity<String>("Actor Data "+actor.toString(),HttpStatus.OK);
	}
}

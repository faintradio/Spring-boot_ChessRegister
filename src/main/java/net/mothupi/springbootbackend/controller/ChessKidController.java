package net.mothupi.springbootbackend.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mothupi.springbootbackend.model.ChessKid;
import net.mothupi.springbootbackend.service.ChessKidService;

@RestController
@RequestMapping("/api/employees")
public class ChessKidController {
	
	private ChessKidService chessKidService;

	public ChessKidController(ChessKidService chessKidService) {
		super();
		this.chessKidService = chessKidService;
	}
	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<ChessKid> saveEmployee(@RequestBody ChessKid chessKid){
		return new ResponseEntity<ChessKid>(chessKidService.saveEmployee(chessKid), HttpStatus.CREATED);
	}
	
	// build get all employees REST API
	@GetMapping
	public List<ChessKid> getAllEmployees(){
		return chessKidService.getAllEmployees();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<ChessKid> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<ChessKid>(chessKidService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	// build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<ChessKid> updateEmployee(@PathVariable("id") long id
												  ,@RequestBody ChessKid chessKid){
		return new ResponseEntity<ChessKid>(chessKidService.updateEmployee(chessKid, id), HttpStatus.OK);
	}
	
	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		// delete employee from DB
		chessKidService.deleteEmployee(id);
		
		return new ResponseEntity<String>("ChessKid deleted successfully!.", HttpStatus.OK);
	}
	
}
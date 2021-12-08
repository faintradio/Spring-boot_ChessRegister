package net.mothupi.springbootbackend.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.mothupi.springbootbackend.exception.ResourceNotFoundException;
import net.mothupi.springbootbackend.model.ChessKid;
import net.mothupi.springbootbackend.repository.ChessKidRepository;
import net.mothupi.springbootbackend.service.ChessKidService;

@Service
public class ChessKidServiceImpl implements ChessKidService{

	private ChessKidRepository chessKidRepository;
	
	public ChessKidServiceImpl(ChessKidRepository chessKidRepository) {
		super();
		this.chessKidRepository = chessKidRepository;
	}

	@Override
	public ChessKid saveEmployee(ChessKid chessKid) {
		return chessKidRepository.save(chessKid);
	}

	@Override
	public List<ChessKid> getAllEmployees() {
		return chessKidRepository.findAll();
	}

	@Override
	public ChessKid getEmployeeById(long id) {
//		Optional<ChessKid> employee = chessKidRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("ChessKid", "Id", id);
//		}
		return chessKidRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("ChessKid", "Id", id));
		
	}

	@Override
	public ChessKid updateEmployee(ChessKid chessKid, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		ChessKid existingEmployee = chessKidRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("ChessKid", "Id", id)); 
		
		existingEmployee.setFirstName(chessKid.getFirstName());
		existingEmployee.setLastName(chessKid.getLastName());
		existingEmployee.setEmail(chessKid.getEmail());
		// save existing employee to DB
		chessKidRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		chessKidRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("ChessKid", "Id", id));
		chessKidRepository.deleteById(id);
	}
	
}
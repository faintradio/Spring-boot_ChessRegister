package net.mothupi.springbootbackend.service;

import java.util.List;

import net.mothupi.springbootbackend.model.ChessKid;

public interface ChessKidService {
	ChessKid saveEmployee(ChessKid chessKid);
	List<ChessKid> getAllEmployees();
	ChessKid getEmployeeById(long id);
	ChessKid updateEmployee(ChessKid chessKid, long id);
	void deleteEmployee(long id);
}
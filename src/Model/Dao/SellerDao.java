package Model.Dao;

import java.util.List;

import Model.Entities.Department;
import Model.Entities.Seller;

public interface SellerDao { //Objeto responsavel por fazer o acesso ao banco de dados

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}

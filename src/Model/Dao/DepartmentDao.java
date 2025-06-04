package Model.Dao;

import java.util.List;

import Model.Entities.Department;

public interface DepartmentDao { //Objeto responsavel por fazer o acesso ao banco de dados

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}

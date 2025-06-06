package Model.Dao;

import Model.Dao.Impl.DepartmentDaoJDBC;
import Model.Dao.Impl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {//classe auxiliar responsável por instanciar os Dao's, operações estáticas 

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
}

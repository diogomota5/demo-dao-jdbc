package Model.Dao;

import Model.Dao.Impl.SellerDaoJDBC;

public class DaoFactory {//classe auxiliar responsável por instanciar os Dao's, operações estáticas 

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}

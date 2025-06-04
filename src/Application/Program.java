package Application;

import java.util.Date;

import Model.Dao.DaoFactory;
import Model.Dao.SellerDao;
import Model.Entities.Department;
import Model.Entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Book");
		Seller seller = new Seller(21,"Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);

	}

}

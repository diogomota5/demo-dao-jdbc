package Application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Model.Dao.DaoFactory;
import Model.Dao.DepartmentDao;
import Model.Dao.SellerDao;
import Model.Entities.Department;
import Model.Entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId() ); 
		
		System.out.println("\n=== TEST 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: Seller Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 7: Department Insert ===");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);;
		System.out.println("Inserted! New id = " + newDepartment.getId() ); 
		
		System.out.println("\n=== TEST 8: Department findById ===");
		department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 9: Department Update ===");
		department = departmentDao.findById(1);
		department.setName("Course");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 10: Department Delete ===");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 11: Department findAll ===");
		List <Department> list1 = departmentDao.findAll();
		for (Department d : list1) {
			System.out.println(d);
		}
		
		
		sc.close();
	}
}

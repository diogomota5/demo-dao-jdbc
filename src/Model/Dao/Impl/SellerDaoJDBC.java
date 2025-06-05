package Model.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Dao.SellerDao;
import Model.Entities.Department;
import Model.Entities.Seller;
import db.DB;
import db.DbException;

public class SellerDaoJDBC implements SellerDao { // responsável por implementar as operações da classe (SellerDao)

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					" Select seller.*, department.Name as DepName " + " from seller inner join department "
							+ " on seller.DepartamentId = department.Id " + " where seller.Id = ? " + "order by Name");

			st.setInt(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instatiateDeparment(rs);
				Seller obj = instatiateSeller(rs, dep);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"Select seller.*, department.Name as DepName " 
					+ "from seller inner join department "
					+ "on seller.DepartamentId = department.Id " 
					+ "order by Name");

			rs = st.executeQuery();

			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			while (rs.next()) {

				Department dep = map.get(rs.getInt("DepartamentId"));

				if (dep == null) {
					dep = instatiateDeparment(rs);
					map.put(rs.getInt("DepartamentId"), dep);
				}

				Seller obj = instatiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("Select seller.*, department.Name as DepName "
					+ "from seller inner join department " + "on seller.DepartamentId = department.Id "
					+ "where DepartamentId = ? " + "order by Name");

			st.setInt(1, department.getId());

			rs = st.executeQuery();

			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			while (rs.next()) {

				Department dep = map.get(rs.getInt("DepartamentId"));

				if (dep == null) {
					dep = instatiateDeparment(rs);
					map.put(rs.getInt("DepartamentId"), dep);
				}

				Seller obj = instatiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instatiateSeller(ResultSet rs, Department dep) throws SQLException {// propagando a excessão, esse é
																						// um método auxiliar
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("Birthdate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instatiateDeparment(ResultSet rs) throws SQLException { // propagando a excessão, esse é um
																				// método auxiliars
		Department dep = new Department();
		dep.setId(rs.getInt("DepartamentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

}

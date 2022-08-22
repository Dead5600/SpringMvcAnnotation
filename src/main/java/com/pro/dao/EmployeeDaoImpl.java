package com.pro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory factory = null;
	private Session session;

	@Override
	public boolean saveEmployee(EmployeeEntity entity) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(entity);

			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public EmployeeEntity getEmployeeById(int Id) {
		Session session = null;
		try {
			session = factory.openSession();

			return session.get(EmployeeEntity.class, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		Session session = null;
		try {
			session = factory.openSession();

			return session.createQuery("from EmployeeEntity").list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateEmployee(EmployeeEntity entity, int Id) {
		session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String s = "update EmployeeEntity set name=:name, salary=:salary where Emp_Id=:id";// Emp_Id
			Query q = session.createSQLQuery(s);
			q.setParameter("name", entity.getName());
			q.setParameter("salary", entity.getSalary());
			q.setParameter("id", Id);

			q.executeUpdate();

			session.getTransaction().commit();
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteEmployee(int Id) {

		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			EmployeeEntity e1 = session.get(EmployeeEntity.class, Id);
			session.delete(e1);
			tx.commit();
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}

	}

}

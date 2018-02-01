package com.github.pabloo99.dao;

import com.github.pabloo99.connection.HibernateUtil;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j
public class DepartmentDao {

    public Integer countEmployeesByDepartmentId(int departmentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("SELECT COUNT(*) AS count " +
                    " FROM Employee AS emp " +
                    " JOIN Department AS dep ON dep.id = emp.department.id " +
                    " WHERE dep.id = :department_id");
            query.setParameter("department_id", departmentId);

            Long resultLong = (Long) query.getSingleResult();
            transaction.commit();

            return resultLong.intValue();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return 0;
    }
}

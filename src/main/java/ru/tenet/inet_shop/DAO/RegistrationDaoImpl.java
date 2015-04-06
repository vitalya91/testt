package ru.tenet.inet_shop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tenet.inet_shop.model.Registration;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@Repository("RegistrationDao")
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

  @Resource(name="sessionFactory")
  SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @SuppressWarnings("unchecked")
    @Override
    public List<Registration> getList() throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Registration> List = session.createCriteria(Registration.class)
                .list();

        tx.commit();
        session.close();
        return List;
    }


    @Override
    public boolean insertData(Registration registration) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(registration);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public int insertRow(Registration employee) throws Exception{
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer) id;
    }

    @Override
    public Registration getRowById(int id) throws Exception {
        Session session = sessionFactory.openSession();

        Registration employee = null;
        try{
        Transaction tx = session.beginTransaction();
         employee = (Registration) session.get(Registration.class, id);
        tx.commit();
        } catch (Exception e){e.getMessage();}
        session.close();
        return employee;
    }


    @Override
    public Registration findByUserName(String username) throws Exception {
        Session session = sessionFactory.openSession();

        Registration employee = null;
        try{
            Transaction tx = session.beginTransaction();
            employee = (Registration) session.createCriteria(Registration.class).add(Restrictions.eq("username",username))
                    .uniqueResult();
            tx.commit();
        } catch (Exception e) {e.getMessage();}
        session.close();
        return employee;
    }

    @Override
    public int updateRow(Registration employee) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Registration employee = (Registration) session.load(Registration.class, id);
        session.delete(employee);
        tx.commit();
        Serializable ids = session.getIdentifier(employee);
        session.close();
        return (Integer) ids;
    }

}

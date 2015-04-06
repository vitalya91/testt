package ru.tenet.inet_shop.service;

import org.hibernate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tenet.inet_shop.DAO.RegistrationDao;
import ru.tenet.inet_shop.model.Registration;

import java.util.List;

/**
 * Created by pivovarov.v on 24.03.15.
 */

@org.springframework.stereotype.Service("service")
@Transactional
public class ServiceImpl implements Service{

        @Autowired
        private RegistrationDao registrationDao;


        @Override
        @Transactional(readOnly=true)
        public Registration send (Registration registration) throws Exception {

            registrationDao.insertData(registration);

            return registration;
        }


          @Override
          public List<Registration> getList() throws Exception {
          return registrationDao.getList();
    }

    @Override
    public int insertRow(Registration employee)throws Exception {
        return registrationDao.insertRow(employee);
    }


    @Override
    public Registration getRowById(int id)throws Exception {
        return registrationDao.getRowById(id);
    }

    @Override
    public int updateRow(Registration employee)throws Exception {
        return registrationDao.updateRow(employee);
    }

    @Override
    public int deleteRow(int id)throws Exception {
        return registrationDao.deleteRow(id);
    }

    @Override
    public Registration findByUserName(String username)throws Exception {
        return registrationDao.findByUserName(username);
    }
}

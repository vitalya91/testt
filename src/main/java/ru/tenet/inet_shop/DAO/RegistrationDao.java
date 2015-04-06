package ru.tenet.inet_shop.DAO;

import ru.tenet.inet_shop.model.Registration;

import java.util.List;

public interface RegistrationDao {

    public boolean insertData(Registration registration) throws Exception;

    public List<Registration> getList() throws Exception;

    public int insertRow(Registration registration)throws Exception;

    public Registration getRowById(int id)throws Exception;

    public int updateRow(Registration registration)throws Exception;

    public int deleteRow(int id)throws Exception;

    public Registration findByUserName(String username)throws Exception;

}

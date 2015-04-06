package ru.tenet.inet_shop.service;

import ru.tenet.inet_shop.model.Registration;

import java.util.List;

/**
 * Created by pivovarov.v on 24.03.15.
 */
public interface Service {

    public Registration send(Registration registration) throws Exception;

    public List<Registration> getList() throws Exception;

    public int insertRow(Registration registration)throws Exception;

    public Registration getRowById(int id)throws Exception;

    public int updateRow(Registration registration)throws Exception;

    public int deleteRow(int id)throws Exception;

    public Registration findByUserName(String username)throws Exception;

}

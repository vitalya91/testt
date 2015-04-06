package ru.tenet.inet_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tenet.inet_shop.DAO.RegistrationDao;
import ru.tenet.inet_shop.model.Registration;
import ru.tenet.inet_shop.service.Service;
import org.springframework.security.access.annotation.Secured;
import java.util.List;

/**
 * Created by pivovarov.v on 23.03.15.
 */

@Controller
@RequestMapping("/registration")
public class restful {

    @Autowired
    Service service;

    static final Logger logger = Logger.getLogger(restful.class);


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public @ResponseBody
    void registerUser(@RequestBody Registration registration) {
        try {
        service.insertRow(registration);
    } catch (Exception e) {e.printStackTrace();}
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody
    List getList() {
        List employeeList = null;
    try {
        employeeList = service.getList();
    } catch (Exception e) {e.printStackTrace();}

        return employeeList;
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public@ResponseBody
    void deleteUser(@RequestBody int id) {
        try {
        service.deleteRow(id);
    } catch (Exception e) {e.printStackTrace();}
    }


    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public@ResponseBody
    Registration editUser(@RequestBody int id) {
        Registration employeeObject = null;
        try {
         employeeObject = service.getRowById(id);
        } catch (Exception e) {e.printStackTrace();}
        return employeeObject;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public@ResponseBody
    void updateUser(@RequestBody Registration employee) {
     try {
        service.updateRow(employee);
    } catch (Exception e) {e.printStackTrace();}
    }

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public@ResponseBody
    Registration findByUserName(@RequestBody String username) {
        Registration employeeObject = null;
        try {
            employeeObject = service.findByUserName(username);
        } catch (Exception e) {e.printStackTrace();}
        return employeeObject;
    }




}

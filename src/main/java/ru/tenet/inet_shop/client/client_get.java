package ru.tenet.inet_shop.client;

import org.springframework.web.client.RestTemplate;
import ru.tenet.inet_shop.model.Registration;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by pivovarov.v on 23.03.15.
 */
public class client_get {

    public static void main(String args[]) {
        /*
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> emps = (List)  restTemplate.getForObject("http://localhost:8080/registration/list",
             List.class);
        for(LinkedHashMap map : emps){
            System.out.println("ID= "+map.get("id")+" Name= "+map.get("username")+"password= "+map.get("password")+"birthday="+map.get("birthday"));
        }
        System.out.println(emps.get(1).get("password"));
        */
    }

}

package ru.tenet.inet_shop.client;

import org.springframework.web.client.RestTemplate;
import ru.tenet.inet_shop.model.Registration;

/**
 * Created by pivovarov.v on 23.03.15.
 */
public class client_write {

    public static void main(String args[])throws Exception {
        RestTemplate restTemplate = new RestTemplate();
/*
        Registration registration = new Registration();

        registration.setFirstName("555");
        registration.setLastName("555");
        registration.setEmail("555");
        registration.setPhone("555");
        registration.setUsername("555");
        registration.setPassword("555");
        registration.setRole("555");
        registration.setBirthday("1991-10-30");

       //Registration r = (Registration)

*/
           Registration r =  restTemplate.postForObject("http://localhost:8080/registration/edit",22,
                    Registration.class);



System.out.println(r.getUsername()+r.getBirthday());
    }

}

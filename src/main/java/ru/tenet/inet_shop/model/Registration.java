package ru.tenet.inet_shop.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.text.DateFormat;
import java.text.MessageFormat;
import javax.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee")
public class Registration implements Serializable {

        @Id
        @GeneratedValue
        private int id;

        @Column(name="first_name")
        private String firstName;

        @Column(name="last_name")
        private String lastName;

        @Column(name="email")
        private String email;

        @Column(name="phone")
        private String phone;

        @Column(name="username")
        private String username;

        @Column(name="password")
        private String password;

        @Column(name="role")
        private String role;

        @Column(name="birthday")
        private GregorianCalendar birthday;


        public String getUsername() { return username;}

        public void setUsername(String username) {this.username = username;}

        public String getPassword() {return password;}

        public void setPassword(String password) {this.password = password;}

        public String getRole() {return role;}

        public void setRole(String role) {this.role = role;}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getBirthday() {
            return

                    birthday.get(Calendar.YEAR) + "-" +
                            (birthday.get(Calendar.MONTH)+1) + "-" +
                            birthday.get(Calendar.DAY_OF_MONTH);
    }


        public void setBirthday(String data) throws Exception {


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = df.parse(data);
            birthday = new GregorianCalendar();
            birthday.setTime(parsed);
    }
/* GET
    return

            birthday.get(Calendar.YEAR) + "-" +
            birthday.get(Calendar.MONTH) + "-" +
            birthday.get(Calendar.DAY_OF_MONTH);
    /*

/* SET
    public void setBirthday(int year, int month, int day) {
        birthday = new GregorianCalendar();
        birthday.set(Calendar.YEAR, year);
        birthday.set(Calendar.MONTH, month-1);
        birthday.set(Calendar.DAY_OF_MONTH, day);


    }
    */

}

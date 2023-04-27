package gibslaur;

import gibslaur.dao.CustomerDao;
import gibslaur.dao.JdbcCustomerDao;
import gibslaur.dao.JdbcPetDao;
import gibslaur.dao.PetDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VetClinic {


    public static void main(String[] args) {
        SpringApplication.run(VetClinic.class, args);
    }

}

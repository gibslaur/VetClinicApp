package gibslaur.dao;


import gibslaur.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT pet_id, customer_id, pet_name, species, age, weight_lbs, medications, pet_notes " +
                "FROM pet;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public Pet getPetById(int petId) {
        Pet pet = null;
        String sql = "SELECT pet_id, customer_id, pet_name, species, age, weight_lbs, medications, pet_notes " +
                "FROM pet " +
                "WHERE pet_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            pet = mapRowToPet(results);
        }
        return pet;
    }

    @Override
    public void updateMedications(int petId, Pet pet) {
        String sql = "UPDATE pet SET medications = ? WHERE pet_id = ?;";
        jdbcTemplate.update(sql, pet.getMedications(), petId);
    }

    //TODO add other Update and Delete methods, then build CustomerController

    private Pet mapRowToPet(SqlRowSet sqlRowSet) {
        Pet pet = new Pet();
        pet.setPetId(sqlRowSet.getInt("pet_id"));
        pet.setCustomerId(sqlRowSet.getInt("customer_id"));
        pet.setPetName(sqlRowSet.getString("pet_name"));
        pet.setSpecies(sqlRowSet.getString("species"));
        pet.setAge(sqlRowSet.getInt("age"));
        pet.setWeightLbs(sqlRowSet.getInt("weight_lbs"));
        pet.setMedications(sqlRowSet.getString("medications"));
        pet.setPetNotes(sqlRowSet.getString("pet_notes"));
        return pet;
    }

}

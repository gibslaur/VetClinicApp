package gibslaur.controllers;

import gibslaur.dao.PetDao;
import gibslaur.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

    @RequestMapping(path= "/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets() {
        return petDao.getAllPets();
    }

    @RequestMapping(path= "/pets/{id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int id) {
        return petDao.getPetById(id);
    }

    @RequestMapping(path = "/pets/{id}", method = RequestMethod.PUT)
    public void updateMedications(@PathVariable int id, @RequestBody Pet pet) {
        petDao.updateMedications(id, pet);
    }

}

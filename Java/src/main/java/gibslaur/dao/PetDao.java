package gibslaur.dao;

import gibslaur.model.Pet;

import java.util.List;

public interface PetDao {

    public List<Pet> getAllPets();

    public Pet getPetById(int petId);

    public void updateMedications(int petId, Pet pet);


}

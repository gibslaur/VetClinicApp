package gibslaur.model;

public class Pet {

    private int petId;
    private int customerId;
    private String petName;
    private String species;
    private int age;
    private int weightLbs;
    private String medications;
    private String petNotes;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(int weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getPetNotes() {
        return petNotes;
    }

    public void setPetNotes(String petNotes) {
        this.petNotes = petNotes;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", customerId=" + customerId +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", weightLbs=" + weightLbs +
                ", medications='" + medications + '\'' +
                ", petNotes='" + petNotes + '\'' +
                '}';
    }
}

package dtos;

import entities.Animal;
import java.util.List;

public class ZooDTO {

    /** This is my variables **/

    private Integer id;
    private String zoo;
    private List<Animal> animals;

    /** This is the constructor **/

    public ZooDTO(Integer id, String zoo, List<Animal> animals) {
        this.id = id;
        this.zoo = zoo;
        this.animals = animals;
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZoo() {
        return zoo;
    }

    public void setZoo(String zoo) {
        this.zoo = zoo;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "ZooDTO{" +
                "id=" + id +
                ", zoo='" + zoo + '\'' +
                ", animals=" + animals +
                '}';
    }
}

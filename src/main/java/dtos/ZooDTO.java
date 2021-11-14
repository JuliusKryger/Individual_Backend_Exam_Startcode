package dtos;

import entities.Animal;
import java.util.List;

public class ZooDTO {

    private Integer id;
    private String zoo;
    private List<Animal> animals;

    public ZooDTO(Integer id, String zoo, List<Animal> animals) {
        this.id = id;
        this.zoo = zoo;
        this.animals = animals;
    }
}

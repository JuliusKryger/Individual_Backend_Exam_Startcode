package dtos;

import entities.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalsDTO {

    List<AnimalDTO> all = new ArrayList();

    public AnimalsDTO(List<Animal> animalEntities) {
        animalEntities.forEach((p) -> {
            all.add(new AnimalDTO(p));
        });
    }

    public List<AnimalDTO> getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "Animals = " + all + " ";
    }



}

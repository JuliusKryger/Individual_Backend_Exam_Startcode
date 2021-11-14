package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "zoo")
@Entity
public class Zoo implements Serializable {

    /** This is my variables **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "zoo", length = 175, nullable = false)
    private String zoo;

    @OneToMany
    private List<Animal> animals;

    private static final long serialVersionUID = -1L;

    /** This is my constructor **/

    public Zoo() {
    }

    public Zoo(Integer id, String zoo, List<Animal> animals) {
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
}
package entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "animal")
@Entity
public class Animal implements Serializable {

    /** This is my variables **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 175, nullable = false)
    private String name;

    @Column(name = "age", length = 175, nullable = false)
    private String age;

    private static final long serialVersionUID = 1L;


    /** This is the constructor **/

    public Animal() {
    }

    public Animal(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /** GETTERS AND SETTERS **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
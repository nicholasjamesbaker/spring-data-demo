package ca.nl.cna.java3.springdatademo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Simple class to represent a students' skills. This class
 * represents a set of skills and the type that they are. Students
 * may have many of these.
 *
 * @author Nick
 */
@Entity(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;

    /**
     * Gets ID of Skills
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets ID of Skills
     * @param id sets the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name of skill
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of skill
     * @param name sets the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type of skill
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of skill
     * @param type sets the type
     */
    public void setType(String type) {
        this.type = type;
    }
}

package ca.nl.cna.java3.springdatademo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Simple class to represent a students' experience. This class
 * represents a single job, career, etc. Students may have many of these.
 *
 * @author Nick
 */
@Entity(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jobTitle;
    private String employer;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate endDate;

    /**
     * Gets ID of Experience
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets ID of Experience
     * @param id sets the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets job title of Experience
     * @return jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets job title of Experience
     * @param jobTitle sets the jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Gets employer of Experience
     * @return employer
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * Sets employer of Experience
     * @param employer sets the employer
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * Gets description of Experience
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description of Experience
     * @param description sets the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets start date of Experience
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets start date of Experience
     * @param startDate sets the startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date of Experience
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets end date of Experience
     * @param endDate sets the endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

package ca.nl.cna.java3.springdatademo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Simple class to represent a students' education. This class
 * represents a single diploma, certificate or degree. Students
 * may have many of these.
 *
 * @author Nick
 */
@Entity(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    private String institutionName;
    private Integer gradYear;

    @JsonFormat(pattern="yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate endDate;

    private String abbreviation;

    /**
     * Gets ID of Education
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets ID of Education
     * @param id sets the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets title of Education
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of Education
     * @param title sets the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the institution name of Experience
     * @return institutionName
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the institution name of Experience
     * @param institutionName sets the institutionName
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Gets the grad year of Experience
     * @return gradYear
     */
    public Integer getGradYear() {
        return gradYear;
    }

    /**
     * Sets the grad year of Experience
     * @param gradYear sets the gradYear
     */
    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * Gets the start date of Experience
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of Experience
     * @param startDate sets the startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of Experience
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of Experience
     * @param endDate sets the endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the abbreviation of Experience
     * @return abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the abbreviation of Experience
     * @param abbreviation sets the abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
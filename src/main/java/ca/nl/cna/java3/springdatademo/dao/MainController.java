package ca.nl.cna.java3.springdatademo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * The main controller for the course project
 * Performs CRUD operations for Education, Experience, Skills
 * repositories and any other various methods needed.
 *
 * @author Nick
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api")
public class MainController {

    //Constants used in REST API definition
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";
    public static final String EXPERIENCE = "/experience";
    public static final String SKILLS = "/skills";

    @Autowired  //This links this to the database
    private EducationRepository educationRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired  //This links this to the database
    private SkillsRepository skillsRepository;

    //Education CRUD

    /**
     * Gets all available Educations
     * @return findAll() method for educations
     */
    @GetMapping(path=VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducations(){
        return educationRepository.findAll();
    }

    /**
     * Gets Education by id
     * @param id requested id
     * @return Education by id
     */
    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEducationWithId(@PathVariable Integer id){
        return educationRepository.findById(id);
    }

    /**
     * Add a new education to the resume
     * @param title title of education
     * @param institutionName institution name of education
     * @param gradYear graduation year of education
     * @param startDate start date of education
     * @param endDate end date of education
     * @param abbreviation abbreviation of education
     * @return string marking object as "saved"
     */
    @PostMapping(path=VERSION_1 + EDUCATION)
    public @ResponseBody
    String addNewEducation(@RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
                           @RequestParam String abbreviation){

        Education education = new Education();
        education.setTitle(title);
        education.setInstitutionName(institutionName);
        education.setGradYear(gradYear);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setAbbreviation(abbreviation);
        educationRepository.save(education);
        return "saved";
    }

    /**
     * Update an existing education by ID
     * @param title title of education
     * @param institutionName institution name of education
     * @param gradYear graduation year of education
     * @param startDate start date of education
     * @param endDate end date of education
     * @param abbreviation abbreviation of education
     * @return string marking object as "updated"
     */
    @PutMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String updateEducation(@RequestParam Integer id, @RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
                           @RequestParam String abbreviation) {

        Optional<Education> newEducation = getEducationWithId(id);
        if (newEducation.isPresent()) {
            Education education = newEducation.get();
            education.setTitle(title);
            education.setInstitutionName(institutionName);
            education.setGradYear(gradYear);
            education.setStartDate(startDate);
            education.setEndDate(endDate);
            education.setAbbreviation(abbreviation);
            educationRepository.save(education);
            return "updated";
        } else {
            return "Fail - no education to update";
        }
    }

    /**
     * Deletes Education by id
     * @param id requested id
     * @return string marking object as "deleted"
     */
    @DeleteMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id){
        educationRepository.deleteById(id);
        return "deleted";
    }

    //Experience CRUD

    /**
     * Gets all available Experience
     * @return findAll() method for experience
     */
    @GetMapping(path=VERSION_1 + EXPERIENCE)
    public @ResponseBody
    Iterable<Experience> getAllExperience(){
        return experienceRepository.findAll();
    }

    /**
     * Gets Experience by id
     * @param id requested id
     * @return Experience by id
     */
    @GetMapping(path = VERSION_1 + EXPERIENCE + "/{id}")
    public @ResponseBody
    Optional<Experience> getExperienceWithId(@PathVariable Integer id){
        return experienceRepository.findById(id);
    }

    /**
     * Add Experience to Resume
     * @param startDate start date of job
     * @param endDate end date of job
     * @param jobTitle title of job
     * @param employer employer of job
     * @param description description of job
     * @return string marking object as "deleted"
     */
    @PostMapping(path=VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String addNewExperience(@RequestParam LocalDate startDate,
                           @RequestParam LocalDate endDate, @RequestParam String jobTitle,
                           @RequestParam String employer, @RequestParam String description){

        Experience experience = new Experience();
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setJobTitle(jobTitle);
        experience.setEmployer(employer);
        experience.setDescription(description);
        experienceRepository.save(experience);
        return "saved";
    }

    /**
     * Update an existing experience by ID
     * @param startDate start date of job
     * @param endDate end date of job
     * @param jobTitle title of job
     * @param employer employer of job
     * @param description description of job
     * @return string marking object as "updated"
     */
    @PutMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String updateExperience(@RequestParam Integer id, @RequestParam LocalDate startDate,
                           @RequestParam LocalDate endDate, @RequestParam String jobTitle,
                           @RequestParam String employer, @RequestParam String description) {

        Optional<Experience> newExperience = getExperienceWithId(id);
        if (newExperience.isPresent()) {
            Experience experience = newExperience.get();
            experience.setStartDate(startDate);
            experience.setEndDate(endDate);
            experience.setJobTitle(jobTitle);
            experience.setEmployer(employer);
            experience.setDescription(description);
            experienceRepository.save(experience);
            return "updated";
        } else {
            return "Fail - no experience to update";
        }
    }

    /**
     * Delete Experience by id
     * @param id requested id
     * @return string marking object as "deleted"
     */
    @DeleteMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String deleteExperience(@RequestParam Integer id){
        experienceRepository.deleteById(id);
        return "deleted";
    }

    //Skills CRUD

    /**
     * Gets all available Skills
     * @return findAll() method for Skills
     */
    @GetMapping(path=VERSION_1 + SKILLS)
    public @ResponseBody
    Iterable<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }

    /**
     * Gets Skills by id
     * @param id requested id
     * @return Skills by id
     */
    @GetMapping(path = VERSION_1 + SKILLS + "/{id}")
    public @ResponseBody
    Optional<Skills> getSkillsWithId(@PathVariable Integer id){
        return skillsRepository.findById(id);
    }

    /**
     * Add a skill to the resume
     * @param name name of skill
     * @param type type of skill
     * @return string marking object as "saved"
     */
    @PostMapping(path=VERSION_1 + SKILLS)
    public @ResponseBody
    String addNewSkill(@RequestParam String name, @RequestParam String type){

        Skills skills = new Skills();
        skills.setName(name);
        skills.setType(type);
        skillsRepository.save(skills);
        return "saved";
    }

    /**
     * Update an existing skill by id
     * @param name name of skill
     * @param type type of skill
     * @return string marking object as "updated"
     */
    @PutMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String updateSkills(@RequestParam Integer id, @RequestParam String name, @RequestParam String type) {

        Optional<Skills> newSkills = getSkillsWithId(id);
        if (newSkills.isPresent()) {
            Skills skills = newSkills.get();
            skills.setName(name);
            skills.setType(type);
            skillsRepository.save(skills);
            return "updated";
        } else {
            return "Fail - no skills to update";
        }
    }

    /**
     * Delete skill by id
     * @param id requested id
     * @return string marking object as "deleted"
     */
    @DeleteMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String deleteSkills(@RequestParam Integer id){
        skillsRepository.deleteById(id);
        return "deleted";
    }
}
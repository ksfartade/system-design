package linkedin.jobs;

import java.util.List;

import linkedin.User;
import linkedin.profile.Skill;

public class Job {
    User user;
    String title, jobId, description, location;
    List<Skill> skillsRequired;
    List<Application> applications;

    public void submit(Application application) {
        this.applications.add(application);
    }

    public Job(User user, String title, String jobId, String description, String location, List<Skill> skillsRequired) {
        this.user = user;
        this.title = title;
        this.jobId = jobId;
        this.description = description;
        this.location = location;
        this.skillsRequired = skillsRequired;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Skill> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<Skill> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    
}

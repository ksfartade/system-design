package linkedin.profile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Profile {
    String headline;
    List<Experience> experiences = new ArrayList<>();
    List<Education> educations = new ArrayList<>();
    HashSet<Skill> skills = new HashSet<>();
    
    public String getHeadline() {
        return headline;
    }
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public List<Experience> getExperience() {
        return experiences;
    }
    public void setExperience(Experience experience) {
        this.experiences.add(experience);
    }
    public List<Education> getEducation() {
        return educations;
    }
    public void setEducation(Education education) {
        this.educations.add(education);
    }
    public HashSet<Skill> getSkills() {
        return skills;
    }
    public void setSkills(Skill skills) {
        this.skills.add(skills);
    }
}

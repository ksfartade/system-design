package linkedin;

import java.util.HashMap;

import linkedin.profile.Education;
import linkedin.profile.Experience;
import linkedin.profile.Profile;
import linkedin.profile.Skill;

public class ProfileHandler {
    private static ProfileHandler profileHandler = new ProfileHandler();

    HashMap<User, Profile> profiles = new HashMap<>();
    
    public static ProfileHandler getInstance(){
        return profileHandler;
    }

    public Experience addExperience(User user, String name){
        Experience experience = new Experience(name);
        System.out.println("Adding experience please wait...");
        Sleep.sleep(1000);

        profiles.putIfAbsent(user, new Profile());
        Profile profile = profiles.get(user);

        profile.setExperience(experience);
        System.out.println("Experience added successfully...");
        return experience;
    }

    public Experience updateExperience(User user, Experience pastExperience, String name){
        System.out.println("Updating experience please wait...");
        Sleep.sleep(1000);

        pastExperience.setName(name);
        System.out.println("Experience added successfully...");
        return pastExperience;
    }


    public Education addEducation(User user, String name){
        Education education = new Education(name);
        System.out.println("Adding education please wait..");
        Sleep.sleep(1000);

        profiles.putIfAbsent(user, new Profile());
        Profile profile = profiles.get(user);
        profile.setEducation(education);
        System.out.println("Education added successfully...");
        return education;
    }

    public Education updateEducation(User user, Education pasEducation, String name){
        System.out.println("Updating education, please wait...");
        Sleep.sleep(1000);

        pasEducation.setName(name);
        System.out.println("Education updated successfully..");
        return pasEducation;
    }


    public Skill addSkill(User user, String skill){
        System.out.println("Adding skill please wait...");
        Sleep.sleep(1000);
        profiles.putIfAbsent(user, new Profile());

        Profile profile = profiles.get(user);
        Skill skillObj = new Skill(skill);
        if(profile.getSkills().contains(skillObj)){
            System.out.println("Skill already present");
            return null;
        }

        profile.setSkills(skillObj);
        System.out.println("Skill added successfully..");
        return skillObj;
    }


    public Skill updateSkill(User user, Skill pastSkill, String name){
        System.out.println("Updating skill, please wait...");
        Sleep.sleep(1000);
        pastSkill.setSkill(name);
        System.out.println("Skill updated successfully....");
        return pastSkill;
    }
}

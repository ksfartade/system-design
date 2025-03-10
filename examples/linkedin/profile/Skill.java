package linkedin.profile;

import java.util.Objects;

public class Skill {
    String skill;

    public Skill(String skill){
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

        // Override equals() to check equality based on 'name'
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Skill skill = (Skill) obj;
        return Objects.equals(this.skill, skill.skill);
    }

    // Override hashCode() to ensure consistency with equals()
    @Override
    public int hashCode() {
        return Objects.hash(skill);
    }
    
} 

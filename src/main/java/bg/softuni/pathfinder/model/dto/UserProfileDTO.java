package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.enums.LevelType;

public class UserProfileDTO {

    private String username;
    private String fullName;
    private Integer age;
    private LevelType level;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }
}

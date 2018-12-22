package practice;

public class UserBuilder {
    private User user;
    private UserBuilder() {
        user = new User();
    }
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder setUserName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setUserAge(int age) {
        user.setAge(age);
        return this;
    }

    public User build() {
        return user;
    }

}

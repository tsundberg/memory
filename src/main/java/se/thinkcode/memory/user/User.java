package se.thinkcode.memory.user;

import java.util.Objects;

public class User {
    private String user;

    public User(String userName) {
        this.user = userName;
    }

    public String getUserName() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(user, user1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return user;
    }
}

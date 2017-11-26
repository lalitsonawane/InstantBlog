package in.apptonic.instantblog.model;

/**
 * Created by lalitkumarsonawane on 26/11/17.
 */

public class User {
    String author_name;

    public User(){}
    public User(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}

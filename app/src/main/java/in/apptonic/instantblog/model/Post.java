package in.apptonic.instantblog.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lalitkumarsonawane on 26/11/17.
 */

public class Post {

    String title_post;
    String short_desc;
    String detail_post;

    public Post(){}

    public Post(String title_post, String short_desc, String detail_post) {
        this.title_post = title_post;
        this.short_desc = short_desc;
        this.detail_post = detail_post;
    }

    public String getTitle_post() {
        return title_post;
    }

    public void setTitle_post(String title_post) {
        this.title_post = title_post;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getDetail_post() {
        return detail_post;
    }

    public void setDetail_post(String detail_post) {
        this.detail_post = detail_post;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title_post);
        result.put("short_desc", short_desc);
        result.put("detail_post", detail_post);

        return result;
    }
}

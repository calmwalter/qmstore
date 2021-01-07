package qmstore.activity_category.pojo;

import java.sql.Timestamp;

public class ActivityCategory {
    int id;
    String activity_id;
    String activity_name;
    String category;
    Timestamp start_time;
    Timestamp end_time;
    Timestamp create_time;
    Timestamp update_time;
    String activity_desc;

    @Override
    public String toString() {
        return "ActivityCategory{" +
                "id=" + id +
                ", activity_id='" + activity_id + '\'' +
                ", activity_name='" + activity_name + '\'' +
                ", category='" + category + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", activity_desc='" + activity_desc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getActivity_desc() {
        return activity_desc;
    }

    public void setActivity_desc(String activity_desc) {
        this.activity_desc = activity_desc;
    }
}

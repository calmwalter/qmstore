package qmstore.user.pojo;

import java.util.Date;

public class User {
    String user_id;
    String user_group;
    String user_name;
    String password;
    String phone;
    Date create_time;
    Date update_time;
    String email;



    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUser_group() {
        return user_group;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


    public void setUser_group(String user_group) {
        this.user_group = user_group;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}

package qmstore.goods_activity.pojo;

import java.sql.Timestamp;

public class GoodsActivity {
    int id;
    String goods_id;
    String activity_id;
    Timestamp create_time;
    Timestamp update_time;

    @Override
    public String toString() {
        return "GoodsActivity{" +
                "id=" + id +
                ", goods_id='" + goods_id + '\'' +
                ", activity_id='" + activity_id + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
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
}

package qmstore.banner_goods.pojo;

import java.sql.Timestamp;

public class BannerGoods {
    int id;
    String goods_id;
    String pic_url;
    Timestamp create_time;
    Timestamp update_time;

    @Override
    public String toString() {
        return "BannerGoods{" +
                "id=" + id +
                ", goods_id='" + goods_id + '\'' +
                ", pic_url='" + pic_url + '\'' +
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

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
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

package qmstore.goods_detail.pojo;

import java.sql.Timestamp;

public class GoodsDetail {
    int id;
    String goods_id;
    String goods_name;
    String goods_category_code;
    String goods_category_name;
    double goods_price;
    double goods_discount;
    String brief_desc;
    String detail_desc;
    String pic_url;
    Timestamp create_time;
    Timestamp update_time;
    int sale_status;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public int getSale_status() {
        return sale_status;
    }

    public void setSale_status(int sale_status) {
        this.sale_status = sale_status;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "id=" + id +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_category_code='" + goods_category_code + '\'' +
                ", goods_category_name='" + goods_category_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_discount=" + goods_discount +
                ", brief_desc='" + brief_desc + '\'' +
                ", detail_desc='" + detail_desc + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", sale_status=" + sale_status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_category_code() {
        return goods_category_code;
    }

    public void setGoods_category_code(String goods_category_code) {
        this.goods_category_code = goods_category_code;
    }

    public String getGoods_category_name() {
        return goods_category_name;
    }

    public void setGoods_category_name(String goods_category_name) {
        this.goods_category_name = goods_category_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public double getGoods_discount() {
        return goods_discount;
    }

    public void setGoods_discount(double goods_discount) {
        this.goods_discount = goods_discount;
    }

    public String getBrief_desc() {
        return brief_desc;
    }

    public void setBrief_desc(String brief_desc) {
        this.brief_desc = brief_desc;
    }

    public String getDetail_desc() {
        return detail_desc;
    }

    public void setDetail_desc(String detail_desc) {
        this.detail_desc = detail_desc;
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

package qmstore.activity_category.dao;

import qmstore.activity_category.pojo.ActivityCategory;

import java.util.ArrayList;

public interface ActivityCategoryMapper {
    ArrayList<ActivityCategory> findAll();
    void add(ActivityCategory activityCategory);
    int update(ActivityCategory activityCategory);
    int delete(int id);
    ActivityCategory find(int id);
}

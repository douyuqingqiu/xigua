package com.example.xigua.dao;



import com.example.xigua.entity.Item;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ItemMapper {

    void insert(Item record);

    void updateByKey(Item record);

    Item selectByPrimaryKey(String key);

    Item selectByUrl(String url);
}
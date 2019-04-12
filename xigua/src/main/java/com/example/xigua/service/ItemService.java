package com.example.xigua.service;


import com.example.xigua.entity.Item;

public interface ItemService {

	void insert(Item record);

	Item selectByPrimaryKey(String key);

	void updateByKey(Item record);

	Item selectByUrl(String url);
}

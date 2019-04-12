package com.example.xigua.service.impl;



import com.example.xigua.dao.ItemMapper;
import com.example.xigua.entity.Item;
import com.example.xigua.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	//新增
	@Override
	public void insert(Item record) {
		itemMapper.insert(record);
	}

	//查询
	@Override
	public Item selectByPrimaryKey(String key) {
		return itemMapper.selectByPrimaryKey(key);
	}

	//修改
	@Override
	public void updateByKey(Item record) {
		itemMapper.updateByKey(record);
	}

	@Override
	public Item selectByUrl(String url) {
		return itemMapper.selectByUrl(url);
	}
}

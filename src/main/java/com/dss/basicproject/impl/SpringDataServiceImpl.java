package com.dss.basicproject.impl;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;
import com.dss.basicproject.repository.ItemRepository;
import com.dss.basicproject.repository.ItemSizeRepository;
import com.dss.basicproject.repository.StyleRepository;
import com.dss.basicproject.service.Service;

public class SpringDataServiceImpl implements Service {

	@Autowired
	private StyleRepository styleRepository;

	@Autowired
	private ItemSizeRepository itemSizeRepository;

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private DataSource dataSource;

	public Set<ItemEntity> items = new HashSet<ItemEntity>();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveStyle(StyleEntity styleEntity) {
		styleRepository.save(styleEntity);
	}

	@Override
	public Iterable<StyleEntity> findAllStyles() {
		return styleRepository.findAll();
	}

	@Override
	public StyleEntity findByStyleId(Integer styleid) {
		StyleEntity styleEntity = styleRepository.findOne(styleid);
		return styleEntity;

	}
	

	@Override
	public void deleteStyle(Integer id) {
		styleRepository.delete(id);
		// StyleEntity style=styleRepository.findOne(styleid);
		//StyleEntity style = styleRepository.findById(styleid);
		 StyleEntity style=styleRepository.findByIdUsingJpql(id);
		// System.out.println("size is "+style.getItems());
	}

	@Override
	public void saveItemSize(ItemSizeEntity itemSizeEntity) {
		itemSizeRepository.save(itemSizeEntity);
	}

	@Override
	public Iterable<ItemSizeEntity> findAllItemSize() {
		return itemSizeRepository.findAll();
	}

	@Override
	public ItemSizeEntity findByItemSizeId(Integer itemSizeId) {
		// System.out.println("Hello");
		// TODO Auto-generated method stub
		return itemSizeRepository.findOne(itemSizeId);
	}

	@Override
	public void saveItem(ItemEntity itemEntity) {
		// System.out.println("Item Save");
		itemRepository.save(itemEntity);
	}

	@Override
	public Iterable<ItemEntity> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public ItemEntity findByItemId(Integer itemId) {

		return itemRepository.findOne(itemId);
		//return itemRepository.findByitemId(itemId);
		//return itemRepository.findByIdUsingJpql(itemId);
	}

	@Override
	public boolean isStyleExist(StyleEntity styleEntity,
			SeasonEntity seasonEntity, ClientEntity clientEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StyleEntity findByStyleIdWithItems(Integer styleid) {
		// StyleEntity styleEntity = styleRepository.findById(styleid);
		StyleEntity styleEntity = styleRepository.findByIdUsingJpql(styleid);
		return styleEntity;
	}

	}

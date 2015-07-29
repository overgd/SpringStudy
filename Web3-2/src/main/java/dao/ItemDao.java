package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

	List<Item> findAll(); // 상품 전체 검색

	Item findByPrimaryKey(Integer itemId); // 특정 상품 검색

}

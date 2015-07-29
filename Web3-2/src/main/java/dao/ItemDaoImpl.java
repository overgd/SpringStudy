package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Item;

public class ItemDaoImpl implements ItemDao {

	private static final String SELECT_ALL = "select item_id, item_name, price, description, picture_url from item";
	private static final String SELECT_BY_PRIMARY_KEY = "select item_id, item_name, price, description, picture_url from item where item_id = ?";
	
	private SimpleJdbcTemplate template;
	
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	public List<Item> findAll() {

		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper); // 결과 여러개
		
	}

		
	public Item findByPrimaryKey(Integer itemId) {
		
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return this.template.queryForObject(ItemDaoImpl.SELECT_BY_PRIMARY_KEY, mapper, itemId); // 결과 하나
		
	}
	
}

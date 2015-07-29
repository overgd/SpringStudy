package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {

	private static final String INSERT = "insert into user_account(user_id, user_name, password, postcode, address, email, job, birthday) values(:user_id, :user_name, :password, :postcode, :address, :email, :job, :birthday)";
	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource template) {
		this.template = new SimpleJdbcTemplate(template);
	}

	public void create(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		this.template.update(UserDaoImpl.INSERT, params);
	}
	

}

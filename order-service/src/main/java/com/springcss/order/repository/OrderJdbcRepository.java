package com.springcss.order.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.springcss.order.domain.Goods;
import com.springcss.order.domain.Order;

@Repository("orderJdbcRepository")
public class OrderJdbcRepository implements OrderRepository {

	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcInsert orderInserter;
	private SimpleJdbcInsert orderGoodsInserter;

	@Autowired
	public OrderJdbcRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.orderInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("`order`").usingGeneratedKeyColumns("id");
		this.orderGoodsInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("order_goods");
	}

	@Override
	public Order addOrder(Order order) {
		// return addOrderWithJdbcTemplate(order);

		return addOrderDetailWithSimpleJdbcInsert(order);
	}

	@Override
	public Order getOrderById(Long orderId) {
		Order order = jdbcTemplate.queryForObject("select id, order_number, delivery_address from `order` where id=?",
				this::mapRowToOrder, orderId);

		return order;
	}

	@Override
	public Order getOrderDetailByOrderNumber(String orderNumber) {
		//获取Order基础信息
		Order order = jdbcTemplate.queryForObject(
				"select id, order_number, delivery_address from `order` where order_number=?", this::mapRowToOrder,
				orderNumber);

		if (order == null)
			return order;

		//获取Order与Goods之间的关联关系，找到给Order中的所有GoodsId
		Long orderId = order.getId();
		List<Long> goodsIds = jdbcTemplate.query("select order_id, goods_id from order_goods where order_id=?",
				new ResultSetExtractor<List<Long>>() {
					public List<Long> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<Long> list = new ArrayList<Long>();
						while (rs.next()) {
							list.add(rs.getLong("goods_id"));
						}
						return list;
					}
				}, orderId);

		//根据GoodsId分别获取Goods信息并填充到Order对象中
		for (Long goodsId : goodsIds) {
			Goods goods = getGoodsById(goodsId);
			order.addGoods(goods);
		}

		return order;
	}

	private Goods getGoodsById(Long goodsId) {
		return jdbcTemplate.queryForObject("select id, goods_code, goods_name, price from goods where id=?",
				this::mapRowToGoods, goodsId);
	}

	private Goods mapRowToGoods(ResultSet rs, int rowNum) throws SQLException {
		return new Goods(rs.getLong("id"), rs.getString("goods_code"), rs.getString("goods_name"),
				rs.getDouble("price"));
	}

	private Order mapRowToOrder(ResultSet rs, int rowNum) throws SQLException {
		return new Order(rs.getLong("id"), rs.getString("order_number"), rs.getString("delivery_address"));
	}

	// addOrderDetailWithJdbcTemplate
	private Order addOrderDetailWithJdbcTemplate(Order order) {
		//插入Order基础信息
		Long orderId = saveOrderWithJdbcTemplate(order);

		order.setId(orderId);

		//插入Order与Goods的对应关系
		List<Goods> goodsList = order.getGoods();
		for (Goods goods : goodsList) {
			saveGoodsToOrderWithJdbcTemplate(goods, orderId);
		}

		return order;
	}

	private Long saveOrderWithJdbcTemplate(Order order) {

		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(
						"insert into `order` (order_number, delivery_address) values (?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, order.getOrderNumber());
				ps.setString(2, order.getDeliveryAddress());
				return ps;
			}
		};

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);

		return keyHolder.getKey().longValue();
	}

	private void saveGoodsToOrderWithJdbcTemplate(Goods goods, long orderId) {
		jdbcTemplate.update("insert into order_goods (order_id, goods_id) " + "values (?, ?)", orderId, goods.getId());
	}

	// addOrderDetailWithSimpleJdbcInsert
	private Order addOrderDetailWithSimpleJdbcInsert(Order order) {
		//插入Order基础信息
		Long orderId = saveOrderWithSimpleJdbcInsert(order);

		order.setId(orderId);
		
		//插入Order与Goods的对应关系
		List<Goods> goodsList = order.getGoods();
		for (Goods goods : goodsList) {
			saveGoodsToOrderWithSimpleJdbcInsert(goods, orderId);
		}

		return order;
	}

	private Long saveOrderWithSimpleJdbcInsert(Order order) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("order_number", order.getOrderNumber());
		values.put("delivery_address", order.getDeliveryAddress());

		Long orderId = orderInserter.executeAndReturnKey(values).longValue();
		return orderId;
	}

	private void saveGoodsToOrderWithSimpleJdbcInsert(Goods goods, long orderId) {
		Map<String, Object> values = new HashMap<>();
		values.put("order_id", orderId);
		values.put("goods_id", goods.getId());
		orderGoodsInserter.execute(values);
	}
}

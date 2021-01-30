package pl.edu.wszib.store.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.store.dao.IProductDAO;
import pl.edu.wszib.store.model.Product;

import java.util.List;

@Repository
class ProductDAOImpl implements IProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.query("SELECT * FROM tproduct WHERE id = ?", new BeanPropertyRowMapper<>(Product.class), id )
                .stream().findAny().orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE tproduct SET name=?, price=?, quan=? WHERE id=?",
                product.getName(), product.getPrice(), product.getQuan(), product.getId());
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM tproduct", new BeanPropertyRowMapper<>(Product.class));
    }
}

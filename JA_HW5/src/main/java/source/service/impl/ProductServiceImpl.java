package source.service.impl;

import java.sql.SQLException;
import java.util.List;

import source.DAO.ProductDao;
import source.DAO.Impl.ProductDaoImpl;
import source.domain.Product;
import source.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	
	public ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	} 
	
	@Override
	public Product create(Product product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	

}

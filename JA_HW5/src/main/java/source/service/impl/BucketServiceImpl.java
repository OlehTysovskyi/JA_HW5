package source.service.impl;

import java.sql.SQLException;
import java.util.List;

import source.DAO.BucketDao;
import source.DAO.Impl.BucketDaoImpl;
import source.domain.Bucket;
import source.service.BucketService;

public class BucketServiceImpl implements BucketService{
	
	private BucketDao bucketDao;

	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public Bucket create(Bucket bucket) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		BucketDao bucketDao = new BucketDaoImpl();
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket) {
		return bucketDao.update(bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}

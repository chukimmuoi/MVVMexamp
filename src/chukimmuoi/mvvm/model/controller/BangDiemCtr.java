package chukimmuoi.mvvm.model.controller;

import java.sql.SQLException;
import java.util.List;
import android.content.Context;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import chukimmuoi.mvvm.model.myinterface.IBangDiem;
import chukimmuoi.mvvm.model.table.BangDiem;
import chukimmuoi.mvvm.utils.dao.BangDiemDAO;

public class BangDiemCtr implements IBangDiem{
	private Dao<BangDiem, Integer> dao;
	
	@Inject
	public BangDiemCtr(Context context, BangDiemDAO dao) {
		this.dao = dao.get();
	}

	@Override
	public int insert(BangDiem obj) throws SQLException {
		return this.dao.create(obj);
	}

	@Override
	public void update(BangDiem obj) throws SQLException {
		this.dao.update(obj);
	}

	@Override
	public void delete(BangDiem obj) throws SQLException {
		this.dao.delete(obj);
	}

	@Override
	public List<BangDiem> select() throws SQLException {
		return this.dao.queryForAll();
	}

	@Override
	public List<BangDiem> searchByMonHoc(BangDiem obj) throws SQLException {
		//TÌM TUYỆT ĐỐI
//		Map<String, Object> values = new HashMap<String, Object>();
//		values.put("MonHoc", obj.getMonHoc());
//		return this.dao.queryForFieldValuesArgs(values);
		
		QueryBuilder<BangDiem, Integer> qb = dao.queryBuilder();
		Where<BangDiem, Integer> where = qb.where();
		where.like("MonHoc", "%" + obj.getMonHoc() +"%");
		PreparedQuery<BangDiem> pq = qb.prepare();
		return dao.query(pq);
	}

	@Override
	public float getDiemHe10(BangDiem obj) throws SQLException {
		GenericRawResults<Float> output = dao.queryRaw("SELECT ROUND(SUM(SoTinChi * DiemTongKet)/SUM(SoTinChi), 2) FROM BangDiem WHERE HocKy = '"+ obj.getHocKy() +"'", new RawRowMapper<Float>() {
			@Override
			public Float mapRow(String[] columnStt, String[] results)
					throws SQLException {
				return Float.parseFloat(results[0]);
			}
		});
		return output.getFirstResult();
	}

	@Override
	public float getDiemHe4(BangDiem obj) throws SQLException {
		GenericRawResults<Float> output = dao.queryRaw("SELECT ROUND(SUM(DiemTichLuy)/SUM(SoTinChi), 2) FROM BangDiem WHERE HocKy = '"+ obj.getHocKy() +"'", new RawRowMapper<Float>() {
			@Override
			public Float mapRow(String[] columnStt, String[] results)
					throws SQLException {
				return Float.parseFloat(results[0]);
			}
		});
		return output.getFirstResult();
	}

	@Override
	public List<BangDiem> searchByHocKy(BangDiem obj) throws SQLException {
		QueryBuilder<BangDiem, Integer> qb = dao.queryBuilder();
		Where<BangDiem, Integer> where = qb.where();
		where.eq("HocKy", obj.getHocKy());
		PreparedQuery<BangDiem> pq = qb.prepare();
		return dao.query(pq);
	}

}

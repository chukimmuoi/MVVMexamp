package chukimmuoi.mvvm.utils.dao;

import java.sql.SQLException;
import javax.inject.Inject;
import javax.inject.Provider;
import chukimmuoi.mvvm.model.table.BangDiem;
import chukimmuoi.mvvm.utils.database.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class BangDiemDAO implements Provider<Dao<BangDiem, Integer>>{
	private ConnectionSource cs;
	
	@Inject
	public BangDiemDAO(DatabaseHelper databaseHelper){
		cs = databaseHelper.getConnectionSource();
	}
	
	@Override
	public Dao<BangDiem, Integer> get() {
		try {
			return DaoManager.createDao(cs, BangDiem.class);
		} catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

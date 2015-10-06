package chukimmuoi.mvvm.model.myinterface;

import java.sql.SQLException;
import java.util.List;
import chukimmuoi.mvvm.model.table.BangDiem;

public interface IBangDiem {
	public int insert(BangDiem obj) throws SQLException;
	public void update(BangDiem obj) throws SQLException;
	public void delete(BangDiem obj) throws SQLException;
	public List<BangDiem> select() throws SQLException;
	public List<BangDiem> searchByMonHoc(BangDiem obj) throws SQLException;
	public float getDiemHe10(BangDiem obj) throws SQLException;
	public float getDiemHe4(BangDiem obj) throws SQLException;
	public List<BangDiem> searchByHocKy(BangDiem obj) throws SQLException; 
}

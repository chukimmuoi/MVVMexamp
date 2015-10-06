package chukimmuoi.mvvm.viewmodel.myinterface;

import java.util.List;

import chukimmuoi.mvvm.model.table.BangDiem;

public interface IDanhSachBangDiem {
	public List<BangDiem> select();
	public List<BangDiem> searchByMonHoc(BangDiem obj);
}

package chukimmuoi.mvvm;

import chukimmuoi.mvvm.model.controller.BangDiemCtr;
import chukimmuoi.mvvm.model.myinterface.IBangDiem;
import chukimmuoi.mvvm.viewmodel.controller.DanhSachBangDiemCtr;
import chukimmuoi.mvvm.viewmodel.controller.QuanLyDiemCtr;
import chukimmuoi.mvvm.viewmodel.myinterface.IDanhSachBangDiem;
import chukimmuoi.mvvm.viewmodel.myinterface.IQuanLyDiem;

import com.google.inject.Binder;
import com.google.inject.Module;

public class BaseModule implements Module{
	@Override
	public void configure(Binder binder) {
		binder.bind(IBangDiem.class).to(BangDiemCtr.class);
		binder.bind(IQuanLyDiem.class).to(QuanLyDiemCtr.class);
		binder.bind(IDanhSachBangDiem.class).to(DanhSachBangDiemCtr.class);
	}
}

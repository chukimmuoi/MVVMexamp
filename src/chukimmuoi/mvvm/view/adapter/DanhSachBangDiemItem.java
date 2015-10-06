package chukimmuoi.mvvm.view.adapter;

import org.robobinding.itempresentationmodel.ItemPresentationModel;

import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.model.table.BangDiem;

public class DanhSachBangDiemItem implements ItemPresentationModel<BangDiem>{
	private BangDiem bangdiem;
	
	public String getMonHoc(){
		return bangdiem.getMonHoc();
	}
	
	public String getDiemTongKet(){
		return String.valueOf(bangdiem.getDiemTongKet());
	}
	
	public String getDiemChu(){
		return bangdiem.getDiemChu();
	}
	
	public String getDiemTichLuy(){
		return String.valueOf(bangdiem.getDiemTichLuy());
	}
	
	public int getImage(){
		if(bangdiem.getDiemTongKet() >= 3.95){
			return R.drawable.check;
		}else{
			return R.drawable.deletered;
		}
	}
	@Override
	public void updateData(int index, BangDiem bangdiem) {
		this.bangdiem = bangdiem;
	}
}

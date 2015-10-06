package chukimmuoi.mvvm.model.table;

import java.io.Serializable;

import android.content.Context;
import chukimmuoi.mvvm.R;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "BangDiem")
public class BangDiem implements Serializable{
	private static final long serialVersionUID = 1L;
	//Lưu ý tạo Id có id thì thôi generatedId
	@DatabaseField(columnName = "Id", generatedId = true)
	private int Id;
	@DatabaseField(columnName = "HocKy", canBeNull = false)
	private String HocKy;
	@DatabaseField(columnName = "MonHoc", canBeNull = false)
	private String MonHoc;
	@DatabaseField(columnName = "SoTinChi", canBeNull = false, defaultValue = "1")
	private int SoTinChi;
	@DatabaseField(columnName = "DiemQuaTrinh", canBeNull = false, defaultValue = "0")
	private float DiemQuaTrinh;
	@DatabaseField(columnName = "DiemThi", canBeNull = false, defaultValue = "0")
	private float DiemThi;
	@DatabaseField(columnName = "DiemTongKet", canBeNull = true, defaultValue = "0")
	private float DiemTongKet;
	@DatabaseField(columnName = "DiemChu", canBeNull = true, defaultValue = "F")
	private String DiemChu;
	@DatabaseField(columnName = "DiemTichLuy", canBeNull = true, defaultValue = "0")
	private float DiemTichLuy;
	@DatabaseField(columnName = "KetLuan", canBeNull = true)
	private String KetLuan;
	private Context context;
	
	public BangDiem() {
		super();
	}
	
	public BangDiem(String hocKy, String monHoc, int soTinChi,
			float diemQuaTrinh, float diemThi, float diemTongKet,
			String diemChu, float diemTichLuy, String ketLuan) {
		super();
		HocKy = hocKy;
		MonHoc = monHoc;
		SoTinChi = soTinChi;
		DiemQuaTrinh = diemQuaTrinh;
		DiemThi = diemThi;
		DiemTongKet = diemTongKet;
		DiemChu = diemChu;
		DiemTichLuy = diemTichLuy;
		KetLuan = ketLuan;
	}
	
	public int getStt() {
		return Id;
	}
	public void setStt(int stt) {
		Id = stt;
	}
	public String getHocKy() {
		return HocKy;
	}
	public void setHocKy(String hocKy) {
		HocKy = hocKy;
	}
	public String getMonHoc() {
		return MonHoc;
	}
	public void setMonHoc(String monHoc) {
		MonHoc = monHoc;
	}
	public int getSoTinChi() {
		return SoTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		SoTinChi = soTinChi;
	}
	public float getDiemQuaTrinh() {
		return DiemQuaTrinh;
	}
	public void setDiemQuaTrinh(float diemQuaTrinh) {
		DiemQuaTrinh = diemQuaTrinh;
	}
	public float getDiemThi() {
		return DiemThi;
	}
	public void setDiemThi(float diemThi) {
		DiemThi = diemThi;
	}
	public float getDiemTongKet() {
		return DiemTongKet;
	}
	public void setDiemTongKet(float diemTongKet) {
		DiemTongKet = diemTongKet;
	}
	public String getDiemChu() {
		return DiemChu;
	}
	public void setDiemChu(String diemChu) {
		DiemChu = diemChu;
	}
	public float getDiemTichLuy() {
		return DiemTichLuy;
	}
	public void setDiemTichLuy(float diemTichLuy) {
		DiemTichLuy = diemTichLuy;
	}
	public String getKetLuan() {
		return KetLuan;
	}
	public void setKetLuan(String ketLuan) {
		KetLuan = ketLuan;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}

	public void setDataNull(){
		setDiemTongKet((float) (getDiemQuaTrinh() * 0.4 + getDiemThi() * 0.6));
		if(getDiemTongKet() < 3.95){
			setDiemChu("F");
			setDiemTichLuy(0);
			setKetLuan(getContext().getString(R.string.hoclai));
		}
		if(getDiemTongKet() >= 3.95 && getDiemTongKet() < 4.95){
			setDiemChu("D");
			setDiemTichLuy(getSoTinChi());
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 4.95 && getDiemTongKet() < 5.45){
			setDiemChu("D+");
			setDiemTichLuy((float) (1.5 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 5.45 && getDiemTongKet() < 6.45){
			setDiemChu("C");
			setDiemTichLuy((float) (2 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 6.45 && getDiemTongKet() < 6.95){
			setDiemChu("C+");
			setDiemTichLuy((float) (2.5 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 6.95 && getDiemTongKet() < 7.95){
			setDiemChu("B");
			setDiemTichLuy((float) (3 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 7.95 && getDiemTongKet() < 8.45){
			setDiemChu("B+");
			setDiemTichLuy((float) (3.5 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
		if(getDiemTongKet() >= 8.45 && getDiemTongKet() <= 10){
			setDiemChu("A");
			setDiemTichLuy((float) (4 * getSoTinChi()));
			setKetLuan(getContext().getString(R.string.qua));
		}
	}
}

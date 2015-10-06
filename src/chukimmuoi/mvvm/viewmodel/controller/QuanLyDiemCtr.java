package chukimmuoi.mvvm.viewmodel.controller;

import java.sql.SQLException;

import org.robobinding.presentationmodel.DependsOnStateOf;
import org.robobinding.presentationmodel.PresentationModel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.model.myinterface.IBangDiem;
import chukimmuoi.mvvm.model.table.BangDiem;
import chukimmuoi.mvvm.viewmodel.myinterface.IQuanLyDiem;

import com.google.inject.Inject;

@PresentationModel
public class QuanLyDiemCtr implements IQuanLyDiem{
	@Inject
	private IBangDiem iBangDiem;
	private String hocky;
	private String monhoc;
	private String sotinchi;
	private String diemquatrinh;
	private String diemthi;
	private Context context;
	
	@Inject
	public QuanLyDiemCtr(Context context) {
		super();
		setContext(context);
	}

	@Override
	public int insert(BangDiem obj) {
		int output = 0;
		try {
			output = iBangDiem.insert(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String getHocky() {
		return hocky;
	}
	public void setHocky(String hocky) {
		this.hocky = hocky;
	}
	public String getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	public String getSotinchi() {
		return sotinchi;
	}
	public void setSotinchi(String sotinchi) {
		this.sotinchi = sotinchi;
	}
	public String getDiemquatrinh() {
		return diemquatrinh;
	}
	public void setDiemquatrinh(String diemquatrinh) {
		this.diemquatrinh = diemquatrinh;
	}
	public String getDiemthi() {
		return diemthi;
	}
	public void setDiemthi(String diemthi) {
		this.diemthi = diemthi;
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	@DependsOnStateOf("hocky")
	public boolean isEnabledMonHoc(){
		return !TextUtils.isEmpty(hocky);
	}
	
	@DependsOnStateOf("monhoc")
	public boolean isEnabledSoTinChi(){
		return !TextUtils.isEmpty(monhoc);
	}
	
	@DependsOnStateOf("sotinchi")
	public boolean isEnabledDiemQuaTrinh(){
		return !TextUtils.isEmpty(sotinchi);
	}
	
	@DependsOnStateOf("diemquatrinh")
	public boolean isEnabledDiemThi(){
		return !TextUtils.isEmpty(diemquatrinh);
	}

	public void onClickOk(){
		if(!TextUtils.isEmpty(hocky) && !TextUtils.isEmpty(monhoc) && !TextUtils.isEmpty(sotinchi) && !TextUtils.isEmpty(diemquatrinh) && !TextUtils.isEmpty(diemthi)){
			BangDiem obj = new BangDiem();
			obj.setContext(getContext());
			obj.setHocKy(getHocky());
			obj.setMonHoc(getMonhoc());
			obj.setSoTinChi(Integer.parseInt(getSotinchi()));
			obj.setDiemQuaTrinh(Float.parseFloat(getDiemquatrinh()));
			obj.setDiemThi(Float.parseFloat(getDiemthi()));
			obj.setDataNull();
			
			if(insert(obj) == 1){
				setHocky(null);
				setMonhoc(null);
				setSotinchi(null);
				setDiemquatrinh(null);
				setDiemthi(null);
			}
		}else{
			Toast.makeText(getContext(), R.string.message, Toast.LENGTH_LONG).show();
//			if(TextUtils.isEmpty(hocky)){
//				getHocky();
//			}
			OpenKeyBoard(getContext());
		}
	}
	
	public void onClickCancel() {
		((Activity) getContext()).setResult(Activity.RESULT_OK);
		((Activity) getContext()).finish();
//		List<BangDiem> list = new ArrayList<BangDiem>();
//		try {
//			list = iBangDiem.select();
//			System.out.println(">>>: " + list.size());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	// For open keyboard
	public void OpenKeyBoard(Context mContext) {
		InputMethodManager imm = (InputMethodManager) mContext
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
	}
}

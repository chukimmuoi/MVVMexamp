package chukimmuoi.mvvm.viewmodel.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.robobinding.presentationmodel.DependsOnStateOf;
import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;
import org.robobinding.viewattribute.adapterview.ItemClickEvent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import chukimmuoi.mvvm.constants.Constanst;
import chukimmuoi.mvvm.model.myinterface.IBangDiem;
import chukimmuoi.mvvm.model.table.BangDiem;
import chukimmuoi.mvvm.view.activity.QuanLyDiemActivity;
import chukimmuoi.mvvm.view.adapter.DanhSachBangDiemItem;
import chukimmuoi.mvvm.view.custom.DialogChucNangCustom;
import chukimmuoi.mvvm.viewmodel.myinterface.IDanhSachBangDiem;
import chukimmuoi.mvvm.viewmodel.myinterface.IDialogChucNang;

import com.google.inject.Inject;

@PresentationModel
public class DanhSachBangDiemCtr implements IDanhSachBangDiem, IDialogChucNang{
	@Inject
	private IBangDiem iBangDiem;
	private Context context;
	
	private String timkiem = "";
	@Inject
	public DanhSachBangDiemCtr(Context context) {
		super();
		setContext(context);
	}

	@Override
	public List<BangDiem> select() {
		List<BangDiem> output = new ArrayList<BangDiem>();
		try {
			output = iBangDiem.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public List<BangDiem> searchByMonHoc(BangDiem obj) {
		List<BangDiem> output = new ArrayList<BangDiem>();
		try {
			output = iBangDiem.searchByMonHoc(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

	public String getTimkiem() {
		return timkiem;
	}

	public void setTimkiem(String timkiem) {
		this.timkiem = timkiem;
	}

	public void onClickThemKetQua(){
		Intent intent = new Intent(getContext(), QuanLyDiemActivity.class);
		intent.putExtra("ChucNang", "Them");
		((Activity) getContext()).startActivityForResult(intent, Constanst.REQUEST_CODE_INSERT);
	}
	
	@DependsOnStateOf("timkiem")
	@ItemPresentationModel(DanhSachBangDiemItem.class)
	public List<BangDiem> getListviewValue(){
		BangDiem obj = new BangDiem();
		obj.setMonHoc(getTimkiem());
		return searchByMonHoc(obj);
	}
	
	public void onItemClickListView(ItemClickEvent event){
		DialogChucNangCustom dialog = new DialogChucNangCustom(getContext());
		//TRUYỀN DIALOG
		dialog.setDialog(dialog);
		dialog.show();
	}

	@Override
	public void sua() {
		
	}

	@Override
	public void xoa() {
		
	}

	@Override
	public void xemchitiet() {
		
	}

	@Override
	public void tongkethocky() {
		
	}

	@Override
	public void thoatdialog() {
		
	}

	@Override
	public void thoatungdung() {
		
	}
}

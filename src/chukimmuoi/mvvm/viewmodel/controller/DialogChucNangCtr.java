package chukimmuoi.mvvm.viewmodel.controller;

import java.util.List;

import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;
import org.robobinding.viewattribute.adapterview.ItemClickEvent;

import chukimmuoi.mvvm.constants.DialogEnum;
import chukimmuoi.mvvm.view.adapter.DialogItem;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

@PresentationModel
public class DialogChucNangCtr{
	private Context context;
	private DialogEnum dialog;
	private Dialog d;

	public DialogChucNangCtr(Context context, Dialog dialog){
		super();
		setContext(context);
		//NHẬN GIÁ TRỊ DIALOG
		setD(dialog);
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public DialogEnum getDialog() {
		return dialog;
	}
	public void setDialog(DialogEnum dialog) {
		this.dialog = dialog;
	}
	public Dialog getD() {
		return d;
	}
	public void setD(Dialog d) {
		this.d = d;
	}
	@ItemPresentationModel(DialogItem.class)
	public List<DialogEnum> getListviewValueDialog(){
		return DialogEnum.chucnang();
	}
	
	public void onItemClickListView(ItemClickEvent event){
		switch (event.getPosition()) {
		case 0:
			
			break;
		case 1:
			
			break;
		case 2:
	
			break;
		case 3:
	
			break;
		case 4:
			//SỬ DỤNG DIALOG ĐÃ TRUYỀN.
			getD().dismiss();
			break;
		case 5:
			//SỬ DỤNG DIALOG ĐÃ TRUYỀN.
			getD().dismiss();
			((Activity) getContext()).finish();
			break;
		default:
			break;
		}
	}
}

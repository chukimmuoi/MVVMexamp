package chukimmuoi.mvvm.viewmodel.controller;

import java.util.List;

import org.robobinding.presentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModel;
import org.robobinding.viewattribute.adapterview.ItemClickEvent;

import com.google.inject.Inject;
import chukimmuoi.mvvm.constants.DialogEnum;
import chukimmuoi.mvvm.view.adapter.DialogItem;
import chukimmuoi.mvvm.view.custom.DialogChucNangCustom;
import chukimmuoi.mvvm.viewmodel.myinterface.IDialogChucNang;
import android.app.Activity;
import android.content.Context;

@PresentationModel
public class DialogChucNangCtr extends DanhSachBangDiemCtr implements IDialogChucNang{
	private Context context;
	private DialogEnum dialog;
	private DialogChucNangCustom dialogA;
	
	@Inject
	public DialogChucNangCtr(Context context, DialogChucNangCustom dialogA){
		super(context);
		setContext(context);
		setDialogA(dialogA);
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
	public DialogChucNangCustom getDialogA() {
		return dialogA;
	}
	public void setDialogA(DialogChucNangCustom dialogA) {
		this.dialogA = dialogA;
	}
	@ItemPresentationModel(DialogItem.class)
	public List<DialogEnum> getListviewValueDialog(){
		return DialogEnum.chucnang();
	}
	
	public void onItemClickListView(ItemClickEvent event){
		switch (event.getPosition()) {
		case 0:
			sua();
			break;
		case 1:
			xoa();
			break;
		case 2:
			xemchitiet();
			break;
		case 3:
			tongkethocky();
			break;
		case 4:
			thoatdialog();
			break;
		case 5:
			thoatungdung();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void thoatdialog() {
		//SỬ DỤNG DIALOG ĐÃ TRUYỀN.
		getDialogA().dismiss();
	}
	
	@Override
	public void thoatungdung() {
		//SỬ DỤNG DIALOG ĐÃ TRUYỀN.
		getDialogA().dismiss();
	    ((Activity) getContext()).finish();
	}
}

package chukimmuoi.mvvm.view.custom;

import org.robobinding.binder.Binder;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.viewmodel.controller.DialogChucNangCtr;

public class DialogChucNangCustom extends Dialog{
	private Activity activity;
	private Dialog dialog;
	
	public DialogChucNangCustom(Context context) {
		super(context);
		setActivity(context);
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Context context) {
		this.activity = (Activity) context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DialogChucNangCtr ctrDialogChucNang = new DialogChucNangCtr(getActivity(), getDialog());
		setTitle(R.string.chucnang);
		Binder.bind(this, R.layout.custom_dialog_chucnang, ctrDialogChucNang);
	}

	//TRUYỀN VÀ NHẬN GIÁ TRỊ DIALOG
	public Dialog getDialog() {
		return dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}
}

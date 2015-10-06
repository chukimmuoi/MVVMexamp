package chukimmuoi.mvvm.view.activity;

import org.robobinding.binder.Binder;

import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.constants.Constanst;
import chukimmuoi.mvvm.viewmodel.controller.DanhSachBangDiemCtr;

import com.google.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import roboguice.activity.RoboActionBarActivity;

public class DanhSachBangDiemActivity extends RoboActionBarActivity{
	@Inject
	DanhSachBangDiemCtr ctrDanhSachBangDiem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Binder.bind(this, R.layout.activity_danhsachbangdiem, ctrQuanLyDiem);
		View view = Binder.bindView(this, R.layout.activity_danhsachbangdiem, ctrDanhSachBangDiem);
		setContentView(view);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
			case Constanst.REQUEST_CODE_INSERT:
				
				break;
			default:
				break;
			}
		}
	}
}

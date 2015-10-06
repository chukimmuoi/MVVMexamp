package chukimmuoi.mvvm.view.activity;

import org.robobinding.binder.Binder;

import roboguice.activity.RoboActionBarActivity;
import android.os.Bundle;
import android.view.View;
import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.viewmodel.controller.QuanLyDiemCtr;

import com.google.inject.Inject;

public class QuanLyDiemActivity extends RoboActionBarActivity{
	@Inject
	private QuanLyDiemCtr ctrQuanLyDiem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Binder.bind(this, R.layout.activity_quanlydiem, ctrQuanLyDiem);
		View view = Binder.bindView(this, R.layout.activity_quanlydiem, ctrQuanLyDiem);
		setContentView(view);
	}
}

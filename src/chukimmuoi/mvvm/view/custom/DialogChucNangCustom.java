package chukimmuoi.mvvm.view.custom;

import org.robobinding.binder.Binder;

import roboguice.RoboGuice;
import roboguice.fragment.RoboDialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import chukimmuoi.mvvm.R;
import chukimmuoi.mvvm.viewmodel.controller.DialogChucNangCtr;

public class DialogChucNangCustom extends RoboDialogFragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RoboGuice.getInjector(getActivity()).injectMembersWithoutViews(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		DialogChucNangCtr ctrDialogChucNang = new DialogChucNangCtr(getActivity(), this);
		View view = Binder.bindView(getActivity(), R.layout.custom_dialog_chucnang, ctrDialogChucNang);
		getDialog().setTitle(R.string.chucnang);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		RoboGuice.getInjector(getActivity()).injectViewMembers(this);
	}
}

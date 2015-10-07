package chukimmuoi.mvvm.view.custom;

import roboguice.fragment.RoboDialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import chukimmuoi.mvvm.R;

public class Test extends RoboDialogFragment{
	private ListView listview;
	public Test(Context context) {
		super();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.custom_dialog_chucnang, container);
		 getDialog().setTitle("Hello");
		 listview = (ListView) view.findViewById(R.id.custom_dialog_chucnang_lv);
		 
		 String arr[] = {
					getActivity().getString(R.string.sua), 
					getActivity().getString(R.string.xoa), 
					getActivity().getString(R.string.xemchitiet), 
					getActivity().getString(R.string.tongkethocky), 
					getActivity().getString(R.string.thoatdialog), 
					getActivity().getString(R.string.thoatungdung)};
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
			listview.setAdapter(adapter);
			listview.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					switch (arg2) {
					case 0:

						break;
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					case 4:
						dismiss();
						break;
					case 5:
						dismiss();
						getActivity().finish();
						break;
					default:
						break;
					}
				}
			});
		return view;
	}
}

package chukimmuoi.mvvm.view.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import chukimmuoi.mvvm.R;

public class DialogChucNangCusTest extends Dialog{
	private Activity activity;
	private ListView listview;
	public DialogChucNangCusTest(Context context) {
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
		setContentView(R.layout.custom_dialog_chucnang);
		setTitle(R.string.chucnang);
		listview = (ListView) findViewById(R.id.custom_dialog_chucnang_lv);
		
		String arr[] = {
				getContext().getString(R.string.sua), 
				getContext().getString(R.string.xoa), 
				getContext().getString(R.string.xemchitiet), 
				getContext().getString(R.string.tongkethocky), 
				getContext().getString(R.string.thoatdialog), 
				getContext().getString(R.string.thoatungdung)};
		
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
	}
}

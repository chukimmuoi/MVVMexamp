package chukimmuoi.mvvm;

import roboguice.RoboGuice;
import chukimmuoi.mvvm.utils.database.DatabaseHelper;
import android.app.Application;
import android.content.Context;

public class InitApp extends Application{
	private static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		new DatabaseHelper(getApplicationContext()).getWritableDatabase();
		RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(this), new BaseModule());
		setContext(getApplicationContext());
	}
	public static Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		InitApp.context = context;
	}
}

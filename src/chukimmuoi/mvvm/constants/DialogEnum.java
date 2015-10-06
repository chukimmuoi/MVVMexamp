package chukimmuoi.mvvm.constants;

import java.util.ArrayList;
import java.util.List;
import chukimmuoi.mvvm.InitApp;
import chukimmuoi.mvvm.R;

public enum DialogEnum {
	SUA(R.string.sua), 
	XOA(R.string.xoa), 
	XEM_CHI_TIET(R.string.xemchitiet), 
	TONG_KET_HOC_KY(R.string.tongkethocky), 
	THOAT_DIALOG(R.string.thoatdialog), 
	THOAT_UNG_DUNG(R.string.thoatungdung);
	
	private int resourceId;

    private DialogEnum(int id)  {
        this.resourceId = id;
    }

    @Override
    public String toString() {
        return InitApp.getContext().getString(resourceId);
    }
    
    public static List<DialogEnum> chucnang(){
    	List<DialogEnum> list = new ArrayList<DialogEnum>();
    	list.add(SUA);
    	list.add(XOA);
    	list.add(XEM_CHI_TIET);
    	list.add(TONG_KET_HOC_KY);
    	list.add(THOAT_DIALOG);
    	list.add(THOAT_UNG_DUNG);
    	return list;
    }
}

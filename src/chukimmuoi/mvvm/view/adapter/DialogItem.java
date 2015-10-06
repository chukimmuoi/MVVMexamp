package chukimmuoi.mvvm.view.adapter;

import org.robobinding.itempresentationmodel.ItemPresentationModel;

import chukimmuoi.mvvm.constants.DialogEnum;

public class DialogItem implements ItemPresentationModel<DialogEnum>{
	private DialogEnum obj;
	
	public String getItemDialog(){
		return obj.toString();
	}
	@Override
	public void updateData(int index, DialogEnum obj) {
		this.obj = obj;
	}

}

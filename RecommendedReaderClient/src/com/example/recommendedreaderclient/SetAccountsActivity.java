package com.example.recommendedreaderclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;

enum ServiceName{
	THE_OLD_READER,
	DOUBAN,
	ZHIHU,
}

public class SetAccountsActivity extends Activity{
	private ButtonOk_OnClickListener btnOkListener = new ButtonOk_OnClickListener();
	private ButtonCancel_OnClickListener btnCancelListener = new ButtonCancel_OnClickListener();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Select_OnItemClickListener itemClickListener = new Select_OnItemClickListener();
        
        setContentView(R.layout.set_accounts);
		SimpleAdapter adapter = new SimpleAdapter(this,
				getData(),
				R.layout.login_proxy_accounts_listview,
				new String[]{"img","text"},
				new int[]{R.drawable.theoldreader_logo_icon,R.id.login_proxy_accounts_listview_text});

		ListView listView = (ListView)findViewById(R.id.set_account_listView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(itemClickListener);
		
		//button click
		Button btnOk = (Button)findViewById(R.id.login_proxy_accounts_btnOk);
        Button btnCancel = (Button)findViewById(R.id.login_proxy_accounts_btnCancel);
        
        btnOk.setOnClickListener(btnOkListener);
        btnCancel.setOnClickListener(btnCancelListener);
		
	}
	class ButtonOk_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			//TODO:store info in database or file
			Intent intent = new Intent(SetAccountsActivity.this,MainActivity.class);
			startActivity(intent);
		}
	}
	class ButtonCancel_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent intent = new Intent(SetAccountsActivity.this,LoginActivity.class);
			startActivity(intent);
		}
	}
	
	class Select_OnItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id){
			Intent intent = new Intent();
			intent.setClass(SetAccountsActivity.this, LoginProxyAccountsActivity.class);

			//pass parameters to LoginActivity
			Bundle bundle = new Bundle();

			if(id == ServiceName.THE_OLD_READER.ordinal())
				bundle.putString("serviceName", "theoldreader");
			else if(id == ServiceName.DOUBAN.ordinal())
				bundle.putString("serviceName", "¶¹°ê");
			else if(id == ServiceName.ZHIHU.ordinal())
				bundle.putString("serviceName", "Öªºõ");
			
			intent.putExtras(bundle);
			
		}
		
	}

	private List<Map<String,Object>> getData(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>> ();

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("img",R.drawable.theoldreader_logo_icon);
		map.put("text","the old reader");
		list.add(map);

		map = new HashMap<String,Object>();
		map.put("img",R.drawable.theoldreader_logo_icon);
		map.put("text","¶¹°ê");
		list.add(map);

		map = new HashMap<String,Object>();
		map.put("img",R.drawable.theoldreader_logo_icon);
		map.put("text","Öªºõ");
		list.add(map);

		return list;
	}
   
	
	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_accounts);
        TextView rss = (TextView)findViewById(R.id.checkBox_rss);
        TextView douban = (TextView)findViewById(R.id.checkBox_rss);
        TextView zhihu = (TextView)findViewById(R.id.checkBox_rss);
        
    }

	class CheckboxRss_OnCheckedChangeListener implements OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
			Intent intent = new Intent(SetAccountsActivity.this,LoginActivity.class);
			startActivity(intent);
		}
	}

	class CheckboxDouban_OnCheckedChangeListener implements OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
			Intent intent = new Intent(SetAccountsActivity.this,LoginActivity.class);
			startActivity(intent);
		}
	}	
	
	class CheckboxZhihu_OnCheckedChangeListener implements OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
			Intent intent = new Intent(SetAccountsActivity.this,LoginActivity.class);
			startActivity(intent);
		}
	}	*/
}
	

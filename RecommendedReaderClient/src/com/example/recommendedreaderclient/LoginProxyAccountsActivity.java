package com.example.recommendedreaderclient;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;

public class LoginProxyAccountsActivity extends Activity{
	private ButtonOk_OnClickListener btnOkListener = new ButtonOk_OnClickListener();
	private ButtonCancel_OnClickListener btnCancelListener = new ButtonCancel_OnClickListener();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_proxy_accounts);
        
        //get parameters from previous Activity
        Bundle bundle = getIntent().getExtras();
        String serviceName = bundle.getString("serviceName");
        
        //set title in this Activity
        TextView nameText = (TextView)findViewById(R.id.login_proxy_accounts_TextView);
        nameText.setText(serviceName);

        Button btnOk = (Button)findViewById(R.id.login_proxy_accounts_btnOk);
        Button btnCancel = (Button)findViewById(R.id.login_proxy_accounts_btnCancel);
        
        btnOk.setOnClickListener(btnOkListener);
        btnCancel.setOnClickListener(btnCancelListener);
        
    }
	
	class ButtonOk_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			EditText tvAccount = (EditText)findViewById(R.id.login_proxy_accounts_edtAccount);
			EditText tvPassword = (EditText)findViewById(R.id.login_proxy_accounts_edtPassword);
        
			String account = tvAccount.getText().toString();
			String password = tvPassword.getText().toString();
			//TODO:verify the account&password and store in server
		}
	}
	class ButtonCancel_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent intent = new Intent(LoginProxyAccountsActivity.this,SetAccountsActivity.class);
			startActivity(intent);
		}
	}
}

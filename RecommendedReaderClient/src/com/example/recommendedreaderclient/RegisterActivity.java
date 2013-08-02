package com.example.recommendedreaderclient;



import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class RegisterActivity extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        ButtonReg_OnClickListener btnOkClickListener = new ButtonReg_OnClickListener();
        ButtonCancel_OnClickListener btnCancelClickListener = new ButtonCancel_OnClickListener();
        
        Button btnReg = (Button)findViewById(R.id.register_btnRegister);
        Button btnCancel = (Button)findViewById(R.id.register_btnCancel);
        
        btnReg.setOnClickListener(btnOkClickListener);
        btnCancel.setOnClickListener(btnCancelClickListener);
    }
	
	class ButtonReg_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			EditText tvAccount = (EditText)findViewById(R.id.login_proxy_accounts_edtAccount);
			EditText tvPassword = (EditText)findViewById(R.id.login_proxy_accounts_edtPassword);
        
			String account = tvAccount.getText().toString();
			String password = tvPassword.getText().toString();
			//TODO: register the account, and then go to the LoginProxyAccountsActivity
		}
	}
	class ButtonCancel_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
			startActivity(intent);
		}
	}

}

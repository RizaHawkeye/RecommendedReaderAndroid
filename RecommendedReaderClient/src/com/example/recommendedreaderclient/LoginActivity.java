package com.example.recommendedreaderclient;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;

public class LoginActivity extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        BtnLogin_OnClickListener btnLoginClickListener = new BtnLogin_OnClickListener();
        BtnRegister_OnClickListener btnRegisterClickListener = new BtnRegister_OnClickListener();
        
        Button btnLogin = (Button)findViewById(R.id.login_btnLogin);
        Button btnRegister = (Button)findViewById(R.id.login_btnRegister);
        
        btnLogin.setOnClickListener(btnLoginClickListener);
        btnRegister.setOnClickListener(btnRegisterClickListener);
    }
	
	class BtnLogin_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			EditText tvAccount = (EditText)findViewById(R.id.login_edtAccount);
			EditText tvPassword = (EditText)findViewById(R.id.login_edtPassword);
        
			String account = tvAccount.getText().toString();
			String password = tvPassword.getText().toString();
			//TODO: login the account, if correct then go to the MainActivity
		}
	}
	class BtnRegister_OnClickListener implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
			startActivity(intent);
		}
	}

}

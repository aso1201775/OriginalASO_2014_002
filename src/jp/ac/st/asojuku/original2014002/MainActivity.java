package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements
View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent vIntent = null;
		switch(v.getId()){
		case R.id.btn1:
			vIntent = new Intent(this,MaintenanceActivity.class);
			startActivity(vIntent);
			break;

		case R.id.btn2:
			//エディットテキストから入力内容を取り出す
			EditText etv = (EditText)findViewById(R.id.edtText);
			String inputMsg = etv.getText().toString();
			break;

		case R.id.btn3:
			//エディットテキストから入力内容を取り出す
			vIntent = new Intent(this,HitokotoActivity.class);
			startActivity(vIntent);
			break;
			}
	}

	@Override
	protected void onStart() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStart();
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btn1 = (Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(this);

		Button btn2 = (Button)findViewById(R.id.btn2);
		btn2.setOnClickListener(this);

		Button btn3 = (Button)findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

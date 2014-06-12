package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HitokotoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitokoto_activity);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		// 画面(Activity)に渡されたインテントを取得
		Intent vIntent = this.getIntent();
		// intentから、Extraに混入させた値をキーワードで取得
		String strHitokoto = vIntent.getStringExtra("hitokoto");

		// 取得したStringを、TxtViewにセット
		TextView txvHITOKOTO = (TextView)findViewById(R.id.textView1);
		txvHITOKOTO.setText(strHitokoto);
	}

}

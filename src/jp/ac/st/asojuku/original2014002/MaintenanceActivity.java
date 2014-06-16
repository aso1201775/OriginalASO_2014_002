package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MaintenanceActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

	//SQLiteデータベース空間を操作するインスタンス変数を宣言
	SQLiteDatabase sdb = null;
	//MySQLiteOpenHelperを操作するインスタンス変数を宣言
	MySQLiteOpenHelper helper = null;

	//リストにて選択したHitokotoテーブルのレコードの｢id｣カラム値を保持する変数の宣言
	int selectdID = -1;
	//リストにて選択した行番号を保持する変数の宣言
	int lastPosition = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintenance_activity);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		//各view部品を操作するidを取得
		Button btnDelete = (Button)findViewById(R.id.button1);
		Button btnMainte_Back = (Button)findViewById(R.id.button2);
		ListView lstHitokoto = (ListView)findViewById(R.id.listView1);

		//各ButtonにOnClickListenerをセット
		btnDelete.setOnClickListener(this);
		btnMainte_Back.setOnClickListener(this);

		//ListViewOnItemClickListenerをセット
		lstHitokoto.setOnItemClickListener(this);

		//ListViewにDBの値をセット
		this.setDBvaluetoList(lstHitokoto);
	}


	/**
	 * 引数のListViewにDBのデータをセット
	 * @param lstHitokoto対象となるListView
	 */

	private void setDBvaluetoList(ListView lstHitokoto){

		SQLiteCursor cursor = null;

		//クラスのフィールド変数がNULLなら、データベース空間オープン
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		} catch (SQLiteException e){
			Log.e("ERROR", e.toString());
		}

		cursor = this.helper.selectHitokotoList(sdb);

		int db_layout = android.R.layout.simple_list_item_activated_1;

		String[]from = {"phrase"};

		int[] to = new int[]{android.R.id.text1};

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);

		lstHitokoto.setAdapter(adapter);
	}

}

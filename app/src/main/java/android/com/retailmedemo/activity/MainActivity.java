package android.com.retailmedemo.activity;

import android.annotation.TargetApi;
import android.com.retailmedemo.Modals.DataObject;
import android.com.retailmedemo.R;
import android.com.retailmedemo.adapter.MyRecyclerViewAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements RecyclerView.OnScrollChangeListener{

    private RecyclerView layout_recyclerview = null;
    private MyRecyclerViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * initalizing view elements
     */
    private void init(){
        layout_recyclerview = (RecyclerView) findViewById(R.id.layout_recyclerview);
        layout_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(getDataSet());
        layout_recyclerview.setOnScrollChangeListener(this);

        layout_recyclerview.setAdapter(adapter);


//        layout_nestedscroll.setad
    }


    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }


    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        Log.e("scroll changed", " scrollx "+scrollX+"  scrolly "+scrollY+"  odl scrollx "+oldScrollX+"  oldscrolly "+oldScrollY);
    }
}

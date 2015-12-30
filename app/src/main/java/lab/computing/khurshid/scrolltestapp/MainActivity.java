package lab.computing.khurshid.scrolltestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;


    List<String> numberList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    VerticalSeekBar verticalSeekBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        verticalSeekBar = (VerticalSeekBar) findViewById(R.id.verticalSeekBar);


        for (int i = 0; i < 50; i++) {
            numberList.add("" + i);
        }


        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.fuck_you, numberList);
        listView.setAdapter(adapter);


        verticalSeekBar.setMaximum(numberList.size());
        verticalSeekBar.setMax(numberList.size());
        verticalSeekBar.setProgress(1);

        verticalSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                listView.smoothScrollToPosition(numberList.size() - i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // listView.setScrollContainer(false);

        listView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    return true; // Indicates that this has been handled by you and will not be forwarded further.
                }
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Hello " + i, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

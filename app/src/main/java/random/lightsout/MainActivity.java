package random.lightsout;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class MainActivity extends Activity {

    private final int MAX_ROW = 5;
    private final int MAX_COLUMN = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout_id);


        for (int row = 0; row < MAX_ROW; row++) {

            TableRow tableRow = new TableRow(this);
            tableLayout.addView(tableRow);

            for (int column = 0; column < MAX_COLUMN; column++) {

                final ToggleButton toggleButton = new ToggleButton(this);
                toggleButton.setText(row + "x" + column);
                toggleButton.setTextOff("");
                toggleButton.setTextOn("");
                toggleButton.setTag(row + "," + column);
                tableRow.addView(toggleButton);

            }
        }

        ToggleButton view = (ToggleButton)tableLayout.findViewWithTag("1,3");
        view.setTextOn("Changed!");
*/











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
}

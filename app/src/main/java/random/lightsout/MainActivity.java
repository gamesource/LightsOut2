package random.lightsout;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import random.model.Grid;


public class MainActivity extends Activity {

    private Grid gridInstance;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridInstance = new Grid();
        tableLayout = (TableLayout) findViewById(R.id.table_layout_id);
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

    public void onClick(View v) {
        int row = Integer.parseInt(v.getTag().toString().split(",")[0]);
        int column = Integer.parseInt(v.getTag().toString().split(",")[1]);

        ToggleButton toggleButton = (ToggleButton) tableLayout.findViewWithTag(v.getTag());
        gridInstance.updateState(row, column);

        int fix_row = 1;
        int fix_column = 0;
        for(int index = 0; index < 4; index++) {
            if(gridInstance.isLegal(row + fix_row, column + fix_column)) {
                ToggleButton neighbour = (ToggleButton) tableLayout.findViewWithTag((row + fix_row) + "," + (column + fix_column));
                if(gridInstance.isActive(row + fix_row, column + fix_column)) {
                    neighbour.setChecked(false);
                }
                else {
                    neighbour.setChecked(true);
                }
                gridInstance.updateState(row + fix_row, column + fix_column);


            }
            if(index == 0) {
                fix_row = (-1);
                fix_column = 0;
            }
            else if(index == 1) {
                fix_row = 0;
                fix_column = 1;
            }
            else if(index == 2) {
                fix_row = 0;
                fix_column = (-1);
            }
        }
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

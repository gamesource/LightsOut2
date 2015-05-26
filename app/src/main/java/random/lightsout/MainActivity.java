package random.lightsout;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import random.model.Grid;


public class MainActivity extends Activity {

    private Grid gridInstance;
    private TableLayout tableLayout;

    private final int[][][] sampleGames = {{{1,1,1,0,1},{0,0,1,1,0},{1,0,1,1,0},{1,1,0,0,0},{0,0,0,0,1}},
                                    {{1,1,1,0,0},{1,0,1,0,1},{1,0,1,0,0},{0,0,0,0,1},{1,1,0,0,1}},
                                    {{0,0,0,0,0},{0,1,0,0,1},{1,0,0,1,1},{0,1,0,0,0},{0,0,1,1,0}}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridInstance = new Grid();
        tableLayout = (TableLayout) findViewById(R.id.table_layout_id);

        gridInstance.setNewGame(sampleGames[((int) (Math.random() * 3))]);
    }

    @Override
    protected void onStart() {
        super.onStart();

        boolean[][] newGame = gridInstance.getStates();
        for(int row = 0; row < 5; row++) {
            for(int column = 0; column < 5; column++) {
                ToggleButton toggleButton = (ToggleButton) tableLayout.findViewWithTag(row + "," + column);
                if(newGame[row][column]) {
                    toggleButton.setChecked(true);
                }
                else {
                    toggleButton.setChecked(false);
                }
            }
        }
    }

    public void onClick(View v) {
        String tag = v.getTag().toString();
        int row = Integer.parseInt(tag.split(",")[0]);
        int column = Integer.parseInt(tag.split(",")[1]);

        int fix_row = 0;
        int fix_column = 0;
        for(int index = 0; index < 5; index++) {
            if(gridInstance.isLegal(row + fix_row, column + fix_column)) {
                ToggleButton toggleButton = (ToggleButton) tableLayout.findViewWithTag((row + fix_row) + "," + (column + fix_column));
                if(gridInstance.isActive(row + fix_row, column + fix_column)) {
                    toggleButton.setChecked(false);
                }
                else {
                    toggleButton.setChecked(true);
                }
                gridInstance.updateState(row + fix_row, column + fix_column);
            }

            if(index == 0) {
                fix_row = 1;
                fix_column = 0;
            }
            else if(index == 1) {
                fix_row = (-1);
                fix_column = 0;
            }
            else if(index == 2) {
                fix_row = 0;
                fix_column = 1;
            }
            else if(index == 3) {
                fix_row = 0;
                fix_column = (-1);
            }
        }
        if(isFinished()) {
            Toast.makeText(this,"You win!!!",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isFinished() {

        boolean[][] states = gridInstance.getStates();

        for(int row = 0; row < states.length; row++){
            for(int column = 0; column < states[0].length; column++){
                if(states[row][column]) {
                    return false;
                }
            }
        }

        return true;
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

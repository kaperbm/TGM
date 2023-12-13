package at.ac.tgm.hit.sew7.kboahczyk.rechner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
/**
 * Die Aktivität in der App
 * @author Kacper Bohaczyk
 * @version 2023-10-11
 */
public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    /**
     * Erschaffen des Systems
     * @param savedInstanceState Gespeicherte Instanzzustand
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button myButton = findViewById(R.id.button);
        TextView answer = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operators, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        EditText wert1 = findViewById(R.id.editTextNumberDecimal1);
        EditText wert2 = findViewById(R.id.editTextNumberDecimal2);

        // Wenn das Ergebrapnis berührt wird, wird es zurückgesätzt
        answer.setOnTouchListener(new View.OnTouchListener() {
            /**
             * Löschen von Berechnung
             * @param view Das View
             * @param motionEvent Das Event des Klicks
             * @return false
             */
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TextView answer = findViewById(R.id.textView);
                answer.setText("0");
                answer.setTextColor(Color.parseColor("#FFFFFF"));
                return false;
            }
        });

        // Wenn "Berechnen" geklickt wird, wwird mithilfe der Auswahl berechnet
        myButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Die Berechnung
             * @param v Das View
             */
            @Override
            public void onClick(View v) {
                TextView answer = findViewById(R.id.textView);

                try {

                    double wert1d = Double.parseDouble(wert1.getText().toString());
                    double wert2d = Double.parseDouble(wert2.getText().toString());
                    String checkedOperator = spinner.getSelectedItem().toString();

                    double solution = 0;

                    if (checkedOperator.equals("+")) {// Addition auswählen
                        solution = (wert1d + wert2d);
                        answer.setText(Double.toString(solution));
                    } else if (checkedOperator.equals("-")) {// Subtraktion auswählen
                        solution = (wert1d - wert2d);
                        answer.setText(Double.toString(solution));
                    } else if (checkedOperator.equals("*")) {// Multiplikation auswählen
                        solution = (wert1d * wert2d);
                        answer.setText(Double.toString(solution));
                    } else if (checkedOperator.equals("/")) {
                        if (Integer.parseInt(wert2.getText().toString()) != 0) {
                            solution = (wert1d / wert2d);
                                answer.setText(Double.toString(solution));
                                answer.setText(Double.toString(solution));
                        } else {
                            answer.setText("Error");
                            return; // Exit early if division by zero
                        }
                    }

                    if (solution>0){
                        answer.setTextColor(Color.parseColor("#000000"));
                    } else if (solution<0) {
                        answer.setTextColor(Color.parseColor("#FF0000"));
                    } else {
                        answer.setTextColor(Color.parseColor("#FFFFFF"));
                    }

                } catch (Exception exc){
                    answer.setText(exc.getLocalizedMessage());
                    System.out.println(exc.getLocalizedMessage());
                }
            }
        });

        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Button msButton = findViewById(R.id.button2);

        //Beim Klick des MS-Buttons
        msButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Speichern der Werte
             * @param v das View
             */
            @Override
            public void onClick(View v) {
                // Get the values you want to save
                EditText text1 = findViewById(R.id.editTextNumberDecimal1);
                EditText text2 = findViewById(R.id.editTextNumberDecimal2);
                String wert1t = text1.getText().toString();
                String wert2t = text2.getText().toString();

                // Werte werden gespeichert
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Wert1", wert1t);
                editor.putString("Wert2", wert2t);
                editor.apply();

                // Nachricht das gespeichert wurde
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
            }
        });

        Button mrButton = findViewById(R.id.button3);

        // Beim Klick des MR-Buttons
        mrButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Einsetzen der Werte
             * @param v das View
             */
            @Override
            public void onClick(View v) {
                // gespeicherte Werte ermitteln
                String wert1t = sharedPreferences.getString("Wert1", "");
                String wert2t = sharedPreferences.getString("Wert2", "");
                EditText text1 = findViewById(R.id.editTextNumberDecimal1);
                EditText text2 = findViewById(R.id.editTextNumberDecimal2);

                // Werte einsetzen
                text1.setText(wert1t);
                text2.setText(wert2t);
            }
        });
    }

    /**
     * Berechnen wird grün gemacht
     */
    @Override
    public void onResume(){
        super.onResume();
        Button myButton = findViewById(R.id.button);
        myButton.setBackgroundColor(Color.parseColor("#00FF00"));

    }

    /**
     * Das Menu wird beim Kreieren erscheinen
     * @param menu Das Menü
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Wenn ein Menüpunkt ausgewählt wird
     * @param item Das gedrückte
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 1000014
        // Handle item selection
        int itemId = item.getItemId();
        if (itemId == R.id.action_reset) {
            clear();
            //Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_info) {
            Toast.makeText(getApplicationContext(), "Kacper Bohaczyk\n11/10/23", Toast.LENGTH_SHORT).show();
            return true;
        }
        //Toast.makeText(getApplicationContext(), "OhHellNah!", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    /**
     * Alles wird gecleart
     */
    public void clear(){
        EditText text1 = findViewById(R.id.editTextNumberDecimal1);
        EditText text2 = findViewById(R.id.editTextNumberDecimal2);
        TextView answer = findViewById(R.id.textView);
        spinner.setSelection(0);
        text1.setText("");
        text2.setText("");
        answer.setText("0");
        answer.setTextColor(Color.parseColor("#FFFFFF"));
    }



}
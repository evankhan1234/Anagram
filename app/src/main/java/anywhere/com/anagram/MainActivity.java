package anywhere.com.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView wordTv;
    private EditText edit_first_value;
    private EditText edit_second_value;
    private Button btn_go;
    int len, len1, len2, i, j, found=0, not_found=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordTv =  findViewById(R.id.wordTv);
        edit_first_value =  findViewById(R.id.edit_first_value);
        edit_second_value = findViewById(R.id.edit_second_value);

        btn_go = findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
       // newGame();
    }

    @Override
    public void onClick(View view) {
        newGame();

        }


    private void newGame() {
        String firstValue = edit_first_value.getText().toString();
        String secondValue = edit_second_value.getText().toString();
        len1 = firstValue.length();
        len2 = secondValue.length();

        if(len1 == len2)
        {
            len = len1;
            for(i=0; i<len; i++)
            {
                found = 0;
                for(j=0; j<len; j++)
                {
                    if(firstValue.charAt(i) == secondValue.charAt(j))
                    {
                        found = 1;
                        break;
                    }
                }
                if(found == 0)
                {
                    not_found = 1;
                    break;
                }
            }
            if(not_found == 1)
            {

                wordTv.setText("Values are not Anagram to Each Other..!!");
                edit_first_value.setText("");
                edit_second_value.setText("");
            }
            else
            {

                wordTv.setText("Values are Anagram");
                edit_first_value.setText("");
                edit_second_value.setText("");
            }
        }
        else
        {


            wordTv.setText("Must have the same number of Character");
            edit_first_value.setText("");
            edit_second_value.setText("");
        }


    }
}

package com.example.instant_search.View;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.instant_search.Model.ItemClicked;
import com.example.instant_search.R;
import com.example.instant_search.View.Adapters.PagerAdapter;
import com.example.instant_search.View.Fragments.HistoryFragment;
import com.example.instant_search.View.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements ItemClicked {


    EditText text_search_area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();

         window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

         window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.my_statusbar_color));
        }


         inflateFragment(new HistoryFragment());

        text_search_area = findViewById(R.id.text_search_area);



        text_search_area.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()==0){
                    inflateFragment(new HistoryFragment());
                }else {
                    inflateFragment(new SearchFragment());
                }

            }
        });

    }

    private void inflateFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public String getSearchPhrase(){
        return text_search_area.getText().toString();
    }

    @Override
    public void onClickedPosition(String phrase) {
        text_search_area.setText(phrase);
        inflateFragment(new SearchFragment());
    }

    @Override
    public void onClicked(int position) {

    }
}

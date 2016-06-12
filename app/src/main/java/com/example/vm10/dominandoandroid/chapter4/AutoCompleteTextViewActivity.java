package com.example.vm10.dominandoandroid.chapter4;

import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.widget.ArrayAdapter;

import com.example.vm10.dominandoandroid.BaseActivity;
import com.example.vm10.dominandoandroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoCompleteTextViewActivity extends BaseActivity {

    @BindView(R.id.actvSearchCity)
    AppCompatAutoCompleteTextView actvSearchCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        ButterKnife.bind(this);

        List<String> list = new ArrayList(20) {
            {
                add("Rio Branco"); add("Maceió"); add("Macapá"); add("Manaus"); add("Salvador");
                add("Fortaleza"); add("Brasília"); add("Vitória"); add("Goiânia"); add("São Luís"); add("Cuiabá");
                add("Campo Grande"); add("Belo Horizonte"); add("Belém"); add("João Pessoa"); add("Curitiba");
                add("Recife"); add("Teresina"); add("Rio de Janeiro"); add("Natal"); add("Porto Alegre"); add("Porto Velho");
                add("Boa Vista"); add("Florianópolis"); add("São Paulo"); add("Aracaju"); add("Palmas");
            }
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, list);
        actvSearchCity.setAdapter(adapter);
    }
}

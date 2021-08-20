package com.guru.alphabetslb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.guru.alphabetslb.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Provider_Alphabet> arraylist_alpha = new ArrayList<>();
    private Activity mthis = MainActivity.this;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private GlobalVariable variable;
    private Dialog progress;
    private Adapter_Alphabet adapterAlphabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSettings();
        view();
        collectData();



    }

    private void setSettings() {
        variable = ((GlobalVariable)mthis.getApplicationContext());
//        okhttpClient = variable.HttpClient(okhttpClient);

        pref = PreferenceManager.getDefaultSharedPreferences(mthis);
        editor = pref.edit();

        progress = variable.progressDialog(progress, mthis);
    }

    void view()
    {

        binding.tvCari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(binding.tvCari.getText().length() == 0)
                {
                    arraylist_alpha.clear();
                    collectData();
                }else {
                    runsearch();
                }
            }
        });


        binding.listAlphabet.setLayoutManager(new LinearLayoutManager(mthis, LinearLayoutManager.VERTICAL, false));
        adapterAlphabet = new Adapter_Alphabet(mthis,mthis, arraylist_alpha);
        binding.listAlphabet.setAdapter(adapterAlphabet);
    }

    void runsearch()
    {
        Provider_Alphabet newprov = null;

        for(Provider_Alphabet prov : arraylist_alpha){
            if(prov.getKeyword().contains(binding.tvCari.getText().toString()))
            {
//                Toast.makeText(mthis, ""+prov.getAlpha_img(), Toast.LENGTH_SHORT).show();
                newprov = new Provider_Alphabet(prov.getNama(),prov.getKeyword(),prov.getAlpha_img());

            }
        }

        if(newprov == null)
        {
            arraylist_alpha.clear();
            Toast.makeText(mthis, "Tidak ditemukan", Toast.LENGTH_SHORT).show();
        }else
        {

            arraylist_alpha.clear();
            arraylist_alpha.add(newprov);
        }

        adapterAlphabet.notifyDataSetChanged();
    }

    void collectData()
    {
        Provider_Alphabet prova = new Provider_Alphabet("a","a",R.drawable.a);
        arraylist_alpha.add(prova);

        Provider_Alphabet provb = new Provider_Alphabet("b","b",R.drawable.b);
        arraylist_alpha.add(provb);

        Provider_Alphabet provc = new Provider_Alphabet("c","c",R.drawable.c);
        arraylist_alpha.add(provc);

        Provider_Alphabet provd = new Provider_Alphabet("d","d",R.drawable.d);
        arraylist_alpha.add(provd);

        Provider_Alphabet prove = new Provider_Alphabet("e","e",R.drawable.e);
        arraylist_alpha.add(prove);

        Provider_Alphabet provf = new Provider_Alphabet("f","f",R.drawable.f);
        arraylist_alpha.add(provf);

        Provider_Alphabet provg = new Provider_Alphabet("g","g",R.drawable.g);
        arraylist_alpha.add(provg);

        Provider_Alphabet provh = new Provider_Alphabet("h","h",R.drawable.h);
        arraylist_alpha.add(provh);

        Provider_Alphabet provi = new Provider_Alphabet("i","i",R.drawable.i);
        arraylist_alpha.add(provi);

        Provider_Alphabet provj = new Provider_Alphabet("j","j",R.drawable.j);
        arraylist_alpha.add(provj);

        Provider_Alphabet provk = new Provider_Alphabet("k","k",R.drawable.k);
        arraylist_alpha.add(provk);

        Provider_Alphabet provl = new Provider_Alphabet("l","l",R.drawable.l);
        arraylist_alpha.add(provl);

        Provider_Alphabet provm = new Provider_Alphabet("m","m",R.drawable.m);
        arraylist_alpha.add(provm);

        Provider_Alphabet provn = new Provider_Alphabet("n","n",R.drawable.n);
        arraylist_alpha.add(provn);

        Provider_Alphabet provo = new Provider_Alphabet("o","o",R.drawable.o);
        arraylist_alpha.add(provo);

        Provider_Alphabet provp = new Provider_Alphabet("p","p",R.drawable.p);
        arraylist_alpha.add(provp);

//        Provider_Alphabet provq = new Provider_Alphabet("q","q",R.drawable.q);
//        alpha_img.add(provq);

        Provider_Alphabet provr = new Provider_Alphabet("r","r",R.drawable.r);
        arraylist_alpha.add(provr);

        Provider_Alphabet provs = new Provider_Alphabet("s","s",R.drawable.s);
        arraylist_alpha.add(provs);

        Provider_Alphabet provt = new Provider_Alphabet("t","t",R.drawable.t);
        arraylist_alpha.add(provt);

        Provider_Alphabet provu = new Provider_Alphabet("u","u",R.drawable.u);
        arraylist_alpha.add(provu);

        Provider_Alphabet provv = new Provider_Alphabet("v","v",R.drawable.v);
        arraylist_alpha.add(provv);

        Provider_Alphabet provw = new Provider_Alphabet("w","w",R.drawable.w);
        arraylist_alpha.add(provw);

//        Provider_Alphabet provx = new Provider_Alphabet("x","x",R.drawable.x);
//        alpha_img.add(provx);

//        Provider_Alphabet provy = new Provider_Alphabet("y","y",R.drawable.y);
//        alpha_img.add(provy);

//        Provider_Alphabet provz = new Provider_Alphabet("z","z",R.drawable.z);
//        alpha_img.add(provz);

        adapterAlphabet.notifyDataSetChanged();

    }
}
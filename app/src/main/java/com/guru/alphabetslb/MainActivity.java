package com.guru.alphabetslb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.guru.alphabetslb.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Provider_Alphabet> arraylist_alpha_img = new ArrayList<>();
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
        binding.listAlphabet.setLayoutManager(new LinearLayoutManager(mthis, LinearLayoutManager.VERTICAL, false));
        adapterAlphabet = new Adapter_Alphabet(mthis,mthis, arraylist_alpha_img);
        binding.listAlphabet.setAdapter(adapterAlphabet);
    }

    void collectData()
    {
        Provider_Alphabet prova = new Provider_Alphabet("a","a",R.drawable.a);
        arraylist_alpha_img.add(prova);

        Provider_Alphabet provb = new Provider_Alphabet("b","b",R.drawable.b);
        arraylist_alpha_img.add(provb);

        Provider_Alphabet provc = new Provider_Alphabet("c","c",R.drawable.c);
        arraylist_alpha_img.add(provc);

        Provider_Alphabet provd = new Provider_Alphabet("d","d",R.drawable.d);
        arraylist_alpha_img.add(provd);

        Provider_Alphabet prove = new Provider_Alphabet("e","e",R.drawable.e);
        arraylist_alpha_img.add(prove);

        Provider_Alphabet provf = new Provider_Alphabet("f","f",R.drawable.f);
        arraylist_alpha_img.add(provf);

        Provider_Alphabet provg = new Provider_Alphabet("g","g",R.drawable.g);
        arraylist_alpha_img.add(provg);

        Provider_Alphabet provh = new Provider_Alphabet("h","h",R.drawable.h);
        arraylist_alpha_img.add(provh);

        Provider_Alphabet provi = new Provider_Alphabet("i","i",R.drawable.i);
        arraylist_alpha_img.add(provi);

        Provider_Alphabet provj = new Provider_Alphabet("j","j",R.drawable.j);
        arraylist_alpha_img.add(provj);

        Provider_Alphabet provk = new Provider_Alphabet("k","k",R.drawable.k);
        arraylist_alpha_img.add(provk);

        Provider_Alphabet provl = new Provider_Alphabet("l","l",R.drawable.l);
        arraylist_alpha_img.add(provl);

        Provider_Alphabet provm = new Provider_Alphabet("m","m",R.drawable.m);
        arraylist_alpha_img.add(provm);

        Provider_Alphabet provn = new Provider_Alphabet("n","n",R.drawable.n);
        arraylist_alpha_img.add(provn);

        Provider_Alphabet provo = new Provider_Alphabet("o","o",R.drawable.o);
        arraylist_alpha_img.add(provo);

        Provider_Alphabet provp = new Provider_Alphabet("p","p",R.drawable.p);
        arraylist_alpha_img.add(provp);

//        Provider_Alphabet provq = new Provider_Alphabet("q","q",R.drawable.q);
//        alpha_img.add(provq);

        Provider_Alphabet provr = new Provider_Alphabet("r","r",R.drawable.r);
        arraylist_alpha_img.add(provr);

        Provider_Alphabet provs = new Provider_Alphabet("s","s",R.drawable.s);
        arraylist_alpha_img.add(provs);

        Provider_Alphabet provt = new Provider_Alphabet("t","t",R.drawable.t);
        arraylist_alpha_img.add(provt);

        Provider_Alphabet provu = new Provider_Alphabet("u","u",R.drawable.u);
        arraylist_alpha_img.add(provu);

        Provider_Alphabet provv = new Provider_Alphabet("v","v",R.drawable.v);
        arraylist_alpha_img.add(provv);

        Provider_Alphabet provw = new Provider_Alphabet("w","w",R.drawable.w);
        arraylist_alpha_img.add(provw);

//        Provider_Alphabet provx = new Provider_Alphabet("x","x",R.drawable.x);
//        alpha_img.add(provx);

//        Provider_Alphabet provy = new Provider_Alphabet("y","y",R.drawable.y);
//        alpha_img.add(provy);

//        Provider_Alphabet provz = new Provider_Alphabet("z","z",R.drawable.z);
//        alpha_img.add(provz);

        adapterAlphabet.notifyDataSetChanged();

    }
}
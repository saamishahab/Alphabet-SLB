package com.guru.alphabetslb;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.guru.alphabetslb.databinding.CustomAlphabetBinding;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;

public class Adapter_Alphabet extends RecyclerView.Adapter<Adapter_Alphabet.MyViewHolder>{
    private final LayoutInflater mInflater;
    Context mContext;
    Activity mActivity;
    private List<Provider_Alphabet> assList;
    private GlobalVariable variable;
    private OkHttpClient okhttpClient;
    private Dialog progress;
    private DecimalFormat kursIndonesia;
    private String currdate,currtime;
    private DatePickerDialog.OnDateSetListener date;
    private ArrayList<String> availableTable = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder{


        CustomAlphabetBinding binding;

        public MyViewHolder(CustomAlphabetBinding view)
        {
            super(view.getRoot());
            binding = view;
        }
    }

    public Adapter_Alphabet(Context ctx, Activity act, List<Provider_Alphabet> items)
    {
        this.assList = items;
        this.mContext = ctx;
        this.mActivity = act;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MyViewHolder(CustomAlphabetBinding.inflate(mInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){

        setSettings(mActivity);

        final Provider_Alphabet item = assList.get(position);
        holder.binding.alphaImg.setImageResource(item.getAlpha_img());

//        holder.binding.alphaImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                variable.alertDialog(mActivity, true, true, "Reservasi atas nama "+item.getNama().toUpperCase()+" akan segera dimulai.", "Proses", "Tidak", new GlobalVariable.DialogSingleButtonListener() {
//                    @Override
//                    public void onButtonClicked(int id) {
//                        if(id>0)
//                        {
//                            AlertDialog alertDialog = new AlertDialog.Builder(mActivity).create();
//                            alertDialog.setMessage("Mohon konfirmasi kembali, apakah benar reservasi atas nama "+item.getNama().toUpperCase()+" ?");
//                            alertDialog.setCancelable(false);
//                            alertDialog.setCanceledOnTouchOutside(false);
//                            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ya",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            dialog.dismiss();
//
////                                            updateCheckStatus("Dining",item.getId_trans());
//                                        }
//                                    });
//                            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tidak",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            dialog.dismiss();
//                                        }
//                                    });
//                            alertDialog.show();
//                        }
//                    }
//                });
//            }
//        });

    }




    @Override
    public int getItemCount(){
        return assList.size();
    }


    void setSettings(Activity act)
    {

        kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.JAPAN);
        final DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator('.');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        currdate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        currtime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

        variable = ((GlobalVariable)mContext.getApplicationContext());
        okhttpClient = variable.HttpClient(okhttpClient);

        progress = variable.progressDialog(progress, act);
    }



}
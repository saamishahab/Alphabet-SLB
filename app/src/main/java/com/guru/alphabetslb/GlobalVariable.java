package com.guru.alphabetslb;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class GlobalVariable extends Application {

    public static String ipaddressed = "192.168.88.232:5082";
//    public static String ipaddressed = "dev.3guru.com:5082";
    private AlertDialog alertDialog;
    private AlertDialog alerterrorDialog;

    public static String getIpaddressed() {
        return "http://"+ipaddressed+"/hachi/";
    }

    public static void setIpaddressed(String ipaddressed) {
        GlobalVariable.ipaddressed = ipaddressed;
    }

    public static String URL = "http://"+ipaddressed+"/hachi/alacarte.php/";

    public Dialog progressDialog(Dialog progress, Activity ctx)
    {
        progress = new Dialog(ctx);
        progress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progress.setCancelable(false);
        progress.setContentView(R.layout.progressdialog);
        progress.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        return progress;
    }

    public OkHttpClient HttpClient(OkHttpClient okHttpClient)
    {
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }

    public interface DialogSingleButtonListener {
        void onButtonClicked(int id);
    }

    public void alertDialog(Activity act,boolean cancel,boolean outsideDismiss, String message, String pos_message,String neg_message,final GlobalVariable.DialogSingleButtonListener dialogSingleButtonListener) {

        AlertDialog.Builder alt = new AlertDialog.Builder(act);
        alt.setMessage(message);
        alt.setCancelable(cancel);
        act.setFinishOnTouchOutside(outsideDismiss);
        alt.setPositiveButton(pos_message,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        dialogSingleButtonListener.onButtonClicked(1);
                    }
                });

        alt.setNegativeButton(neg_message,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        dialogSingleButtonListener.onButtonClicked(0);
                    }
                });

        AlertDialog alert = alt.create();
        alert.show();
    }

    public void messagedialog(Context ctx, String successOrerror ,String errorcode, String body, String detail)  {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setMessage(successOrerror +" "+errorcode+"\n"+body+"\n"+detail);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void errordialog(Context ctx, String successOrerror ,String errorcode, String body, String detail)  {
        alerterrorDialog = new AlertDialog.Builder(ctx).create();
        alerterrorDialog.setMessage(successOrerror +" "+errorcode+"\n"+body+"\n"+detail);
        alerterrorDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alerterrorDialog.show();
    }

    public void dialogerrorDimissed(){

        if(alerterrorDialog != null) {
            alerterrorDialog.dismiss();
        }
    }

    public void dialogDimissed(){

        if(alertDialog != null) {
            alertDialog.dismiss();
        }
    }

}

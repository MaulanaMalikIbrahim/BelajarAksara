package com.abim.belajaraksara;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class PretestSwaraActivity1 extends AppCompatActivity implements View.OnClickListener {
    Context ctx;
    Class[] c = new Class[8];
    Random r = new Random();
    AlertDialog dialog;
    PretestAngka p;
    int count, nilai;
    String key = "pretest_swara";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretest_swara1);

        ctx  = this;

        c[0] = PretestSwaraActivity9.class;
        c[1] = PretestSwaraActivity2.class;
        c[2] = PretestSwaraActivity3.class;
        c[3] = PretestSwaraActivity4.class;
        c[4] = PretestSwaraActivity5.class;
        c[5] = PretestSwaraActivity6.class;
        c[6] = PretestSwaraActivity7.class;
        c[7] = PretestSwaraActivity8.class;

        setTitle();
    }

    private void setTitle(){
        int num = getSharedPreferences(key, MODE_PRIVATE).getInt("count", 0) + 1;
        getSupportActionBar().setTitle("Soal Nomor " + String.valueOf(num));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), SwaraActivity.class));
        finish();
    }

    void ins(String s){
        DBHelper helper = new DBHelper(ctx);
        SQLiteDatabase db;
        db = helper.getWritableDatabase();
        String query = "insert into hasil values(null, 'pretest_swara', '"+s+"')";
        db.execSQL(query);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        SharedPreferences.Editor editor = getSharedPreferences(key, MODE_PRIVATE).edit();
        nilai = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
        count = getSharedPreferences(key, MODE_PRIVATE).getInt("count", 0);
        if (id == R.id.a){
            dialog = new AlertDialog.Builder(ctx).create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setTitle("Benar");
            dialog.setMessage("Jawaban Kamu Benar");
            editor.putInt("nilai", nilai + 10).commit();
            editor.putInt("count", count + 1).commit();
            dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Lanjutkan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (getSharedPreferences(key, MODE_PRIVATE).getInt("count", 0) < 10){
                        startActivity(new Intent(getApplicationContext(), c[r.nextInt(c.length)]));
                    }
                    else{
                        dialog = new AlertDialog.Builder(ctx).create();
                        int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                        if (n > 100){
                            n = 100;
                        }
                        dialog.setTitle("Latihan Selesai");
                        dialog.setMessage("Nilai Kamu " + String.valueOf(n));
                        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                                if (n > 100){
                                    n = 100;
                                }
                                ins(String.valueOf(n));
                                startActivity(new Intent(getApplicationContext(), SwaraActivity.class));
                            }
                        });
                        dialog.show();
                    }
                }
            });
            dialog.show();
        }
        else if (id == R.id.b){
            dialog = new AlertDialog.Builder(ctx).create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setTitle("Salah");
            dialog.setMessage("Jawaban Kamu Salah");
            editor.putInt("nilai", nilai + 0).commit();
            editor.putInt("count", count + 1).commit();
            dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Lanjutkan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (getSharedPreferences(key, MODE_PRIVATE).getInt("count", 0) < 10){
                        startActivity(new Intent(getApplicationContext(), c[r.nextInt(c.length)]));
                    }
                    else{
                        dialog = new AlertDialog.Builder(ctx).create();
                        int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                        if (n > 100){
                            n = 100;
                        }
                        dialog.setTitle("Latihan Selesai");
                        dialog.setMessage("Nilai Kamu " + String.valueOf(n));
                        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                                if (n > 100){
                                    n = 100;
                                }
                                ins(String.valueOf(n));
                                startActivity(new Intent(getApplicationContext(), SwaraActivity.class));
                            }
                        });
                        dialog.show();
                    }
                }
            });
            dialog.show();
        }
        else if (id == R.id.c){
            dialog = new AlertDialog.Builder(ctx).create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setTitle("Salah");
            dialog.setMessage("Jawaban Kamu Salah");
            editor.putInt("nilai", nilai + 0).commit();
            editor.putInt("count", count + 1).commit();
            dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Lanjutkan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (getSharedPreferences(key, MODE_PRIVATE).getInt("count", 0) < 10){
                        startActivity(new Intent(getApplicationContext(), c[r.nextInt(c.length)]));
                    }
                    else{
                        dialog = new AlertDialog.Builder(ctx).create();
                        int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                        if (n > 100){
                            n = 100;
                        }
                        dialog.setTitle("Latihan Selesai");
                        dialog.setMessage("Nilai Kamu " + String.valueOf(n));
                        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int n = getSharedPreferences(key, MODE_PRIVATE).getInt("nilai", 0);
                                if (n > 100){
                                    n = 100;
                                }
                                ins(String.valueOf(n));
                                startActivity(new Intent(getApplicationContext(), SwaraActivity.class));
                            }
                        });
                        dialog.show();
                    }
                }
            });
            dialog.show();
        }
    }
}
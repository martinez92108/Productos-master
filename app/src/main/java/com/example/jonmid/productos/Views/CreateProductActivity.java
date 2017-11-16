package com.example.jonmid.productos.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.productos.Helpers.SqliteHelper;
import com.example.jonmid.productos.IndexActivity;
import com.example.jonmid.productos.R;
import com.example.jonmid.productos.Utilities.ConstantsUtilities;

public class CreateProductActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextImage;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        sqliteHelper = new SqliteHelper(this, "bd_products", null, 1);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tiet_new_name);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tiet_new_description);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tiet_new_price);
        textInputEditTextImage = (TextInputEditText) findViewById(R.id.id_tiet_new_image);
    }

    public void createProduct(View view){
        String stringname = textInputEditTextName.getText().toString();
        String stringdes=textInputEditTextDescription.getText().toString();
        String stingpre = textInputEditTextPrice.getText().toString();
        String stringimg=textInputEditTextImage.getText().toString();


        if (TextUtils.isEmpty(stringname)){
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringdes)){
            Toast.makeText(this, "El campo de  descripcion vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stingpre)){
            Toast.makeText(this, "El campo de precio esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringimg)) {
            Toast.makeText(this, "El campo de imagen esta vacio", Toast.LENGTH_SHORT).show();
        }
        else{
            createUser();
        }


    }



    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_NAME,textInputEditTextName.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_DESCRIPTION,textInputEditTextDescription.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_PRICE,textInputEditTextPrice.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_IMAGE,textInputEditTextImage.getText().toString());





        Long idResult = db.insert(ConstantsUtilities.TABLE_NAME_PRODUCTS, ConstantsUtilities.TABLE_FIELD_PRODUCTS_ID, values);


        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);
    }
























}

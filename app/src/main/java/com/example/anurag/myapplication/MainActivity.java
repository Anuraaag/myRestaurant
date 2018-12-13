package com.example.anurag.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch vegOnly, containEgg;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6;
    TextView tv1, tv2, tv3, tv4, tv5, tv6;                      // quantity
    TextView label1, label2, label3, label4, label5, label6;    // cuisine name
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12;
    Button order;
    LinearLayout layer1, layer2, layer3, layer4, layer5, layer6;
    LinearLayout row1, row2, row3, row4, row5, row6;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row1 = findViewById(R.id.row1);
        row2 = findViewById(R.id.row2);
        row3 = findViewById(R.id.row3);
        row4 = findViewById(R.id.row4);
        row5 = findViewById(R.id.row5);
        row6 = findViewById(R.id.row6);


        layer1 = findViewById(R.id.layer1);
        layer2 = findViewById(R.id.layer2);
        layer3 = findViewById(R.id.layer3);
        layer4 = findViewById(R.id.layer4);
        layer5 = findViewById(R.id.layer5);
        layer6 = findViewById(R.id.layer6);

        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);
        label3 = findViewById(R.id.label3);
        label4 = findViewById(R.id.label4);
        label5 = findViewById(R.id.label5);
        label6 = findViewById(R.id.label6);

        vegOnly = findViewById(R.id.vegOnly);
        containEgg = findViewById(R.id.containEgg);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt10 = findViewById(R.id.bt10);
        bt11 = findViewById(R.id.bt11);
        bt12 = findViewById(R.id.bt12);

        order = findViewById(R.id.order);

        layer1.setVisibility(View.GONE);
        layer2.setVisibility(View.GONE);
        layer3.setVisibility(View.GONE);
        layer4.setVisibility(View.GONE);
        layer5.setVisibility(View.GONE);
        layer6.setVisibility(View.GONE);

        containEgg.setVisibility(View.GONE);


        vegOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    containEgg.setVisibility(View.VISIBLE);
                    containEgg.setChecked(false);

                    for (int i = 1; i <= 6; i += 1)
                    {
                        String temp = "label".concat(String.valueOf(i));
                        int id = getResources().getIdentifier(temp, "id", getPackageName());
                        TextView tv = findViewById(id);
                        if( tv.getText().toString().charAt(0) == 'N' || tv.getText().toString().charAt(0) == 'E' ) {

                            temp = "cb".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp,"id", getPackageName());
                            CheckBox cb = findViewById(id);
                            cb.setChecked(false);

                            temp = "layer".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            LinearLayout ll = findViewById(id);
                            ll.setVisibility(View.GONE);

                            temp = "row".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            ll = findViewById(id);
                            ll.setVisibility(View.GONE);
                        }
                    }
                }
                else
                {
                    containEgg.setVisibility(View.INVISIBLE);

                    for (int i = 1; i <= 6; i += 1)
                    {
                        String temp = "row".concat(String.valueOf(i));
                        int id = getResources().getIdentifier(temp, "id", getPackageName());
                        LinearLayout ll = findViewById(id);
                        ll.setVisibility(View.VISIBLE);
                    }

                }
            }
        });


        containEgg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    for (int i = 1; i <= 6; i += 1)
                    {
                        String temp = "label".concat(String.valueOf(i));
                        int id = getResources().getIdentifier(temp, "id", getPackageName());
                        TextView tv = findViewById(id);
                        if( tv.getText().toString().charAt(0) == 'E' ) {

                            temp = "row".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            LinearLayout ll = findViewById(id);
                            ll.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else
                {
                    for (int i = 1; i <= 6; i += 1)
                    {
                        String temp = "label".concat(String.valueOf(i));
                        int id = getResources().getIdentifier(temp, "id", getPackageName());
                        TextView tv = findViewById(id);

                        if (tv.getText().toString().charAt(0) == 'E') {

                            temp = "cb".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            CheckBox cb = findViewById(id);
                            cb.setChecked(false);

                            temp = "layer".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            LinearLayout ll = findViewById(id);
                            ll.setVisibility(View.GONE);

                            temp = "row".concat(String.valueOf(i));
                            id = getResources().getIdentifier(temp, "id", getPackageName());
                            ll = findViewById(id);
                            ll.setVisibility(View.GONE);
                        }
                    }
                }
            }
        });



        cb1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb1.isChecked()) {
                    layer1.setVisibility(View.VISIBLE);
                    tv1.setText("1");
                }
                else{
                    layer1.setVisibility(View.GONE);
                }
            }
        });


        cb2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb2.isChecked()) {
                    layer2.setVisibility(View.VISIBLE);
                    tv2.setText("1");
                }
                else{
                    layer2.setVisibility(View.GONE);
                }
            }
        });

        cb3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb3.isChecked()) {
                    layer3.setVisibility(View.VISIBLE);
                    tv3.setText("1");
                }
                else{
                    layer3.setVisibility(View.GONE);
                }
            }
        });

        cb4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb4.isChecked()) {
                    layer4.setVisibility(View.VISIBLE);
                    tv4.setText("1");
                }
                else{
                    layer4.setVisibility(View.GONE);
                }
            }
        });

        cb5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb5.isChecked()) {
                    layer5.setVisibility(View.VISIBLE);
                    tv5.setText("1");
                }
                else{
                    layer5.setVisibility(View.GONE);
                }
            }
        });

        cb6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(cb6.isChecked()) {
                    layer6.setVisibility(View.VISIBLE);
                    tv6.setText("1");
                }
                else{
                    layer6.setVisibility(View.GONE);

                }
            }
        });

// first row of orders in xml
        tv1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv1.getText().toString()) < 1)
                {
                    bt2.setEnabled(false);
                }
                else{
                    bt2.setEnabled(true);
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv1.getText().toString());
                quantity += 1;
                tv1.setText(String.valueOf(quantity));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv1.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv1.setText(String.valueOf(quantity));
                }
            }
        });

// Second row of orders in xml
        tv2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv2.getText().toString()) < 1)
                {
                    bt4.setEnabled(false);
                }
                else{
                    bt4.setEnabled(true);
                }

            }
        });

        bt3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv2.getText().toString());
                quantity += 1;
                tv2.setText(String.valueOf(quantity));
            }
        });

        bt4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv2.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv2.setText(String.valueOf(quantity));
                }
            }
        });


// Third row of orders in xml
        tv3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv3.getText().toString()) < 1)
                {
                    bt6.setEnabled(false);
                }
                else
                {
                    bt6.setEnabled(true);
                }

            }
        });

        bt5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv3.getText().toString());
                quantity += 1;
                tv3.setText(String.valueOf(quantity));
            }
        });

        bt6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv3.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv3.setText(String.valueOf(quantity));
                }
            }
        });


// fourth row of orders in xml
        tv4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv4.getText().toString()) < 1)
                {
                    bt8.setEnabled(false);
                }
                else{
                    bt8.setEnabled(true);
                }

            }
        });

        bt7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv4.getText().toString());
                quantity += 1;
                tv4.setText(String.valueOf(quantity));
            }
        });

        bt8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv4.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv4.setText(String.valueOf(quantity));
                }
            }
        });


// fifth row of orders in xml
        tv5.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv5.getText().toString()) < 1)
                {
                    bt10.setEnabled(false);
                }
                else{
                    bt10.setEnabled(true);
                }

            }
        });

        bt9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv5.getText().toString());
                quantity += 1;
                tv5.setText(String.valueOf(quantity));
            }
        });

        bt10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv5.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv5.setText(String.valueOf(quantity));
                }
            }
        });



// Sixth row of orders in xml
        tv6.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Integer.parseInt(tv6.getText().toString()) < 1)
                {
                    bt12.setEnabled(false);
                }
                else{
                    bt12.setEnabled(true);
                }

            }
        });

        bt11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                quantity = Integer.parseInt(tv6.getText().toString());
                quantity += 1;
                tv6.setText(String.valueOf(quantity));
            }
        });

        bt12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                quantity = Integer.parseInt(tv6.getText().toString());
                if(quantity > 0)
                {
                    quantity -= 1;
                    tv6.setText(String.valueOf(quantity));
                }
            }
        });

        order.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                int quantity = 0;
                String temp;
                for(int i = 1; i <= 6; i += 1)
                {
                    temp = "cb".concat(String.valueOf(i));
                    int id = getResources().getIdentifier(temp, "id", getPackageName());
                    CheckBox cb = findViewById(id);

                    if (cb.isChecked() )
                    {
                        temp = "tv".concat(String.valueOf(i));
                        id = getResources().getIdentifier(temp, "id", getPackageName());
                        TextView tv = findViewById(id);
                        quantity += Integer.parseInt(tv.getText().toString());
                    }
                }
                quantity *= 100;
                temp = Integer.toString(quantity);
//              temp = "" + quantity;
                Toast.makeText(MainActivity.this, "Total amount \n Rs."+temp, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Confirming Order", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Order placed successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


package com.example.mycalci;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.mariuszgromada.math.mxparser.*;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.os.Vibrator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity2 extends AppCompatActivity {
    EditText display;
    TextView display2;
    ConstraintLayout layout;
    Vibrator Vibrator;
    android.os.VibrationEffect VibrationEffect;
    ImageButton uiBTN;
    int item_selection=0;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout=findViewById(R.id.lay);
        uiBTN = findViewById(R.id.uiBTN);

        display=findViewById(R.id.textarea);
        display.setShowSoftInputOnFocus(false);
        display2=findViewById(R.id.textView);
        Vibrator = (Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            VibrationEffect = android.os.VibrationEffect.createPredefined(android.os.VibrationEffect.EFFECT_TICK);
        }
        display.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()<16) {
                    display.setTextSize(36);
                }
                if (s.toString().length()>16 || s.toString().length()==21){
                    display.setTextSize(30);
                    display2.setTextSize(28);
                }
                if (s.toString().length()>21){
                    display.setTextSize(26);
                    display2.setTextSize(25);

                }
                uiBTN.animate().alpha(0.0f);
                uiBTN.setVisibility(View.GONE);

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (display.getText().toString().equals("")) {

                    uiBTN.setVisibility(View.VISIBLE);
                    uiBTN.animate().alpha(1.0f);

                }

            }
        });

    }

    private void updateText(String strToAdd)
    {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + 1);
    }

    public void sevenBTN(View view) {
        updateText("7");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }

    public void eightBTN(View view) {
        updateText("8");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }

    public void nineBTN(View view) {
        updateText("9");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }

    public void bckspcBTN(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
            display2.setText("");
        }


    }
    public void clrBTN(View view) {
        //display.setText("");
        //display2.setText("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
        Animation slideright = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        slideright.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                display2.setText("");
                display.setText("");
            }
            @Override
            public void onAnimationEnd(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        display2.startAnimation(slideright);
        display.startAnimation(slideright);
    }

    public void fourBTN(View view) {
        updateText("4");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void fiveBTN(View view) {
        updateText("5");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void sixBTN(View view) {
        updateText("6");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void divBTN(View view) {
        updateText("÷");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void oneBTN(View view) { updateText("1");
        Vibrator = (Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void twoBTN(View view) {
        updateText("2");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void threeBTN(View view) {
        updateText("3");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void mulBTN(View view) {
        updateText("×");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void zeroBTN(View view) {
        updateText("0");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void dotBTN(View view) {
        updateText(".");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void addBTN(View view) {
        updateText("+");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void subBTN(View view) {
        updateText("-");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }


    public void sinBTN(View view) { updateText("sin(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void cosBTN(View view) { updateText("cos(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void tanBTN(View view) { updateText("tan(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void logBTN(View view) { updateText("log10(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void factBTN(View view) { updateText("!");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void sqrootBTN(View view) { updateText("sqrt(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void leftbtBTN(View view) { updateText("(");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void rightbtBTN(View view) { updateText(")");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}

    public void cotBTN(View view) { updateText("cot(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void cosecBTN(View view) { updateText("cosec(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void secBTN(View view) { updateText("sec(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void comBTN(View view) {updateText(",");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void absBTN(View view) { updateText("abs(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void piBTN(View view) { updateText("pi");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void expBTN(View view) { updateText("e");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void xSqBTN(View view) { updateText("^(2)");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void xpyBTN(View view) { updateText("^(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void isprmBTN(View view) { updateText("ispr(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void gcdBTN(View view) { updateText("gcd(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}
    public void lcmBTN(View view) { updateText("lcm(");
        display.setSelection(display.length());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }}




    public void equalBTN(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }

        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");




        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());


        double res2 = Double.parseDouble(result);
        String fresult = String.valueOf(res2);






        //display.setText(result);
        //display.setSelection(result.length());
        //display2.setText(userExp);

        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);

        final String ue = display.getText().toString();

        slideUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                display2.setText(ue);

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                display.setText(fresult);
                display.setSelection(fresult.length());

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        display2.startAnimation(slideUp);
    }

    public void simBTN(View view) {
        finish();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }
    }
    public void popup(View view) {
        float deg = (uiBTN.getRotation() == 180F) ? 0F : 180F;
        uiBTN.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
        registerForContextMenu(view);
        openContextMenu(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Vibrator.vibrate(VibrationEffect);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        menu.setHeaderTitle("Select Gradients");

        MenuItem def= menu.findItem(R.id.Def);
        MenuItem king_yna= menu.findItem(R.id.King_Yna);
        MenuItem sky= menu.findItem(R.id.Sky);
        MenuItem gg= menu.findItem(R.id.GradeGrey);
        MenuItem megatrn= menu.findItem(R.id.MegaTron);
        MenuItem pl= menu.findItem(R.id.PureLust);
        MenuItem dc= menu.findItem(R.id.Delicate);
        MenuItem sel= menu.findItem(R.id.Sel);

        if (item_selection==1){
            def.setChecked(true);
        }
        if (item_selection==3){
            king_yna.setChecked(true);
        }
        if (item_selection==2){
            sky.setChecked(true);
        }
        if (item_selection==4){
            gg.setChecked(true);
        }
        if (item_selection==5){
            megatrn.setChecked(true);
        }
        if (item_selection==6){
            pl.setChecked(true);
        }
        if (item_selection==7){
            dc.setChecked(true);
        }
        if (item_selection==8){
            sel.setChecked(true);
        }



    }
    @SuppressLint("NonConstantResourceId")
    @Override

    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.Def:
                item.setChecked(true);
                layout.setBackgroundResource(R.drawable.gradient_bg);
                item_selection=1;
                display.setTextColor(Color.parseColor("#FFFFFF"));
                display2.setTextColor(Color.parseColor("#FFFFFF"));
                float deg1 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg1).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;

            case R.id.Sky:
                item.setChecked(true);
                item_selection=2;
                layout.setBackgroundResource(R.drawable.sky);
                display.setTextColor(Color.parseColor("#3e4444"));
                display2.setTextColor(Color.parseColor("#3e4444"));
                float deg2 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg2).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;

            case R.id.King_Yna:
                item.setChecked(true);
                item_selection=3;
                layout.setBackgroundResource(R.drawable.king_yna);
                display.setTextColor(Color.parseColor("#FFFFFF"));
                display2.setTextColor(Color.parseColor("#FFFFFF"));
                float deg3 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg3).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;

            case R.id.GradeGrey:
                item.setChecked(true);
                item_selection=4;
                layout.setBackgroundResource(R.drawable.gradegrey);
                display.setTextColor(Color.parseColor("#FFFFFF"));
                display2.setTextColor(Color.parseColor("#FFFFFF"));
                float deg4 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg4).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;

            case R.id.MegaTron:
                item.setChecked(true);
                item_selection=5;
                layout.setBackgroundResource(R.drawable.megatron);
                display.setTextColor(Color.parseColor("#3e4444"));
                display2.setTextColor(Color.parseColor("#3e4444"));
                float deg5 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg5).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;
            case R.id.PureLust:
                item.setChecked(true);
                item_selection=6;
                layout.setBackgroundResource(R.drawable.purelust);
                display.setTextColor(Color.parseColor("#FFFFFF"));
                display2.setTextColor(Color.parseColor("#FFFFFF"));
                float deg6 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg6).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;
            case R.id.Delicate:
                item.setChecked(true);
                item_selection=7;
                layout.setBackgroundResource(R.drawable.delicate);
                display.setTextColor(Color.parseColor("#3e4444"));
                display2.setTextColor(Color.parseColor("#3e4444"));
                float deg7 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg7).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;
            case R.id.Sel:
                item.setChecked(true);
                item_selection=8;
                layout.setBackgroundResource(R.drawable.sel);
                display.setTextColor(Color.parseColor("#3e4444"));
                display2.setTextColor(Color.parseColor("#3e4444"));
                float deg8 = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(deg8).setInterpolator(new AccelerateDecelerateInterpolator());
                return true;
            default:
                float degd = (uiBTN.getRotation() == 180F) ? 0F : 180F;
                uiBTN.animate().rotation(degd).setInterpolator(new AccelerateDecelerateInterpolator());
                return super.onContextItemSelected(item);
        }
    }


}
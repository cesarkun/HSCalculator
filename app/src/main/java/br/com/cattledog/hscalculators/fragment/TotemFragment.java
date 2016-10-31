package br.com.cattledog.hscalculators.fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import br.com.cattledog.hscalculators.R;

/**
 * Created by Cesar A. dos Santos on 19/10/2016.
 */
public class TotemFragment extends Fragment {
    private EditText et_totem_hp_value;
    private EditText et_totem_armor_value;
    private EditText et_totem_onboard_value;
    private EditText et_totem_monboard_value;
    private TextView tv_totem_valiant;
    private TextView tv_totem_hero;
    private TextView tv_totem_hpleft_value;

    private ImageView iv_totem_hp_plus;
    private ImageView iv_totem_hp_minus;
    private ImageView iv_totem_armor_plus;
    private ImageView iv_totem_armor_minus;
    private ImageView iv_totem_onboard_plus;
    private ImageView iv_totem_onboard_minus;
    private ImageView iv_totem_monboard_plus;
    private ImageView iv_totem_monboard_minus;
    
    private CheckBox cb_totem_bloodlust;

    private ImageView iv_totem_valiant;
    private ImageView iv_totem_hero;
    

    private int damage;
    private int hp;
    private int armor;
    private int onboard;
    private int monboard;
    private int valiant;
    private int hero;

    private AdView mAdView;


    public TotemFragment() {
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_totem, container, false);
        loadViews(rootview);
        initializeCounters();
        setOnClicks();

        updateValues(true);
        addAdStuff(rootview);
        return rootview;
    }

    private void addAdStuff(View rootview){
        mAdView = (AdView) rootview.findViewById(R.id.ad_banner);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void initializeCounters() {
        damage = 0;
        hp = 30;
        armor = 0;
        onboard = 0;
        monboard = 0;
        valiant = 0;
        hero = 0;

        iv_totem_valiant.setAlpha((float)0.5);
        tv_totem_valiant.setText("");
        iv_totem_hero.setAlpha((float)0.5);
        tv_totem_hero.setText("");
    }

    private void loadViews(View rootview) {
        et_totem_hp_value = (EditText) rootview.findViewById(R.id.et_totem_hp_value);
        et_totem_armor_value = (EditText) rootview.findViewById(R.id.et_totem_armor_value);
        et_totem_onboard_value = (EditText) rootview.findViewById(R.id.et_totem_onboard_value);
        et_totem_monboard_value = (EditText) rootview.findViewById(R.id.et_totem_monboard_value);
        tv_totem_valiant = (TextView) rootview.findViewById(R.id.tv_totem_valiant);
        tv_totem_hero = (TextView) rootview.findViewById(R.id.tv_totem_hero);
        tv_totem_hpleft_value = (TextView) rootview.findViewById(R.id.tv_totem_hpleft_value);

        iv_totem_hp_plus = (ImageView) rootview.findViewById(R.id.iv_totem_hp_plus);
        iv_totem_hp_minus = (ImageView) rootview.findViewById(R.id.iv_totem_hp_minus);
        iv_totem_armor_plus = (ImageView) rootview.findViewById(R.id.iv_totem_armor_plus);
        iv_totem_armor_minus = (ImageView) rootview.findViewById(R.id.iv_totem_armor_minus);
        iv_totem_onboard_plus = (ImageView) rootview.findViewById(R.id.iv_totem_onboard_plus);
        iv_totem_onboard_minus = (ImageView) rootview.findViewById(R.id.iv_totem_onboard_minus);
        iv_totem_monboard_plus = (ImageView) rootview.findViewById(R.id.iv_totem_monboard_plus);
        iv_totem_monboard_minus = (ImageView) rootview.findViewById(R.id.iv_totem_monboard_minus);

        cb_totem_bloodlust = (CheckBox) rootview.findViewById(R.id.cb_totem_bloodlust);
        iv_totem_valiant = (ImageView) rootview.findViewById(R.id.iv_totem_valiant);
        iv_totem_hero = (ImageView) rootview.findViewById(R.id.iv_totem_hero);
    }

    private void setOnClicks() {
        iv_totem_valiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(valiant){
                    case 0:
                        valiant++;
                        if(monboard<7)
                            monboard++;
                        iv_totem_valiant.setAlpha((float)1);
                        tv_totem_valiant.setText(String.format(getResources().getString(R.string.pattern_x_number), 1));
                        break;
                    case 1:
                        valiant++;
                        if(monboard<7)
                            monboard++;
                        iv_totem_valiant.setAlpha((float)1);
                        tv_totem_valiant.setText(String.format(getResources().getString(R.string.pattern_x_number), 2));
                        break;
                    default:
                        valiant = 0;
                        if(monboard>=2)
                            monboard-=2;
                        iv_totem_valiant.setAlpha((float)0.5);
                        tv_totem_valiant.setText("");
                        break;
                }
                updateValues(true);
            }
        });
        iv_totem_hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(hero){
                    case 0:
                        hero++;
                        if(monboard<7)
                            monboard++;
                        iv_totem_hero.setAlpha((float) 1);
                        tv_totem_hero.setText(String.format(getResources().getString(R.string.pattern_x_number), 1));
                        break;
                    case 1:
                        hero++;
                        if(monboard<7)
                            monboard++;
                        iv_totem_hero.setAlpha((float) 1);
                        tv_totem_hero.setText(String.format(getResources().getString(R.string.pattern_x_number), 2));
                        break;

                    case 2:
                        hero++;
                        if(monboard<7)
                            monboard++;
                        iv_totem_hero.setAlpha((float) 1);
                        tv_totem_hero.setText(String.format(getResources().getString(R.string.pattern_x_number), 3));
                        break;

                    default:
                        hero = 0;
                        if(monboard>=3)
                            monboard-=3;
                        iv_totem_hero.setAlpha((float)0.5);
                        tv_totem_hero.setText("");
                        break;
                }
                updateValues(true);
            }
        });

        iv_totem_hp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp++;
                updateValues(true);
            }
        });
        iv_totem_hp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hp>0)
                    hp--;
                updateValues(true);
            }
        });

        iv_totem_armor_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                armor++;
                updateValues(true);
            }
        });
        iv_totem_armor_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(armor>0)
                    armor--;
                updateValues(true);
            }
        });

        iv_totem_onboard_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onboard++;
                updateValues(true);
            }
        });
        iv_totem_onboard_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onboard>0)
                    onboard--;
                updateValues(true);
            }
        });

        iv_totem_monboard_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monboard < 7)
                    monboard++;
                updateValues(true);
            }
        });
        iv_totem_monboard_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monboard>valiant+hero)
                    monboard--;
                updateValues(true);
            }
        });
        et_totem_hp_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    hp = Integer.parseInt(s.toString());
                    if(hp > 30) {
                        s.replace(0, s.length(), "30");
                        hp = 30;
                    }
                    if(s.toString().startsWith("0") && s.length()!=1)
                        s.replace(0, s.length(), hp+"");
                }
                catch (Exception e){
                    s.append("0");
                    hp = 0;
                }
                updateValues(false);
            }
        });
        et_totem_armor_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    armor = (int)Long.parseLong(s.toString());
                    if(armor > 9999){
                        s.replace(0, s.length(), "9999");
                        armor = 9999;
                    }
                    if(s.toString().startsWith("0") && s.length()!=1)
                        s.replace(0, s.length(), armor+"");
                }
                catch (Exception e){
                    s.append("0");
                    armor = 0;
                }
                updateValues(false);
            }
        });
        et_totem_onboard_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    onboard = (int)Long.parseLong(s.toString());
                    if(onboard > 9999){
                        s.replace(0, s.length(), "9999");
                        onboard = 9999;
                    }
                    if(s.toString().startsWith("0") && s.length()!=1)
                        s.replace(0, s.length(), onboard+"");
                }
                catch (Exception e){
                    s.append("0");
                    onboard = 0;
                }
                updateValues(false);
            }
        });
        et_totem_monboard_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    monboard = (int)Long.parseLong(s.toString());
                    if(s.toString().startsWith("0") && s.length()!=1)
                        s.replace(0, s.length(), monboard+"");
                }
                catch (Exception e){
                    s.append("0");
                    monboard = 0;
                }
                updateValues(false);
            }
        });
        cb_totem_bloodlust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValues(false);
            }
        });
    }

    private void calculateDamage() {
        damage = onboard + (cb_totem_bloodlust.isChecked()?((monboard+hero)*3):0) + ((monboard<7)?(hero*valiant*2):0);
        tv_totem_hpleft_value.setText(String.format(getResources().getString(R.string.pattern_number), hp+armor-damage));
    }

    private void updateValues(boolean update){
        calculateDamage();
        if(update) {
            et_totem_hp_value.setText(String.format(getResources().getString(R.string.pattern_number), hp));
            et_totem_armor_value.setText(String.format(getResources().getString(R.string.pattern_number), armor));
            et_totem_onboard_value.setText(String.format(getResources().getString(R.string.pattern_number), onboard));
            et_totem_monboard_value.setText(String.format(getResources().getString(R.string.pattern_number), monboard));
        }
    }

}

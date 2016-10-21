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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.cattledog.hscalculators.R;

/**
 * Created by Cesar A. dos Santos on 19/10/2016.
 */
public class MillFragment extends Fragment {
    private TextView tv_mill_cards_value;
    private TextView tv_mill_manacost_value;
    private TextView tv_mill_draw_value;
    private EditText et_mill_hp_value;
    private EditText et_mill_armor_value;
    private TextView tv_mill_total_value;
    private ImageView iv_mill_coldlight;
    private ImageView iv_mill_brann;
    private ImageView iv_mill_shadowstep;

    private TextView tv_mill_coldlight;
    private TextView tv_mill_brann;
    private TextView tv_mill_shadowstep;

    private ImageView iv_mill_cards_plus;
    private ImageView iv_mill_cards_minus;

    private ImageView iv_mill_hp_plus;
    private ImageView iv_mill_hp_minus;

    private ImageView iv_mill_armor_plus;
    private ImageView iv_mill_armor_minus;

    private int cards;
    private int manaCost;
    private int cardDraw;
    private int damage;
    private int hp;
    private int armor;

    private int coldlight;
    private int brann;
    private int shadowstep;
    private AdView mAdView;


    public MillFragment() {
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_mill, container, false);
        loadViews(rootview);
        initializeCounters();
        setOnClicks();

        updateValues();
        addAdStuff(rootview);
        return rootview;
    }

    private void addAdStuff(View rootview){
        mAdView = (AdView) rootview.findViewById(R.id.ad_banner);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    private void initializeCounters() {
        manaCost = 0;
        cardDraw = 0;
        damage = 0;
        hp = 30;
        armor = 0;

        coldlight = 0;
        brann = 0;
        shadowstep = 0;

        iv_mill_coldlight.setAlpha((float)0.5);
        tv_mill_coldlight.setText("");
        iv_mill_brann.setAlpha((float)0.5);
        tv_mill_brann.setText("");
        iv_mill_shadowstep.setAlpha((float)0.5);
        tv_mill_shadowstep.setText("");
    }

    private void loadViews(View rootview) {
        tv_mill_cards_value = (TextView) rootview.findViewById(R.id.tv_mill_cards_value);
        tv_mill_manacost_value = (TextView) rootview.findViewById(R.id.tv_mill_manacost_value);
        tv_mill_draw_value = (TextView) rootview.findViewById(R.id.tv_mill_draw_value);
        et_mill_hp_value = (EditText) rootview.findViewById(R.id.et_mill_hp_value);
        et_mill_armor_value = (EditText) rootview.findViewById(R.id.et_mill_armor_value);
        tv_mill_total_value = (TextView) rootview.findViewById(R.id.tv_mill_total_value);


        iv_mill_coldlight = (ImageView) rootview.findViewById(R.id.iv_mill_coldlight);
        iv_mill_brann = (ImageView) rootview.findViewById(R.id.iv_mill_brann);
        iv_mill_shadowstep = (ImageView) rootview.findViewById(R.id.iv_mill_shadowstep);

        tv_mill_coldlight = (TextView) rootview.findViewById(R.id.tv_mill_coldlight);
        tv_mill_brann = (TextView) rootview.findViewById(R.id.tv_mill_brann);
        tv_mill_shadowstep = (TextView) rootview.findViewById(R.id.tv_mill_shadowstep);

        iv_mill_cards_plus = (ImageView) rootview.findViewById(R.id.iv_mill_cards_plus);
        iv_mill_cards_minus = (ImageView) rootview.findViewById(R.id.iv_mill_cards_minus);

        iv_mill_hp_plus = (ImageView) rootview.findViewById(R.id.iv_mill_hp_plus);
        iv_mill_hp_minus = (ImageView) rootview.findViewById(R.id.iv_mill_hp_minus);

        iv_mill_armor_plus = (ImageView) rootview.findViewById(R.id.iv_mill_armor_plus);
        iv_mill_armor_minus = (ImageView) rootview.findViewById(R.id.iv_mill_armor_minus);
    }

    private void setOnClicks() {
        iv_mill_coldlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(coldlight){
                    case 0:
                        coldlight++;
                        iv_mill_coldlight.setAlpha((float)1);
                        tv_mill_coldlight.setText("x1");
                        break;
                    case 1:
                        coldlight++;
                        iv_mill_coldlight.setAlpha((float)1);
                        tv_mill_coldlight.setText("x2");
                        break;
                    case 2:
                        coldlight++;
                        iv_mill_coldlight.setAlpha((float)1);
                        tv_mill_coldlight.setText("x3");
                        break;
                    default:
                        coldlight = 0;
                        iv_mill_coldlight.setAlpha((float)0.5);
                        tv_mill_coldlight.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_mill_brann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(brann){
                    case 0:
                        brann++;
                        iv_mill_brann.setAlpha((float)1);
                        tv_mill_brann.setText("x1");
                        break;
                    default:
                        brann = 0;
                        iv_mill_brann.setAlpha((float)0.5);
                        tv_mill_brann.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_mill_shadowstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(shadowstep){
                    case 0:
                        shadowstep++;
                        iv_mill_shadowstep.setAlpha((float)1);
                        tv_mill_shadowstep.setText("x1");
                        break;
                    case 1:
                        shadowstep++;
                        iv_mill_shadowstep.setAlpha((float)1);
                        tv_mill_shadowstep.setText("x2");
                        break;
                    default:
                        shadowstep = 0;
                        iv_mill_shadowstep.setAlpha((float)0.5);
                        tv_mill_shadowstep.setText("");
                        break;
                }
                updateValues();
            }
        });


        iv_mill_cards_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cards++;
                updateValues();
            }
        });
        iv_mill_cards_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cards--;
                updateValues();
            }
        });

        iv_mill_hp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp++;
                updateValues();
            }
        });
        iv_mill_hp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hp>0)
                    hp--;
                updateValues();
            }
        });

        iv_mill_armor_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                armor++;
                updateValues();
            }
        });
        iv_mill_armor_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(armor>0)
                    armor--;
                updateValues();
            }
        });
        et_mill_hp_value.addTextChangedListener(new TextWatcher() {
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
            }
        });
        et_mill_armor_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    armor = Integer.parseInt(s.toString());
                    if(s.toString().startsWith("0") && s.length()!=1)
                        s.replace(0, s.length(), armor+"");
                }
                catch (Exception e){
                    s.append("0");
                    armor = 0;
                }
            }
        });
    }

    private void addCardDraw(int spell, int draw){
        for (int i = 0; i < spell; i++) {
            cardDraw+=draw+draw*brann;
        }
    }

    private int calculateDamage() {
        int acumulatedDamage = cards -1;
        int r = hp+armor;
        for (int i = 0; i < cardDraw+1; i++) {
            if(acumulatedDamage<0)
                r+=acumulatedDamage;
            acumulatedDamage--;
        }
        return r;
    }

    private void updateValues(){
        cardDraw = 0;
        damage = 0;
        addCardDraw(coldlight+shadowstep, 2);
        calculateDamage();
        manaCost = coldlight*3+brann*3+shadowstep;
        tv_mill_draw_value.setText((cardDraw+1)+"");
        tv_mill_cards_value.setText(cards+"");
        tv_mill_manacost_value.setText(manaCost+"");
        tv_mill_total_value.setText(calculateDamage()+"");
        et_mill_hp_value.setText(hp+"");
        et_mill_armor_value.setText(armor+"");
    }

}

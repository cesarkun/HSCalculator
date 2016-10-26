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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import br.com.cattledog.hscalculators.R;

/**
 * Created by Cesar A. dos Santos on 19/10/2016.
 */
public class AnyfinFragment extends Fragment {
    private TextView tv_anyfin_result_value;
    private EditText et_anyfin_hp_value;
    private EditText et_anyfin_armor_value;
    private TextView tv_anyfin_total_name;
    private TextView tv_anyfin_total_value;
    private TextView tv_anyfin_total_values;
    private TextView tv_anyfin_total_percentages;
    private ImageView iv_anyfin_bluegill;
    private ImageView iv_anyfin_warleader;


    private TextView tv_anyfin_bluegill;
    private TextView tv_anyfin_warleader;

    private ImageView iv_anyfin_hp_plus;
    private ImageView iv_anyfin_hp_minus;

    private ImageView iv_anyfin_armor_plus;
    private ImageView iv_anyfin_armor_minus;

    private int hp;
    private int armor;

    private int bluegill;
    private int warleader;


    public AnyfinFragment() {
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_anyfin, container, false);
        loadViews(rootview);
        initializeCounters();
        setOnClicks();

        updateValues(true);
        addAdStuff(rootview);
        return rootview;
    }

    private void addAdStuff(View rootview){
        AdView mAdView = (AdView) rootview.findViewById(R.id.ad_banner);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void initializeCounters() {
        hp = 30;
        armor = 0;

        bluegill = 0;
        warleader = 0;

        iv_anyfin_bluegill.setAlpha((float)0.5);
        tv_anyfin_bluegill.setText("");
        iv_anyfin_warleader.setAlpha((float)0.5);
        tv_anyfin_warleader.setText("");
    }

    private void loadViews(View rootview) {
        tv_anyfin_result_value = (TextView) rootview.findViewById(R.id.tv_anyfin_result_value);
        et_anyfin_hp_value = (EditText) rootview.findViewById(R.id.et_anyfin_hp_value);
        et_anyfin_armor_value = (EditText) rootview.findViewById(R.id.et_anyfin_armor_value);
        tv_anyfin_total_value = (TextView) rootview.findViewById(R.id.tv_anyfin_total_value);
        tv_anyfin_total_name = (TextView) rootview.findViewById(R.id.tv_anyfin_total_name);
        tv_anyfin_total_values = (TextView) rootview.findViewById(R.id.tv_anyfin_total_values);
        tv_anyfin_total_percentages = (TextView) rootview.findViewById(R.id.tv_anyfin_total_percentages);


        iv_anyfin_bluegill = (ImageView) rootview.findViewById(R.id.iv_anyfin_bluegill);
        iv_anyfin_warleader = (ImageView) rootview.findViewById(R.id.iv_anyfin_warleader);

        tv_anyfin_bluegill = (TextView) rootview.findViewById(R.id.tv_anyfin_bluegill);
        tv_anyfin_warleader = (TextView) rootview.findViewById(R.id.tv_anyfin_warleader);

        iv_anyfin_hp_plus = (ImageView) rootview.findViewById(R.id.iv_anyfin_hp_plus);
        iv_anyfin_hp_minus = (ImageView) rootview.findViewById(R.id.iv_anyfin_hp_minus);

        iv_anyfin_armor_plus = (ImageView) rootview.findViewById(R.id.iv_anyfin_armor_plus);
        iv_anyfin_armor_minus = (ImageView) rootview.findViewById(R.id.iv_anyfin_armor_minus);
    }

    private void setOnClicks() {
        iv_anyfin_bluegill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(bluegill){
                    case 0:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 1));
                        break;
                    case 1:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 2));
                        break;
                    case 2:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 3));
                        break;
                    case 3:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 4));
                        break;
                    case 4:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 5));
                        break;
                    case 5:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 6));
                        break;
                    case 6:
                        bluegill++;
                        iv_anyfin_bluegill.setAlpha((float)1);
                        tv_anyfin_bluegill.setText(String.format(getResources().getString(R.string.pattern_x_number), 7));
                        break;
                    default:
                        bluegill = 0;
                        iv_anyfin_bluegill.setAlpha((float)0.5);
                        tv_anyfin_bluegill.setText("");
                        break;
                }
                updateValues(true);
            }
        });
        iv_anyfin_warleader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(warleader){
                    case 0:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 1));
                        break;
                    case 1:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 2));
                        break;
                    case 2:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 3));
                        break;
                    case 3:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 4));
                        break;
                    case 4:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 5));
                        break;
                    case 5:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 6));
                        break;
                    case 6:
                        warleader++;
                        iv_anyfin_warleader.setAlpha((float)1);
                        tv_anyfin_warleader.setText(String.format(getResources().getString(R.string.pattern_x_number), 7));
                        break;
                    default:
                        warleader = 0;
                        iv_anyfin_warleader.setAlpha((float)0.5);
                        tv_anyfin_warleader.setText("");
                        break;
                }
                updateValues(true);
            }
        });

        iv_anyfin_hp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp++;
                updateValues(true);
            }
        });
        iv_anyfin_hp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hp>0)
                    hp--;
                updateValues(true);
            }
        });

        iv_anyfin_armor_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                armor++;
                updateValues(true);
            }
        });
        iv_anyfin_armor_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(armor>0)
                    armor--;
                updateValues(true);
            }
        });
        et_anyfin_hp_value.addTextChangedListener(new TextWatcher() {
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
        et_anyfin_armor_value.addTextChangedListener(new TextWatcher() {
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
    }

    private void calculateDamage() {
        HashMap<Integer, Integer> results = new HashMap<>();
        if(warleader+bluegill<=7){
            tv_anyfin_total_name.setText(getString(R.string.tv_hp_left));
            tv_anyfin_total_value.setVisibility(View.VISIBLE);
            tv_anyfin_total_values.setVisibility(View.GONE);
            tv_anyfin_total_percentages.setVisibility(View.GONE);

            tv_anyfin_total_value.setText(String.format(getResources().getString(R.string.pattern_number), (hp+armor-(2+2*warleader)*bluegill)));
            if((hp+armor-(2+2*warleader)*bluegill)<=0)
                tv_anyfin_result_value.setText(String.format(getResources().getString(R.string.pattern_number_percent), 100));
            else
                tv_anyfin_result_value.setText(String.format(getResources().getString(R.string.pattern_number_percent), 0));
            return;
        }
        int count = 0;
        int negative = 0;
        for (int i = 0; i <= warleader; i++) {
            for (int j = 0; j <= bluegill; j++) {
                if(i+j !=7 )
                    continue;
                count++;
                int result = (hp+armor-(2+2*i)*j);
                if(results.containsKey(result)){
                    results.put(result, results.get(result)+1);
                }
                else {
                    results.put(result, 1);
                }
                if(result<=0)
                    negative++;
            }
        }
        tv_anyfin_total_name.setText(getString(R.string.tv_anyfin_hp_left_name));
        tv_anyfin_total_value.setVisibility(View.GONE);
        tv_anyfin_total_values.setVisibility(View.VISIBLE);
        tv_anyfin_total_percentages.setVisibility(View.VISIBLE);
        String rValues = "";
        String rPercent = "";
        List<Integer> list = new ArrayList<>(results.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer integer : list) {
            rValues += integer+"\n";
            rPercent += results.get(integer)*100/count+"%\n";
        }
        tv_anyfin_total_values.setText(rValues);
        tv_anyfin_total_percentages.setText(rPercent);

        tv_anyfin_result_value.setText(String.format(getResources().getString(R.string.pattern_number_percent), (negative*100/count)));

    }

    private void updateValues(boolean update){
        calculateDamage();
        if(update) {
            et_anyfin_hp_value.setText(String.format(getResources().getString(R.string.pattern_number_percent), hp));
            et_anyfin_armor_value.setText(String.format(getResources().getString(R.string.pattern_number_percent), armor));
        }
    }

}

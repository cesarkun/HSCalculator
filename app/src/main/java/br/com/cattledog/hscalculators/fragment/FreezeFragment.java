package br.com.cattledog.hscalculators.fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import br.com.cattledog.hscalculators.R;

/**
 * Created by Cesar A. dos Santos on 19/10/2016.
 */
public class FreezeFragment extends Fragment {
    private TextView tv_freeze_emperor_value;
    private TextView tv_freeze_manacost_value;
    private TextView tv_freeze_total_value;
    private ImageView iv_freeze_frostbolt;
    private ImageView iv_freeze_icelance;
    private ImageView iv_freeze_forgottentorch;
    private ImageView iv_freeze_roaringtorch;
    private ImageView iv_freeze_fireball;
    private ImageView iv_freeze_thalnos;
    private ImageView iv_freeze_kobold;

    private TextView tv_freeze_frostbolt;
    private TextView tv_freeze_icelance;
    private TextView tv_freeze_forgottentorch;
    private TextView tv_freeze_roaringtorch;
    private TextView tv_freeze_fireball;
    private TextView tv_freeze_thalnos;
    private TextView tv_freeze_kobold;

    private ImageView iv_freeze_emperor_plus;
    private ImageView iv_freeze_emperor_minus;

    private int emperorTicks;
    private int manaCost;
    private int total;

    private int frostbolt;
    private int icelance;
    private int ftorch;
    private int rtorch;
    private int fireball;
    private int thalnos;
    private int kobold;
    private AdView mAdView;


    public FreezeFragment() {
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_freeze, container, false);
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
                .build();
        mAdView.loadAd(adRequest);
    }

    private void initializeCounters() {
        emperorTicks = 0;
        manaCost = 0;
        total = 0;

        frostbolt = 0;
        icelance = 0;
        ftorch = 0;
        rtorch = 0;
        fireball = 0;
        thalnos = 0;
        kobold = 0;

        iv_freeze_frostbolt.setAlpha((float)0.5);
        tv_freeze_frostbolt.setText("");
        iv_freeze_icelance.setAlpha((float)0.5);
        tv_freeze_icelance.setText("");
        iv_freeze_forgottentorch.setAlpha((float)0.5);
        tv_freeze_forgottentorch.setText("");
        iv_freeze_roaringtorch.setAlpha((float)0.5);
        tv_freeze_roaringtorch.setText("");
        iv_freeze_fireball.setAlpha((float)0.5);
        tv_freeze_fireball.setText("");
        iv_freeze_thalnos.setAlpha((float)0.5);
        tv_freeze_thalnos.setText("");
        iv_freeze_kobold.setAlpha((float)0.5);
        tv_freeze_kobold.setText("");
    }

    private void loadViews(View rootview) {
        tv_freeze_emperor_value = (TextView) rootview.findViewById(R.id.tv_freeze_emperor_value);
        tv_freeze_manacost_value = (TextView) rootview.findViewById(R.id.tv_freeze_manacost_value);
        tv_freeze_total_value = (TextView) rootview.findViewById(R.id.tv_freeze_total_value);

        iv_freeze_frostbolt = (ImageView) rootview.findViewById(R.id.iv_freeze_frostbolt);
        iv_freeze_icelance = (ImageView) rootview.findViewById(R.id.iv_freeze_icelance);
        iv_freeze_forgottentorch = (ImageView) rootview.findViewById(R.id.iv_freeze_forgottentorch);
        iv_freeze_roaringtorch = (ImageView) rootview.findViewById(R.id.iv_freeze_roaringtorch);
        iv_freeze_fireball = (ImageView) rootview.findViewById(R.id.iv_freeze_fireball);
        iv_freeze_thalnos = (ImageView) rootview.findViewById(R.id.iv_freeze_thalnos);
        iv_freeze_kobold = (ImageView) rootview.findViewById(R.id.iv_freeze_kobold);

        tv_freeze_frostbolt = (TextView) rootview.findViewById(R.id.tv_freeze_frostbolt);
        tv_freeze_icelance = (TextView) rootview.findViewById(R.id.tv_freeze_icelance);
        tv_freeze_forgottentorch = (TextView) rootview.findViewById(R.id.tv_freeze_forgottentorch);
        tv_freeze_roaringtorch = (TextView) rootview.findViewById(R.id.tv_freeze_roaringtorch);
        tv_freeze_fireball = (TextView) rootview.findViewById(R.id.tv_freeze_fireball);
        tv_freeze_thalnos = (TextView) rootview.findViewById(R.id.tv_freeze_thalnos);
        tv_freeze_kobold = (TextView) rootview.findViewById(R.id.tv_freeze_kobold);

        iv_freeze_emperor_plus = (ImageView) rootview.findViewById(R.id.iv_freeze_emperor_plus);
        iv_freeze_emperor_minus = (ImageView) rootview.findViewById(R.id.iv_freeze_emperor_minus);
    }

    private void setOnClicks() {
        iv_freeze_frostbolt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(frostbolt){
                    case 0:
                        frostbolt++;
                        iv_freeze_frostbolt.setAlpha((float)1);
                        tv_freeze_frostbolt.setText("x1");
                        break;
                    case 1:
                        frostbolt++;
                        iv_freeze_frostbolt.setAlpha((float)1);
                        tv_freeze_frostbolt.setText("x2");
                        break;
                    default:
                        frostbolt = 0;
                        iv_freeze_frostbolt.setAlpha((float)0.5);
                        tv_freeze_frostbolt.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_icelance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(icelance){
                    case 0:
                        icelance++;
                        iv_freeze_icelance.setAlpha((float)1);
                        tv_freeze_icelance.setText("x1");
                        break;
                    case 1:
                        icelance++;
                        iv_freeze_icelance.setAlpha((float)1);
                        tv_freeze_icelance.setText("x2");
                        break;
                    default:
                        icelance = 0;
                        iv_freeze_icelance.setAlpha((float)0.5);
                        tv_freeze_icelance.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_forgottentorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(ftorch){
                    case 0:
                        ftorch++;
                        iv_freeze_forgottentorch.setAlpha((float)1);
                        tv_freeze_forgottentorch.setText("x1");
                        break;
                    case 1:
                        ftorch++;
                        iv_freeze_forgottentorch.setAlpha((float)1);
                        tv_freeze_forgottentorch.setText("x2");
                        break;
                    default:
                        ftorch = 0;
                        iv_freeze_forgottentorch.setAlpha((float)0.5);
                        tv_freeze_forgottentorch.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_roaringtorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rtorch){
                    case 0:
                        rtorch++;
                        iv_freeze_roaringtorch.setAlpha((float)1);
                        tv_freeze_roaringtorch.setText("x1");
                        break;
                    case 1:
                        rtorch++;
                        iv_freeze_roaringtorch.setAlpha((float)1);
                        tv_freeze_roaringtorch.setText("x2");
                        break;
                    default:
                        rtorch = 0;
                        iv_freeze_roaringtorch.setAlpha((float)0.5);
                        tv_freeze_roaringtorch.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_fireball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(fireball){
                    case 0:
                        fireball++;
                        iv_freeze_fireball.setAlpha((float)1);
                        tv_freeze_fireball.setText("x1");
                        break;
                    case 1:
                        fireball++;
                        iv_freeze_fireball.setAlpha((float)1);
                        tv_freeze_fireball.setText("x2");
                        break;
                    default:
                        fireball = 0;
                        iv_freeze_fireball.setAlpha((float)0.5);
                        tv_freeze_fireball.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_thalnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(thalnos){
                    case 0:
                        thalnos++;
                        iv_freeze_thalnos.setAlpha((float)1);
                        tv_freeze_thalnos.setText("x1");
                        break;
                    default:
                        thalnos = 0;
                        iv_freeze_thalnos.setAlpha((float)0.5);
                        tv_freeze_thalnos.setText("");
                        break;
                }
                updateValues();
            }
        });
        iv_freeze_kobold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(kobold){
                    case 0:
                        kobold++;
                        iv_freeze_kobold.setAlpha((float)1);
                        tv_freeze_kobold.setText("x1");
                        break;
                    case 1:
                        kobold++;
                        iv_freeze_kobold.setAlpha((float)1);
                        tv_freeze_kobold.setText("x2");
                        break;
                    default:
                        kobold = 0;
                        iv_freeze_kobold.setAlpha((float)0.5);
                        tv_freeze_kobold.setText("");
                        break;
                }
                updateValues();
            }
        });

        iv_freeze_emperor_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emperorTicks < 9999)
                    emperorTicks++;
                updateValues();
            }
        });
        iv_freeze_emperor_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emperorTicks>0)
                    emperorTicks--;
                updateValues();
            }
        });
    }

    private void addDamage(int spell, int damage){
        for (int i = 0; i < spell; i++) {
            total+=damage+(kobold*2)+thalnos;
        }
    }

    private void updateValues(){
        total = 0;
        addDamage(frostbolt, 3);
        addDamage(icelance, 4);
        if(frostbolt==0 && icelance != 0)
            total-=(4+(kobold*2)+thalnos);
        addDamage(ftorch, 3);
        addDamage(rtorch, 6);
        addDamage(fireball, 6);
        manaCost = frostbolt*2+icelance+ftorch*3+rtorch*3+fireball*4+thalnos*2+kobold*4-emperorTicks;
        if(manaCost < 0)
            manaCost = 0;
        tv_freeze_emperor_value.setText(emperorTicks+"");
        tv_freeze_manacost_value.setText(manaCost+"");
        tv_freeze_total_value.setText(total+"");
    }

}

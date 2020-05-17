package com.example.buttomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintTableLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheetView;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetModal();
            }
        });
    }

    private void showBottomSheetModal() {
        initializeBottomSheetModal();
        loadBottomSheetRecyclerView();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetDialog.show();
    }

    private void initializeBottomSheetModal() {
        bottomSheetView = getLayoutInflater().inflate(R.layout.bottomsheet_factor, null);
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        int maxPeekHeight = (int) (getResources().getDisplayMetrics().heightPixels * 0.8);
        bottomSheetBehavior.setPeekHeight(maxPeekHeight);
    }

    private void loadBottomSheetRecyclerView() {
        List<String> sampleList = new ArrayList();
        sampleList.add("1");
        sampleList.add("2");
        sampleList.add("3");
        sampleList.add("4");

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        RecyclerView bottomSheetRecyclerView =
                bottomSheetView.findViewById(R.id.shop_bottomsheet_factor_recycler);

        ViewGroup.LayoutParams params = bottomSheetRecyclerView.getLayoutParams();
        params.height = dpToPx(sampleList.size() *72);
        bottomSheetRecyclerView.setLayoutParams(params);

        bottomSheetRecyclerView.setLayoutManager(layoutManager);
        bottomSheetRecyclerView.setNestedScrollingEnabled(false);
        AdapterList adapterList = new AdapterList(sampleList);
        bottomSheetRecyclerView.setLayoutManager(new GridLayoutManager(this , 3));
        bottomSheetRecyclerView.setNestedScrollingEnabled(true);
        bottomSheetRecyclerView.setAdapter(adapterList);
        bottomSheetRecyclerView.setVisibility(View.VISIBLE);
    }

    public static int dpToPx(int dp) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}

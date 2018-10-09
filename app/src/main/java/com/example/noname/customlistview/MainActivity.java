package com.example.noname.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.noname.customlistview.adapter.SinhVienAdapter;
import com.example.noname.customlistview.interfaces.OnItemDeleteListenner;
import com.example.noname.customlistview.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSinhVien;
    private List<SinhVien> sinhViens;
    private SinhVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = findViewById(R.id.lvSinhvien);
        sinhViens = new ArrayList<>();

        sinhViens.add(new SinhVien("quan","ninh binh",""));
        sinhViens.add(new SinhVien("dung","hanoi",""));
        sinhViens.add(new SinhVien("trung","hanoi",""));
        sinhViens.add(new SinhVien("ha","hanoi",""));
        sinhViens.add(new SinhVien("quan","hanoi",""));

        adapter =new SinhVienAdapter(this, R.layout.item_sinh_vien, sinhViens, new OnItemDeleteListenner() {
            @Override
            public void OnItemDeleted(int position) {
                sinhViens.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        lvSinhVien.setAdapter(adapter);
    }
}

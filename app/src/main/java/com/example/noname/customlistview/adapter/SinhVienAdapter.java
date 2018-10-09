package com.example.noname.customlistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noname.customlistview.MainActivity;
import com.example.noname.customlistview.R;
import com.example.noname.customlistview.interfaces.OnItemDeleteListenner;
import com.example.noname.customlistview.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    private List<SinhVien> sinhViens;
    private LayoutInflater inflater;
    private OnItemDeleteListenner deleteListenner;

    public SinhVienAdapter( Context context, int resource, List<SinhVien> objects,
                            OnItemDeleteListenner listenner) {
        super(context, resource,objects);
        sinhViens = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        deleteListenner = listenner;

    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {//chua duoc tao bao gio
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_sinh_vien, parent, false);

            holder.imgAnh = convertView.findViewById(R.id.imgAnh);
            holder.imgXoa = convertView.findViewById(R.id.imgXoa);
            holder.tvTen = convertView.findViewById(R.id.tvTen);
            holder.tvDiachi = convertView.findViewById(R.id.tvDiachi);

            convertView.setTag(holder);
        } else {//da duoc tao
            holder = (ViewHolder) convertView.getTag();
        }
        //thiet lap gia tri
        SinhVien sv = sinhViens.get(position);
        holder.tvTen.setText(sv.getTen());
        holder.tvDiachi.setText(sv.getDiachi());
        //su li khi click vao se xoa
        holder.imgXoa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteListenner.OnItemDeleted(position);
            }
        });

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imgAnh, imgXoa;
        public TextView tvTen, tvDiachi;
    }
}

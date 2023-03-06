package com.incava.notyourfault;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShelterAdapter extends RecyclerView.Adapter<ShelterAdapter.VH> {


    public ShelterAdapter(Context context, ArrayList<ShelterItem> list) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<ShelterItem> list) {
        this.list.clear();
        this.list = list;
    }

    ArrayList<ShelterItem> list;
    Context context;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.shelter_main_item, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        TextView tv_fcltNm, etrPrdCn, cpctCnt, rprsTelno, fxno, lotnoAddr, etrTrgtCn;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv_fcltNm = itemView.findViewById(R.id.tv_fcltNm);
            etrPrdCn = itemView.findViewById(R.id.etrPrdCn);
            cpctCnt = itemView.findViewById(R.id.cpctCnt);
            rprsTelno = itemView.findViewById(R.id.rprsTelno);
            fxno = itemView.findViewById(R.id.fxno);
            lotnoAddr = itemView.findViewById(R.id.tv_lotnoAddr);
            etrTrgtCn = itemView.findViewById(R.id.etrTrgtCn);
        }
        @SuppressLint("SetTextI18n")
        void onBind(ShelterItem shelterItem) {
            tv_fcltNm.setText(shelterItem.getFcltNm());
            etrPrdCn.setText(shelterItem.getEtrPrdCn());
            cpctCnt.setText(shelterItem.getCpctCnt());
            rprsTelno.setText(shelterItem.getRprsTelno());
            fxno.setText(shelterItem.getFxno());
            lotnoAddr.setText(shelterItem.getLotnoAddr());
            etrTrgtCn.setText(shelterItem.getEtrTrgtCn());
        }
    }

}

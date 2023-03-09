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


/**
 * MainActivity에서 리사이클뷰를 보여주기 위한 어댑터.
 */

public class ShelterAdapter extends RecyclerView.Adapter<ShelterAdapter.VH> {

    public interface OnItemClickListener{ //인터페이스 정의
        void onItemClick(View v, ShelterItem shelterItem);
    }

    private OnItemClickListener mListener = null; //객체 참조 변수.

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public ShelterAdapter(Context context, ArrayList<ShelterItem> list) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<ShelterItem> list) {//조회하려면 다시 해야하므로 아예지우고 다시 넣기.
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
        TextView fcltNm, etrPrdCn, cpctCnt, rprsTelno, fxno, lotnoAddr, etrTrgtCn;

        public VH(@NonNull View itemView) {
            super(itemView);
            fcltNm = itemView.findViewById(R.id.tv_fcltNm);
            etrPrdCn = itemView.findViewById(R.id.etrPrdCn);
            cpctCnt = itemView.findViewById(R.id.cpctCnt);
            rprsTelno = itemView.findViewById(R.id.rprsTelno);
            fxno = itemView.findViewById(R.id.fxno);
            lotnoAddr = itemView.findViewById(R.id.tv_lotnoAddr);
            etrTrgtCn = itemView.findViewById(R.id.etrTrgtCn);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if(pos != RecyclerView.NO_POSITION){//포지션이 있는 경우에만 -> 에러 제외코드
                    if (mListener != null){
                        mListener.onItemClick(v, list.get(pos));// 누를경우 그 아이템들이 나오도록.
                    }
                }
            });

        }
        @SuppressLint("SetTextI18n")
        void onBind(ShelterItem shelterItem) {
            fcltNm.setText(shelterItem.getFcltNm());
            etrPrdCn.setText(shelterItem.getEtrPrdCn());
            cpctCnt.setText(shelterItem.getCpctCnt());
            rprsTelno.setText(shelterItem.getRprsTelno());
            fxno.setText(shelterItem.getFxno());
            lotnoAddr.setText(shelterItem.getLotnoAddr());
            etrTrgtCn.setText(shelterItem.getEtrTrgtCn());
        }

    }

}

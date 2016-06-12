package com.example.vm10.dominandoandroid.model.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.vm10.dominandoandroid.R;
import com.example.vm10.dominandoandroid.model.Person;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(Context context, List<Person> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person p = getItem(position);
        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_person, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.load(p);
        return convertView;
    }

    static class ViewHolder {

        @BindView(R.id.txtPersonId)
        AppCompatTextView txtPersonId;

        @BindView(R.id.txtPersonName)
        AppCompatTextView txtPersonName;

        @BindView(R.id.txtPersonDate)
        AppCompatTextView txtPersonDate;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void load(Person p) {
            txtPersonId.setText(String.valueOf(p.getId()));
            txtPersonName.setText(p.getName());
            txtPersonDate.setText(p.getDateOfBirth().toString("dd/MM/yyyy"));
        }
    }
}

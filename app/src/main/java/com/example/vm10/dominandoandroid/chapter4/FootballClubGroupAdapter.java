package com.example.vm10.dominandoandroid.chapter4;

import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.example.vm10.dominandoandroid.R;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FootballClubGroupAdapter extends BaseExpandableListAdapter {

    private LinkedHashMap<String, List<String>> linkedMap;

    public FootballClubGroupAdapter(@NotNull LinkedHashMap<String, List<String>> linkedMap) {
        this.linkedMap = linkedMap;
    }

    @Override
    public int getGroupCount() {
        return linkedMap.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Object group = getGroup(groupPosition);
        return linkedMap.get(group).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return linkedMap.keySet().toArray()[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Object group = getGroup(groupPosition);
        return linkedMap.get(group).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        Object group = getGroup(groupPosition);

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_expandable_list_view, parent, false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.txtGroup.setText(group.toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        Object child = getChild(groupPosition, childPosition);

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_expandable_list_view, parent, false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        holder.txtChild.setText(child.toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    static class GroupViewHolder {

        @BindView(R.id.txtGroup)
        AppCompatTextView txtGroup;

        public GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {

        @BindView(R.id.txtChild)
        AppCompatTextView txtChild;

        public ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

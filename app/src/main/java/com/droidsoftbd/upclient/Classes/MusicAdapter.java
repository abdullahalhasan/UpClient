package com.droidsoftbd.upclient.Classes;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.droidsoftbd.upclient.R;

import java.util.ArrayList;

/**
 * Created by BDDL-102 on 8/1/2018.
 */

public class MusicAdapter extends ArrayAdapter {

    Context context;
    ArrayList resIds;
    MediaPlayer mediaPlayer;
    public MusicAdapter(@NonNull Context context, ArrayList resIds) {
        super(context,R.layout.music_list_view, resIds);

        this.context = context;
        this.resIds = new ArrayList();
        this.resIds = resIds;
    }

    static class ViewHolder {
        TextView nameTV;
        Button playButton;
        Button stopButton;
        Button starredButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.music_list_view,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTV = convertView.findViewById(R.id.musicNameTextView);
            viewHolder.playButton = convertView.findViewById(R.id.musicPlayButtonIcon);
            viewHolder.stopButton = convertView.findViewById(R.id.musicStopButtonIcon);
            viewHolder.starredButton = convertView.findViewById(R.id.musicStarButtonIcon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        for (int i = 0; i < resIds.size(); i++) {
            viewHolder.nameTV.setText(String.valueOf(resIds.indexOf(i)));
        }

        return convertView;
    }
}

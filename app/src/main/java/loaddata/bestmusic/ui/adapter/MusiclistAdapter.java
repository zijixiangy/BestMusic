package loaddata.bestmusic.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import loaddata.bestmusic.R;

/**
 * Created by svmsung on 2017-07-25.
 */

public class MusiclistAdapter extends RecyclerView.Adapter<MusiclistAdapter.MyViewHolder> {

    private Context context;
    private List<Map<String, Object>> list;

    public MusiclistAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView songname;
        TextView songartist;
        TextView songalbum;

        public MyViewHolder(View itemView) {
            super(itemView);
            songname= (TextView) itemView.findViewById(R.id.item_musiclist_songname);
            songartist= (TextView) itemView.findViewById(R.id.item_musiclist_songartist);
            songalbum= (TextView) itemView.findViewById(R.id.item_musiclist_songalbum);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_musiclist, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.songname.setText(list.get(position).get("SongName").toString());
        holder.songartist.setText(list.get(position).get("SongArtist").toString());
        holder.songalbum.setText(list.get(position).get("SongAlbum").toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

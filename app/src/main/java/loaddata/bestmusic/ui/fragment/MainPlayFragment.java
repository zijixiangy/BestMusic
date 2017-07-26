package loaddata.bestmusic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import loaddata.bestmusic.R;

/**
 * Created by svmsung on 2017-07-24.
 */

public class MainPlayFragment extends Fragment {


    @BindView(R.id.fragment_music_play_headimage)
    ImageView fragmentMusicPlayHeadimage;
    @BindView(R.id.fragment_music_play_musicname)
    TextView fragmentMusicPlayMusicname;
    @BindView(R.id.fragment_music_play_musicartist)
    TextView fragmentMusicPlayMusicartist;
    @BindView(R.id.fragment_music_nextplayimage)
    ImageView fragmentMusicNextplayimage;
    @BindView(R.id.fragment_music_playimage)
    ImageView fragmentMusicPlayimage;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mainplay, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}

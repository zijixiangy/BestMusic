package loaddata.bestmusic.ui.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import loaddata.bestmusic.R;
import loaddata.bestmusic.ui.adapter.MusiclistAdapter;

/**
 * Created by svmsung on 2017-07-24.
 */
//新分支才有这行......
public class MusicListFragment extends Fragment {
    @BindView(R.id.fg_musiclist_bd)
    ImageView fgMusiclistBd;
    @BindView(R.id.fg_musiclist_xz)
    ImageView fgMusiclistXz;
    @BindView(R.id.fg_musiclist_zj)
    ImageView fgMusiclistZj;
    @BindView(R.id.fg_musiclist_xh)
    ImageView fgMusiclistXh;
    @BindView(R.id.fg_musiclist_wl)
    ImageView fgMusiclistWl;
    @BindView(R.id.fg_musiclist_tj)
    ImageView fgMusiclistTj;
    @BindView(R.id.fg_musiclist_recycler)
    RecyclerView fgMusiclistRecycler;
    Unbinder unbinder;
    List<Map<String,Object>> mListData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_musiclist, container, false);
        unbinder = ButterKnife.bind(this, view);
         getLocaMusic();
        return view;
    }

    private void getLocaMusic() {
        //查找sd卡音乐
        Cursor mAudioCursor = getActivity().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null//字段 没有字段就是查询所有信息 相当于SQL语句中的“*”
                , null//查询条件
                , null//条件对应的？的参数
                , null);//排序方式


        mListData = new ArrayList<>();
        while (mAudioCursor.moveToNext()){
            //找到歌曲标题和总时间对对应的列索引

            //歌名
            int indexTitle=mAudioCursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
            //艺术家
            int indexArtist=mAudioCursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
            //专辑
            int indexAlbum=mAudioCursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);

            String strTitle = mAudioCursor.getString(indexTitle);
            String strArtist = mAudioCursor.getString(indexArtist);
            String strAlbum = mAudioCursor.getString(indexAlbum);

            HashMap<String,Object> nowMap=new HashMap<>();
            nowMap.put("SongName",strTitle);
            nowMap.put("SongArtist",strArtist);
            nowMap.put("SongAlbum",strAlbum);
            mListData.add(nowMap);

        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MusiclistAdapter adapter=new MusiclistAdapter(getContext(),mListData);
        fgMusiclistRecycler.setAdapter(adapter);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setStackFromEnd(false);
        fgMusiclistRecycler.setLayoutManager(llm);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fg_musiclist_bd, R.id.fg_musiclist_xz, R.id.fg_musiclist_zj, R.id.fg_musiclist_xh, R.id.fg_musiclist_wl, R.id.fg_musiclist_tj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fg_musiclist_bd:
                break;
            case R.id.fg_musiclist_xz:
                break;
            case R.id.fg_musiclist_zj:
                break;
            case R.id.fg_musiclist_xh:
                break;
            case R.id.fg_musiclist_wl:
                break;
            case R.id.fg_musiclist_tj:
                break;
        }
    }
}

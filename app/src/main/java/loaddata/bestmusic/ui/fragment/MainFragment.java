package loaddata.bestmusic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import loaddata.bestmusic.R;

/**
 * Created by svmsung on 2017-07-24.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.fg_main_tab)
    TabLayout fgMainTab;
    @BindView(R.id.fg_mian_viewpager)
    ViewPager fgMianViewpager;
    Unbinder unbinder;
    List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list=new ArrayList<>();
        MusicListFragment ml=new MusicListFragment();
        VideoFragment v=new VideoFragment();
        ZBFragment zb=new ZBFragment();
        list.add(ml);
        list.add(v);
        list.add(zb);
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };
        fgMianViewpager.setAdapter(adapter);
        fgMainTab.setupWithViewPager(fgMianViewpager);
        setItem();
        //添加标签选择监听
        fgMainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setSelectTab(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.skin_tab_icon_now_normal);
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.skin_tab_icon_plugin_normal);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.skin_tab_icon_contact_normal);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //设置ViewPager预加载个数,设置屏幕以外的页面
        fgMianViewpager.setOffscreenPageLimit(3);
    }

    private void setItem() {
        fgMainTab.getTabAt(0).setIcon(R.mipmap.skin_tab_icon_now_normal);
        fgMainTab.getTabAt(1).setIcon(R.mipmap.skin_tab_icon_plugin_normal);
        fgMainTab.getTabAt(2).setIcon(R.mipmap.skin_tab_icon_contact_normal);

        setSelectTab(fgMainTab.getTabAt(fgMainTab.getSelectedTabPosition()));
    }
    private void setSelectTab(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                tab.setIcon(R.mipmap.skin_tab_icon_now_selected);
                break;
            case 1:
                tab.setIcon(R.mipmap.skin_tab_icon_plugin_selected);
                break;
            case 2:
                tab.setIcon(R.mipmap.skin_tab_icon_contact_selected);
                break;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

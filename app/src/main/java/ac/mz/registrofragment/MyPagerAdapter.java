package ac.mz.registrofragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MyPagerAdapter extends FragmentPagerAdapter {
     private final List<Fragment> fragmentList = new ArrayList();
     private final List<String> fragmentTitleList = new ArrayList<>();


    public MyPagerAdapter( FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        // Adicione os fragments e os títulos correspondentes à lista
        fragmentList.add(new New1());
        fragmentTitleList.add("Registo de Estudantes");

        fragmentList.add(new New2());
        fragmentTitleList.add("Listar");

        fragmentList.add(new New3());
        fragmentTitleList.add("Configuracoes");
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}

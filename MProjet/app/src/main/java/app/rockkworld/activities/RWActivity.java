package app.rockkworld.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.rockkworld.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RWActivity extends AppCompatActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rw);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_hambuger)
    public void toggleHambuger(ImageView button) {
        if (mDrawer!=null){
           if(mDrawer.isDrawerOpen(GravityCompat.START)){
               mDrawer.closeDrawer(GravityCompat.START);
           }else {
               mDrawer.openDrawer(GravityCompat.START);
           }
        }
    }
    @OnClick(R.id.btn_search)
    public void openSearch(ImageView button) {
    }
}

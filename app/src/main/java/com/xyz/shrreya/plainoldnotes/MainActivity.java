package com.xyz.shrreya.plainoldnotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.xyz.shrreya.plainoldnotes.database.NoteEntity;
import com.xyz.shrreya.plainoldnotes.ui.NotesAdapter;
import com.xyz.shrreya.plainoldnotes.utilities.SampleData;
import com.xyz.shrreya.plainoldnotes.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @OnClick({R.id.fab})
    void fabClickHandler(){
        Intent intent=new Intent(this, EditorActivity.class);
        startActivity(intent);

    }

    private List<NoteEntity> notesData= new ArrayList<>();
    private NotesAdapter mAdapter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        initViewModel();
    }

    private void initViewModel() {

        final Observer<List<NoteEntity>> noteObserver = new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                notesData.clear();
                notesData.addAll(noteEntities);

                if(mAdapter == null){
                    mAdapter = new NotesAdapter(notesData,MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                }
                else
                    mAdapter.notifyDataSetChanged();
            }
        };
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.mNotes.observe(this,noteObserver);
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        if(id== R.id.action_add_sample_data){
            addSampleData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addSampleData() {
        viewModel.addSampleData();
    }
}

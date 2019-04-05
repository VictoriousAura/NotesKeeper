package com.xyz.shrreya.plainoldnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.xyz.shrreya.plainoldnotes.model.NoteEntity;
import com.xyz.shrreya.plainoldnotes.ui.NotesAdapter;
import com.xyz.shrreya.plainoldnotes.utilities.SampleData;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        notesData.addAll(SampleData.getNotes());
        for (NoteEntity notes:
             notesData) {
            Log.i("PlainOldNotes",notes.toString());

            
        }
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new NotesAdapter(notesData,this);
        mRecyclerView.setAdapter(mAdapter);
    }
}

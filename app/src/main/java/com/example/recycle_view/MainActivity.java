package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements KontakAdapter.OnContactClickListener {
    public RecyclerView rv;
    public KontakAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Kontak> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvContact);

        listContact.add(new Kontak("Indah", "083119168139", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Suci", "083822002616", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Rahmawati", "081982367654", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Azka", "081276549087", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Rival", "0831111999", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Citra", "087199006543", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Maulvi", "089543409558", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));
        listContact.add(new Kontak("Cio", "083176853597", "https://icon-library.com/images/contacts-icon-png/contacts-icon-png-0.jpg"));

        contactAdapter = new KontakAdapter(listContact);
        contactAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Kontak kontak = listContact.get(position);
        Toast.makeText(this, kontak.getNama(), Toast.LENGTH_LONG).show();
        String nomorTelepon = kontak.getTelepon();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + nomorTelepon));
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

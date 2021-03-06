package joseduin.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import joseduin.petagram.adaptador.MascotaAdaptador;
import joseduin.petagram.modelo.Mascota;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton floatingActionButton;
    private AppCompatImageView mascotasFav;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(toolbar);

        enlazarVistaControlador(toolbar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    private void enlazarVistaControlador(Toolbar toolbar) {
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mascotasFav = (AppCompatImageView) toolbar.findViewById(R.id.mascotasFav);

        floatingActionButton.setOnClickListener(this);
        mascotasFav.setOnClickListener(this);
    }

    private void inicializarMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.pet_25_512, "Catty", "Mixto", 2, 5));
        mascotas.add(new Mascota(R.drawable.bulldog, "Zeus", "Bulldog", 3, 5));
        mascotas.add(new Mascota(R.drawable.dog_512, "Scott", "Mixto", 4, 10));
        mascotas.add(new Mascota(R.drawable.dogbread, "Khan", "Terrier", 2, 3));
        mascotas.add(new Mascota(R.drawable.husky, "Capitan", "Husky", 3, 5));
        mascotas.add(new Mascota(R.drawable.pet_04_512, "Ronny", "Mixto", 1, 7));
        mascotas.add(new Mascota(R.drawable.pet_20_512, "Amber", "Mixto", 6, 8));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        recyclerView.setAdapter(adaptador);
    }

    private void irMascotasFavoritas() {
        Intent intent = new Intent(this, FavoritePets.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:
                Snackbar.make(v, "Picture!", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.mascotasFav:
                irMascotasFavoritas();
                break;
        }
    }

}

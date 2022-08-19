package com.paredes.ep1p3.vista;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.paredes.ep1p3.BD.SQLiteConexion;
import com.paredes.ep1p3.BD.Transacciones;
import com.paredes.ep1p3.R;
import com.paredes.ep1p3.controlador.AuxiliarMedicamento;
import com.paredes.ep1p3.controlador.MedicamentoAdapter;
import com.paredes.ep1p3.modelo.Medicamento;

import java.util.ArrayList;

public class ActivityMostrar extends AppCompatActivity implements AuxiliarMedicamento
{

    RecyclerView idrecyclerview;
    ArrayList<Medicamento> medicamentoArrayList;
    SQLiteConexion db;

    private MedicamentoAdapter medicamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        idrecyclerview=findViewById(R.id.idrecyclerview);

        medicamentoArrayList = new ArrayList<>();

        db = new SQLiteConexion(getApplicationContext(), Transacciones.NameDataBase, null, 1);

        medicamentoAdapter = new MedicamentoAdapter(this,medicamentoArrayList);

        RecyclerView recyclerView = findViewById(R.id.idrecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(medicamentoAdapter);
        MostrarDatos();

    }

    public void MostrarDatos()
    {
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Medicamento medicamento = null;

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM medicamentos",null);
        while (cursor.moveToNext())
        {
            medicamento=new Medicamento();
            medicamento.setId(cursor.getInt(0));
            medicamento.setDescripcion(cursor.getString(1));
            medicamento.setCantidad(cursor.getInt(2));
            medicamento.setHoras(cursor.getString(3));
            medicamento.setPeriocidad(cursor.getInt(4));
            medicamento.setImagen(cursor.getBlob(5));

            medicamentoAdapter.agregarMedicamento(medicamento);
        }

    }

    @Override
    public void OpcionEditar(Medicamento medicamento)
    {
        Intent intent = new Intent(ActivityMostrar.this,ActivityModificar.class);
        intent.putExtra("medicamento",medicamento);
        startActivity(intent);
    }
}
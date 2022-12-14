package com.paredes.ep1p3.BD;

public class Transacciones
{
    public static final String tablaMedicamentos = "medicamentos";
    public static final String idMedicamento = "idMedicamento";
    public static final String descripcion = "descripcion";
    public static final String cantidad = "cantidad";
    public static final String tiempo = "tiempo";
    public static final String periodo = "periodo";
    public static final String imagen = "imagen";

    public static final String CreateTableMedicamentos =
            "CREATE TABLE medicamentos(idMedicamento INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "descripcion TEXT, cantidad INT, tiempo TEXT, periodo INT, imagen BLOB)";
    public static final String DropeTableMedicamentos =
            "DROPE TABLE IF EXISTS medicamentos";


    public static final String NameDataBase = "farmacia";

}

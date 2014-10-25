/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase auxiliar utilizada para emular la base de datos con la que trabajaríamos
 *  en caso de un desarrollo completo de la app.
 * 
 */
public class DBHelper extends SQLiteOpenHelper {
	 
	private static final String DATABASE_NAME = "TicketCrowdDB";
    private static final int DATABASE_VERSION = 1;
     
    public static class TablaOffer{
        public static String TABLA_OFFER = "offer";
        public static String COLUMNA_ID = "_id"; //autoincremented id. one for each note.
        public static String COLUMNA_NAME = "name";
        public static String COLUMNA_DESCRIPTION = "description";
        public static String COLUMNA_ID_ITEM = "id_item";
        public static String COLUMNA_DISCOUNTXUSER = "discountxuser";
        public static String COLUMNA_DISCOUNTMAX = "discountmax";
        public static String COLUMNA_NUSERS= "nusers";
        
    }
     
    /**
     * Instructuon for sql for create the table: notas whit the columns: -_id
     * 																	 -texto
     * 																	 -type
     * 																	 -id_day
     * 																	 -time
     */
     private static final String DATABASE_CREATE = "create table "
            + TablaOffer.TABLA_OFFER + "(" + TablaOffer.COLUMNA_ID
            + " integer primary key autoincrement, " + TablaOffer.COLUMNA_NAME
            + " text not null," + TablaOffer.COLUMNA_DESCRIPTION
            + " text not null," + TablaOffer.COLUMNA_ID_ITEM
            + " integer,"  + TablaOffer.COLUMNA_DISCOUNTXUSER
            + " integer," + TablaOffer.COLUMNA_DISCOUNTMAX
            + " integer," + TablaOffer.COLUMNA_NUSERS
            + " integer);";
     
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("delete table if exists " + TablaOffer.TABLA_OFFER);
        onCreate(db);
    }

    
}
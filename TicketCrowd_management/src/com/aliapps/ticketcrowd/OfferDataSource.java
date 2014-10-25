/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aliapps.ticketcrowd.DBHelper.TablaOffer;

/**
 * Clase auxiliar utilizada para emular la base de datos con la que trabajaríamos
 *  en caso de un desarrollo completo de la app.
 * 
 */
public class OfferDataSource {
	    private SQLiteDatabase db;
	    private DBHelper dbHelper;
	    private String[] columnas = { 	
	    		TablaOffer.COLUMNA_ID,
	    		TablaOffer.COLUMNA_NAME,
	    		TablaOffer.COLUMNA_DESCRIPTION,
	    		TablaOffer.COLUMNA_ID_ITEM,
	    		TablaOffer.COLUMNA_DISCOUNTXUSER,
	    		TablaOffer.COLUMNA_DISCOUNTMAX,
	    		TablaOffer.COLUMNA_NUSERS };

	    public OfferDataSource(Context context) {
	        dbHelper = new DBHelper(context);
	    }
	 
	    public void open() {
	        db = dbHelper.getWritableDatabase();
	    }
	 
	    public void close() {
	    	if (dbHelper != null) {
	    		dbHelper.close();
	        }
	    }
	 
	    public void createOffer(String name, String description, long id_item, long discountxuser, long discountmax,long nusers) {
	        ContentValues values = new ContentValues();
	        values.put(TablaOffer.COLUMNA_NAME, name);
	        values.put(TablaOffer.COLUMNA_DESCRIPTION, description);
	        values.put(TablaOffer.COLUMNA_ID_ITEM, id_item);
	        values.put(TablaOffer.COLUMNA_DISCOUNTXUSER, discountxuser);
	        values.put(TablaOffer.COLUMNA_DISCOUNTMAX, discountmax);
	        values.put(TablaOffer.COLUMNA_NUSERS, nusers);

	        db.insert(TablaOffer.TABLA_OFFER, null, values);
	    }
	    
	    public void editOffer(String name, String description, long id_item, long discountxuser, long discountmax, long nusers, long id) {
	        ContentValues values = new ContentValues();
	        values.put(TablaOffer.COLUMNA_NAME, name);
	        values.put(TablaOffer.COLUMNA_DESCRIPTION, description);
	        values.put(TablaOffer.COLUMNA_ID_ITEM, id_item);
	        values.put(TablaOffer.COLUMNA_DISCOUNTXUSER, discountxuser);
	        values.put(TablaOffer.COLUMNA_DISCOUNTMAX, discountmax);
	        values.put(TablaOffer.COLUMNA_NUSERS, nusers);
	        db.update(TablaOffer.TABLA_OFFER, values, TablaOffer.COLUMNA_ID+"="+ id, null);
	    }
	    
	    public List<Offer> getAllOffers() {
	        List<Offer> listOffers = new ArrayList<Offer>();
	 
	        Cursor cursor = db.query(TablaOffer.TABLA_OFFER, columnas, null, null,
	                null, null, null);
	        
	        cursor.moveToFirst();
	        while (!cursor.isAfterLast()) {
	        	Offer newOffer = cursorToOffer(cursor);
	        	listOffers.add(newOffer);
		        cursor.moveToNext();
	        }
	            
	 
	        cursor.close();
	        return listOffers;
	    }

	    public Offer getOfferbyid(long id) {
	        Cursor cursor = db.query(TablaOffer.TABLA_OFFER, columnas, null, null,
	                null, null, null);
	        Offer offer=new Offer();
	        
	        cursor.moveToFirst();
	        while (!cursor.isAfterLast()) {
	        	Offer newoffer = cursorToOffer(cursor);
	        	if(id==newoffer.getId())
	        	{
	        		offer=newoffer;
	        	}
		        cursor.moveToNext();
	        }
	        cursor.close();
	        return offer;
	    }

	    public void eraseOffer(Offer offer) {
	        long id = offer.getId();
	        db.delete(TablaOffer.TABLA_OFFER, TablaOffer.COLUMNA_ID + " = " + id,
	                null);
	    }
	    
	    private Offer cursorToOffer(Cursor cursor) {
	    	Offer offer = new Offer();
	    	offer.setId(cursor.getLong(0));
	    	offer.setName(cursor.getString(1));
	    	offer.setDescription(cursor.getString(2));
	    	offer.setId_item(cursor.getLong(3));
	    	offer.setDiscountxUser(cursor.getLong(4));
	    	offer.setDiscountmax(cursor.getLong(5));
	    	offer.setnUsers(cursor.getLong(6));
	        return offer;
	    }
	}
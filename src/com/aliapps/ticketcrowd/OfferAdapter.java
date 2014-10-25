/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Activity auxiliar para crear el listado de ofertas.
 *
 */

public class OfferAdapter  extends BaseAdapter {
	 
	//All the private variable that will be used in this activity.
    private Activity activity;
    private List<Offer> data;
    private static LayoutInflater inflater=null;
	
	/***
	 * This function is call for setting the different variables needed in this class.
	 * 
	 * @param a
	 * @param d
	 * @param bloque_seleccionado this is the block of movies to be shown
	 * @param pictures an array whit the direction in memory of the pictures.
	 */
    public OfferAdapter(Activity a, List<Offer> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    /***
     * This function will set and show each row whit a diferect movie data.
     */
    public View getView(int position, View convertView, ViewGroup parent) {
    	List<Offer> offer;
    	offer = data;
    	View vi=convertView;
    	
	
        if(convertView==null)
            vi = inflater.inflate(R.layout.single_offer_list, null);
 
        TextView offertv = (TextView)vi.findViewById(R.id.name); // text of the note
        
        // Setting all values in listview
        offertv.setText(offer.get(position).getName());
       
        return vi;
       	
    }
    
   
}
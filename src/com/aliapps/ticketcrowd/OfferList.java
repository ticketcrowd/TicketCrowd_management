/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Activity con la lista de todas las ofertas guardadas.
 * 
 */
public class OfferList extends Activity implements OnItemClickListener {
	    private int requestCode = 1;
	    private ListView lvOffers;
	    private OfferDataSource dataSource;
	    private List<Offer> listOffers;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_offer_list);
	 
	        // Instanciamos NotasDataSource para
	        // poder realizar acciones con la base de datos
	        dataSource = new OfferDataSource(this);
	        dataSource.open();
	 
	        // Instanciamos los elementos
	        lvOffers = (ListView) findViewById(R.id.offerlist_lvOffers);
	        // Cargamos la lista de notas disponibles
	        listOffers = dataSource.getAllOffers();

	        OfferAdapter adapter = new OfferAdapter(this, listOffers);
	 
	        // Establecemos el adapter
	        lvOffers.setAdapter(adapter);
	 
	        // Establecemos un Listener para el evento de pulsación
	        lvOffers.setOnItemClickListener(this);
	    }

    	//TODO: Enlazar al NuevaOffer
	    public void addOffer(View v) {
	        Intent i = new Intent(this, NewOfferActivity.class);
	        
	        startActivityForResult(i, requestCode);
	    }
	 
	    @Override
	    public void onItemClick(final AdapterView<?> adapterView, View view,
	            final int position, long id) {
	    	//TODO: Enlazar al EditAdecuado
	    	Intent i = new Intent(this, EditOfferActivity.class);	
	        i.putExtra("id", listOffers.get(position).getId());
	        startActivityForResult(i, requestCode);
	    }
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        if (requestCode == this.requestCode && resultCode == RESULT_OK) {
	            // Actualizar el Adapter
	            dataSource.open();
	            refreshList();
	        }
	    }
	 
	    private void refreshList() {
	        // Cargamos la lista de notas disponibles
	    	listOffers = dataSource.getAllOffers();
	        OfferAdapter adapter = new OfferAdapter(this, listOffers);
	        lvOffers.setAdapter(adapter);
	    }
	 
	    @Override
	    protected void onPause() {
	        dataSource.close();
	        super.onPause();
	    }
	 
	    @Override
	    protected void onResume() {
            dataSource.open();
            refreshList();
	        super.onResume();
	    }
}
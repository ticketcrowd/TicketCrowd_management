/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Activity utilizada para editar ofertar ya integradas en la base de datos. 
 * 
 */

public class EditOfferActivity extends Activity {

	 public static int resultCode = 10;
	 
	    private Button btnAdd;
	    private EditText txtName;
	    private EditText txtDescription;
	    private EditText txtIdItem;
	    private EditText txtDiscount;
	    private EditText txtMax;
	    private OfferDataSource dataSource;   
    	private Offer offer;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_edit_offer);

	        dataSource = new OfferDataSource(this);
	        dataSource.open();
	        			
        	Intent intent = getIntent();
			Bundle bundle = intent.getExtras();
			final long id=bundle.getLong("id");
			offer=dataSource.getOfferbyid(id);
			
			txtName = (EditText) findViewById(R.id.editoffer_name);
	        txtDescription = (EditText) findViewById(R.id.editoffer_adddescription);
	        txtIdItem = (EditText) findViewById(R.id.editoffer_addiditem);
	        txtDiscount = (EditText) findViewById(R.id.editoffer_adddiscount);
	        txtMax = (EditText) findViewById(R.id.editoffer_addmax);
	        
			txtName.setText(String.valueOf(offer.getName()));
			txtDescription.setText(String.valueOf(offer.getDescription()));
			txtIdItem.setText(String.valueOf(offer.getId_item()));
			txtDiscount.setText(String.valueOf(offer.getDiscountxUser()));
			txtMax.setText(String.valueOf(offer.getDiscountmax()));
	        
			btnAdd = (Button) findViewById(R.id.editoffer_btnAdd);
			btnAdd.setOnClickListener(new View.OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {

	                String newname = txtName.getText().toString();
	                String newdescription = txtDescription.getText().toString();
	                Long newiditem = Long.valueOf(txtIdItem.getText().toString());
	                Long newdiscount = Long.valueOf(txtDiscount.getText().toString());
	                Long newmax = Long.valueOf(txtMax.getText().toString());	  
	            	
	                if (newname.length() != 0) {
	                    dataSource.editOffer(newname, newdescription,newiditem,newdiscount,newmax,0,id);
	                    setResult(RESULT_OK);
	                    finish();
	                } else {
	                    Toast.makeText(getApplicationContext(),
	                            "No ha introducido texto", Toast.LENGTH_SHORT)
	                            .show();
	                }
	            }
	        });
	    }
	    
		public void eraseOffer(View view) {
			dataSource.eraseOffer(offer);
			finish();
		}
}

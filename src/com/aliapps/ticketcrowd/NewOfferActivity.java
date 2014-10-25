/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity que añade nuevas ofertas al sistema.
 * 
 */
public class NewOfferActivity extends Activity {
	 
	    private Button btnAdd;
	    private EditText txtName;
	    private EditText txtDescription;
	    private EditText txtIdItem;
	    private EditText txtDiscount;
	    private EditText txtMax;
	    private OfferDataSource dataSource;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_newoffer);

	        dataSource = new OfferDataSource(this);
	        dataSource.open();

	        txtName = (EditText) findViewById(R.id.newoffer_addname);
	        txtDescription = (EditText) findViewById(R.id.newoffer_adddescription);
	        txtIdItem = (EditText) findViewById(R.id.newoffer_addiditem);
	        txtDiscount = (EditText) findViewById(R.id.newoffer_adddiscount);
	        txtMax = (EditText) findViewById(R.id.newoffer_addmax);
	        	        
	        btnAdd = (Button) findViewById(R.id.newoffer_btnAdd);
	        btnAdd.setOnClickListener(new View.OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {

	                String newname = txtName.getText().toString();
	                String newdescription = txtDescription.getText().toString();
	                Long newiditem = Long.valueOf(txtIdItem.getText().toString());
	                Long newdiscount = Long.valueOf(txtDiscount.getText().toString());
	                Long newmax = Long.valueOf(txtMax.getText().toString());	    			
	                if (newname.length() != 0) {
	                	
	                    dataSource.createOffer(newname, newdescription,newiditem,newdiscount,newmax,0);
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
	 
	}

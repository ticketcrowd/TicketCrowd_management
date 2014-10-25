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

/**
 * Activity central de acceso a los diferentes apartados de la aplicación.
 * 
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /***
	 * Go to the OfferList Activity in response to button
	 * @param view
	 */
	public void OfferList(View view) {
		 Intent intent = new Intent(this, OfferList.class);
		 startActivity(intent);
	}
    /***
	 * Go to the ScanOffer Activity in response to button
	 * @param view
	 */
	public void ScanOffer(View view) {
		 Intent intent = new Intent(this, ScanOffer.class);
		 startActivity(intent);
	}
    /***
	 * Go to the Statistics Activity in response to button
	 * @param view
	 */
	public void Statistics(View view) {
		 Intent intent = new Intent(this, Statistics.class);
		 startActivity(intent);
	}
    /***
	 * Go to the Exit Activity in response to button
	 * @param view
	 */
	public void Exit(View view) {
		 Intent intent = new Intent(this, LoginActivity.class);
		 startActivity(intent);
         finish();
	}
}

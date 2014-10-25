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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * 
 * Activity que permite escanear códigos de barras, qrs etc con el apoyo de la herramienta zxing.
 */
public class ScanOffer extends Activity implements OnClickListener{
	private Button scanBtn;
	private TextView contentTxt;
	private TextView scanoffer_textView;
	private ImageView scanoffer_imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan_offer);
		
		scanBtn = (Button)findViewById(R.id.scanoffer_btn);
		contentTxt = (TextView)findViewById(R.id.scanoffer_content);
		scanoffer_textView = (TextView)findViewById(R.id.scanoffer_textView);
		scanoffer_imageView = (ImageView)findViewById(R.id.scanoffer_imageView);

		scanoffer_textView.setVisibility(View.GONE);
		scanoffer_imageView.setVisibility(View.GONE);
        
		scanBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.scanoffer_btn){
			//scan
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
			}
	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		//retrieve scan result
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			//we have a result
			String scanContent = scanningResult.getContents();
			contentTxt.setText("La id de la oferta escaneada es: " + scanContent);
			scanoffer_textView.setVisibility(View.VISIBLE);
			scanoffer_imageView.setVisibility(View.VISIBLE);
		}else{
			scanoffer_textView.setVisibility(View.GONE);
			scanoffer_imageView.setVisibility(View.GONE);
			Toast toast = Toast.makeText(getApplicationContext(), 
	            "No scan data received!", Toast.LENGTH_SHORT);
	        toast.show();
	    }
	}
}

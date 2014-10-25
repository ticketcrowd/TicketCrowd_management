/**
 * C�digo creado por Aliapps para FinAppsParty 2014
 * 		No� Andr�s Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lled� Sig�enza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Activity de Login, en esta versi�n Beta de la App, no se ha desarrollado esta parte para ahorrar tiempo,
 * por ser igual que en cualquier otra App.
 * 
 * Actualmente se ponga lo que se ponga dar� acceso a la aplicaci�n al usuario de la aplicaci�n.
 * 
 */
public class LoginActivity extends Activity {
    Button btnLogin;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
 
        // Importing all assets like buttons, text fields
        btnLogin = (Button) findViewById(R.id.btnLogin);
 
        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    
}

/**
 * Código creado por Aliapps para FinAppsParty 2014
 * 		Noé Andrés Marcos: sesghar@gmail.com
 * 		Manuel David Vicent Gimenez: manuelda89@hotmail.com
 * 		Pedro J. Lledó Sigüenza: pls@usebox.net
 */

package com.aliapps.ticketcrowd;

/**
 * Objeto Oferta que utilizaremos a lo largo de la aplicación con todas las características de las ofertas.
 *
 */
public class Offer  {
	    private long id;
	    private String name;
	    private String description;
	    private long id_item;
	    private long discountxuser;
	    private long discountmax;
	    private long nusers;
	    private String texto;
	    
	    public long getId() {
	        return id;
	    }
	 
	    public void setId(long id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public String getDescription() {
	        return description;
	    }
	 
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	    public long getId_item() {
	        return id_item;
	    }
	 
	    public void setId_item(long id_item) {
	        this.id_item = id_item;
	    }
	    
	    public long getDiscountxUser() {
	        return discountxuser;
	    }
	 
	    public void setDiscountxUser(long discountxuser) {
	        this.discountxuser = discountxuser;
	    }
	    
	    public long getDiscountmax() {
	        return discountmax;
	    }
	 
	    public void setDiscountmax(long discountmax) {
	        this.discountmax = discountmax;
	    }

	    
	    public long getnUsers() {
	        return nusers;
	    }
	 
	    public void setnUsers(long nusers) {
	        this.nusers = nusers;
	    }

	    
	    @Override
	    public String toString(){
	        return texto;
	    }
}

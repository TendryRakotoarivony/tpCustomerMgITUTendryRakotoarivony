/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tendry.tpcustomermgitutendryrakotoarivony.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.tendry.tpcustomermgitutendryrakotoarivony.entity.Customer;
import mg.tendry.tpcustomermgitutendryrakotoarivony.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList.
 * @author Tendry Arivony
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
private List<Customer> customerList;  

  @Inject
  private CustomerManager customerManager;  
        
  public CustomerBean() {  }  
        
  /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
   */  
  public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }  
    
}

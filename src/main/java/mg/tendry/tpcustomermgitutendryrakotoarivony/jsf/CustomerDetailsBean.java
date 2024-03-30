
package mg.tendry.tpcustomermgitutendryrakotoarivony.jsf;

import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import mg.tendry.tpcustomermgitutendryrakotoarivony.entity.Customer;
import mg.tendry.tpcustomermgitutendryrakotoarivony.entity.Discount;
import mg.tendry.tpcustomermgitutendryrakotoarivony.service.CustomerManager;
import mg.tendry.tpcustomermgitutendryrakotoarivony.service.DiscountManager;

/**
 * Backing bean pour la page CustomerDetails.xhtml.
 * @author Tendry Arivony
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {
  private int idCustomer;
  private Customer customer;

  @Inject
  private CustomerManager customerManager;
  
  @Inject
  private DiscountManager discountManager;
  

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (contenu dans l'attribut customer de
   * cette classe).
     * @return 
   */
    public Customer getCustomer() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer (sera expliqué dans le cours).
    customer = customerManager.update(customer);
    return "customerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.findById(idCustomer); 
  }
  
  /**
   * Retourne la liste de tous les Discount.
     * @return 
   */
  public List<Discount> getDiscounts() {
    return discountManager.getAllDiscounts();
  }
}
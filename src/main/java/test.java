import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.enums.HospitalTypeEnum;
import com.hastanerandevu.model.HospitalModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Okan on 9.3.2017.
 */
public class test {
  public static void main(String[] args) {
    /*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ProjectConstants.persistenceUnitName);
    EntityManager entitymanager = emfactory.createEntityManager();
    entitymanager.getTransaction().begin();

    HospitalModel hospitalModel = new HospitalModel();
    hospitalModel.setHospitalName("zxczxczxc");

    entitymanager.persist(hospitalModel);
    entitymanager.getTransaction().commit();

    entitymanager.close();
    emfactory.close();*/

    HospitalTypeEnum[] enumValues = HospitalTypeEnum.values();

    for (HospitalTypeEnum hospitalTypeEnum : enumValues){
      System.out.println(hospitalTypeEnum.getLocalizedString());
    }

  }
}

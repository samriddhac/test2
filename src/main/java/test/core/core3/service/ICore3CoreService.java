package test.core.core3.service;

import java.util.*;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import test.core.core3.model.*;

public interface ICore3CoreService {

  void addPet(ServiceRequestContext context);

  void updatePet(ServiceRequestContext context);

  List<Pet> findPetsByStatus(ServiceRequestContext context);

  List<Pet> findPetsByTags(ServiceRequestContext context);

  Pet getPetById(long petId, ServiceRequestContext context);

  void updatePetWithForm(long petId, ServiceRequestContext context);

  void deletePet(long petId, ServiceRequestContext context);

  ModelApiResponse uploadFile(long petId, ServiceRequestContext context);

  Object getInventory(ServiceRequestContext context);

  Order placeOrder(ServiceRequestContext context);

  Order getOrderById(long orderId, ServiceRequestContext context);

  void deleteOrder(long orderId, ServiceRequestContext context);

  void createUser(ServiceRequestContext context);

  void createUsersWithArrayInput(ServiceRequestContext context);

  void createUsersWithListInput(ServiceRequestContext context);

  Object loginUser(ServiceRequestContext context);

  void logoutUser(ServiceRequestContext context);

  User getUserByName(String username, ServiceRequestContext context);

  void updateUser(String username, ServiceRequestContext context);

  void deleteUser(String username, ServiceRequestContext context);
}

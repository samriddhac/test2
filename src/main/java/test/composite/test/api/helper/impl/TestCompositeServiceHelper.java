package test.composite.test.api.helper.impl;

import java.util.*;

import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.composite.test.api.helper.ITestCompositeServiceHelper;
import test.composite.test.model.*;

@Component
public class TestCompositeServiceHelper implements ITestCompositeServiceHelper {

  private static final Logger LOG = LoggerFactory.getLogger(TestCompositeServiceHelper.class);

  @Autowired private ModelMapper modelMapper;

  @Autowired private ObjectMapper objectMapper;

  @Override
  public void processFindSourceAccountsRequest(ServiceExecution execution) {
    execution.setServiceCall("04464947-4e5c-4dba-8ac3-1ca7e7cc9713", true);
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processFindSourceAccountsResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processFindTargetAccountsRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processFindTargetAccountsResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processFindAttributesRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processFindAttributesResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processValidateAttributesRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processValidateAttributesResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processFindProfilesRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processFindProfilesResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }

  @Override
  public void processCreateProfileRequest(ServiceExecution execution) {
    // TODO: your code goes here...
  }

  @Override
  public ServiceResponseContext processCreateProfileResponse(ServiceExecution execution) {
    // TODO: your code goes here...
    return null;
  }
}

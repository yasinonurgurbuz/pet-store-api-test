package com.pet.store.journey.base;

import com.pet.store.journey.models.response.PetResponse;
import com.pet.store.journey.models.response.UserResponse;
import com.pet.store.journey.models.response.OrderResponse;
import com.pet.store.journey.utils.Retry;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class BaseTest extends ClientBaseTest {

    public UserResponse userResponse;
    public OrderResponse orderResponse;
    public PetResponse petResponse;
    public List<PetResponse> petResponseList;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        for (ITestNGMethod method : context.getSuite().getAllMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }
}

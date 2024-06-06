if (api.isInputGenerationExecution())  {
//If running in intelliJ give customer input selection
    if (api.isDebugMode()) {
        api.inputBuilderFactory()
                .createCustomerEntry("Customer")
                .setLabel("Customer")
                .getInput()
    }
}
// if not in inputgeneratrionExecution set return to Customer input value
else  return input.Customer


//// if testing in IntelliJ the element out value will be Standard
//if (api.isDebugMode()) {
//    return "Standard"
//}
//else {
//    // in Pricefx web application the element out value will be set to the Header input
//    return input.DeliveryType
//}


/*
Add the following code to the Customer element, we will use api.isDebugMode()
to determine if we are testing in IntelliJ , if true will add a customer input
you can set for testing. If running on application it will set the element value
to the Header input.Customer value.
*/

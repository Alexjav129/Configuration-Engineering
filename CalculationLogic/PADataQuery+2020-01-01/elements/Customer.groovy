// code to define an input parameter for the Customer ID:
if (api.isInputGenerationExecution()) {       // (1)
    return api.inputBuilderFactory()
            .createUserEntry("Customer")      // (2)
            .setLabel("Customer")
            .getInput()
}
return input.Customer                         // (3)


/*
Always make sure that only the desired code is executed in Input
Generation Execution Mode by using api.isInputGenerationExecution()
*/
if(api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
            .createUserEntry("ListPrice")
            .getInput()
    api.inputBuilderFactory()
            .createUserEntry("Discount")
            .getInput()
} else {
    if(input.ListPrice == null || input.Discount == null) {
        return null
    }
    return input.ListPrice - input.Discount
}


/*
Note: the method api.inputBuilderFactory() is used to generate the input
parameters, which will be mapped to the fields in the Datamart, but will
not be used for actual user input
 */
/*
api.inputBuilderFactory()
        .createIntegerUserEntry("Quantity")
        .setLabel("Quantity")
        .getInput()
*/


/*
api.inputBuilderFactory()
        .createIntegerUserEntry("Quantity")
        .setLabel("Quantity")
        .getInput()
*/

if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setLabel("Quantity")
            .setRequired(true)   //<1>   //sets default value to 1
            .setValue(1)         //<2>   //sets default value to 1
            .setFrom(0)          //<3>   //sets minimum value to 0
            .getInput()
}
else{
    return input.Quantity
}




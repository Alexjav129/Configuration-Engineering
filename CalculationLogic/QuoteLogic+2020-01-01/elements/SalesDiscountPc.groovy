if (api.isInputGenerationExecution()) {
    return  api.inputBuilderFactory()
            .createUserEntry("SalesDiscountPct")
            .setLabel("Sales Discount (%)")
            .setFormatType("PERCENT")  //sets the format to a percentage
            .setFrom(0.00)             // percent
            .setTo(1.00)               // percent
    // .setValue(0)            //prefills value to 0
            .getInput()
}
else {
    return input.SalesDiscountPct
}
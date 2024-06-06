if (quoteProcessor.isPostPhase()) {              // (1)
    return
}

def deliveryType = api.inputBuilderFactory()     // (2)
        .createOptionEntry("DeliveryType")
        .setLabel("Delivery Type")
        .setRequired(true)
        .setOptions(["Express", "Standard"])
        .setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])
        .buildMap()                             // (3)

quoteProcessor.addOrUpdateInput(deliveryType)   // (4)

/*
1.Check if the logic is running in Post Phase, if yes we don’t want to build the input parameter
2.With the Input builder we create an input field with desired properties
3.Builds the input field map
4.Creates the input field
*/


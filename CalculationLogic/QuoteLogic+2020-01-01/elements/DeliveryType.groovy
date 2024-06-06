// if testing in IntelliJ the element out value will be Standard
if (api.isDebugMode()) {
    return "Standard"
}
else {
    // in Pricefx web application the element out value will be set to the Header input
    return input.DeliveryType
}
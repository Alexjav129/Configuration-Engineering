def country = api.customer("Country", out.Customer)
//create keys for country and delivery type
def keys = [
        "Country": country,
        "DeliveryType": out.DeliveryType
]
//Use vlookup method and pass a map of keys as parameter
def freightSurcharge= api.vLookup("FreightSurcharge", "FreightSurcharge", keys)
//The freightSurcharge table doesn't have match for all countries and delivery types
//This checks for this and gives detailed information
if (freightSurcharge==null){
    api.addWarning("unable to determine frieght surcharge for customer's country $country and Delivery Type $out.DeliveryType")
    return 0
}
else return freightSurcharge

/*
note how we get the header input values from the element return values.
We use these values to determine the Customer’s Country and lookup values
from the FreightSurcharge parameter table with the Country and DeliveryType values.
*/
// value in column "attribute1" in the PX table "ProductCost" for the row with sku


def avgCost = api.productExtension("ProductCost")?.getAt(0)?.attribute1
api.trace("avgCost", null, avgCost)
return avgCost


//The find method finds the first value in a collection that matches some criterion

/* The safe navigation operator will simply return null
if the reference object is null instead of throwing an NullPointerException. */


//def avgCost = api.productExtension("ProductCost")?.getAt(0)?.attribute1
//
//if(avgCost == null) {
//    api.addWarning("Could not find Average Cost in PX table ProductCost")
//    return null
//}
//
//return avgCost
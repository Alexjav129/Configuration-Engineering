// ProductCost = from product extension Product Cost

def avgCost = api.productExtension("ProductCost")?.getAt(0)?.attribute1
api.trace("avgCost", null, avgCost)
return avgCost
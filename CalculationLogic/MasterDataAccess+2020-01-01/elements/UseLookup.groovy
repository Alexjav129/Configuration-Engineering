def row =[:]    //define row as Map outside of loop

List<String> fields = ["sku", "attribute1", "attribute2"]

api.stream("P", "sku", fields)?.withCloseable { iterator->
    iterator.each {comp->

        if (comp.sku != null && comp.attribute1 != null) {
            row = [
                    "sku"         : comp.sku,
                    "ProductGroup": comp.attribute1,
                    "BusinessUnit": comp.attribute2,
                    "Margin Adj"  : api.vLookup("MarginAdj", comp.attribute1)
            ]
        }
        api.trace("Row: ", row)
    }
}
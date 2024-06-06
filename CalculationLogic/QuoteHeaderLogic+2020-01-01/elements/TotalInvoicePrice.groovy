//api.trace("quoteView", quoteProcessor.quoteView)

if (quoteProcessor.isPrePhase()) {
    return
}

List<Object> lineItems = quoteProcessor.quoteView.lineItems.findAll {
    !it.folder
}

List<String> warnings = null
BigDecimal sum = 0.0
for (lineItem in lineItems) {
    BigDecimal price = lineItem?.outputs?.find { lineItemOutput ->
        lineItemOutput.resultName == "TotalInvoicePrice"
    }?.result

    if (price == null) {
        sum = null
        warnings = ["Unable to calculate: value for TotalInvoicePrice is " +
                            "missing on one of the line items."]
        break
    }

    sum += price

    api.trace("Line", lineItem?.sku, price) // TODO remove
}

api.trace("Total invoice price", sum) // TODO remove

// Add output
def output = [
        resultName   : "TotalInvoicePrice",
        resultLabel  : "Total Invoice Price",
        result       : sum,
        formatType   : "MONEY_EUR",
        resultType   : "SIMPLE",
        cssProperties: "background-color:#99FFDD",
        warnings     : warnings
]
quoteProcessor.addOrUpdateOutput(output)

/*
Study the traced quoteView json in order to find out
how to refer the output from the element TotalInvoicePrice.
 */
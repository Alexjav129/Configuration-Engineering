def totalInvoicePrice = 0.0

quote.lineItems.findAll {
    !it.folder
}.each { lineItem ->
    BigDecimal lineItemTotalInvoicePrice = lineItem.outputs.find {
        it.resultName == "TotalInvoicePrice"
    }?.result

    if(!lineItemTotalInvoicePrice){
        api.throwException("Unable to build workflow. Unable to calculate " +
                " Total Invoice Price for entire quote. Missing for row " +
                " ${lineItem.sku}")
    }

    totalInvoicePrice += lineItemTotalInvoicePrice
}

def approvalLevels = api.findLookupTableValues("ApprovalLevelsRevenue", "ApprovalLevel")

approvalLevels.each { level ->
    def threshold = level.attribute1
    def userGroup = level.attribute2

    if (totalInvoicePrice >= threshold) {
        workflow.addApprovalStep(userGroup)
                .withReasons("Total Invoice Price > " + (threshold as String) + "EUR")
                .withUserGroupApprovers(userGroup)
                .withMinApprovalsNeeded(1)
    }
}

/*
Note: use api.throwException() instead of throw new Exception(). Both methods will work,
but the first one will render a end-user friendlier error message on the screen.
*/
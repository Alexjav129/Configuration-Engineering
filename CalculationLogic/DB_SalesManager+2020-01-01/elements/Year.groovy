if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createDmFilter("Year", "DM.Transaction", "InvoiceDateYear")
            .getInput()
}

return input.Year


/*

TIP
You can also create exactly the same input using method .dimFilterEntry.

def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def column = dm.getColumn("InvoiceDateYear")

return ctx.dimFilterEntry("Year", column)?.getValue()

 */
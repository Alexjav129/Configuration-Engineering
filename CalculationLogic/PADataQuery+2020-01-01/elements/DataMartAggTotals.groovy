// code to create a DataMartContext object and then to define the Datamart
// that we will be accessing (in this case, Transactions DM).
def dmCtx = api.getDatamartContext()
def salesDM = dmCtx.getTable("Transaction")

// Next, we need to create a Filter object using the Customer ID value.
def filters = [
        Filter.equal("CustomerId", out.Customer)
]

// Now we can build a query against our DataMart object called salesDM.
def datamartQuery = dmCtx.newQuery(salesDM, true)

// Next, we use the select method to add the columns to the SELECT statement
// of our query that will provide the attribute aggregation values.
datamartQuery.select("CustomerId", "Customer ID")
datamartQuery.select("COUNTDISTINCT(InvoiceDate)", "invoiceCount")
datamartQuery.select("SUM(Margin)/COUNTDISTINCT(InvoiceDate)", "Avg Profit")
datamartQuery.select("SUM(InvoicePrice)", "Total Revenue")
datamartQuery.select("SUM(Margin)", "Total profit")
datamartQuery.select("SUM(Quantity)", "Total Qty")
datamartQuery.select("SUM(Discount)", "Total Discount")

// Next, we need to add our query filter
datamartQuery.where(filters)

// Next, we need to execute our query and add an iterative loop to display the values.
def result = dmCtx.executeQuery(datamartQuery)
result?.data.each{ row ->     // row as map
    api.trace("query row", row)
}
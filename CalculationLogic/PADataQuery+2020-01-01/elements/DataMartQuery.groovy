//create a DataMartContext object and then to define the Datamart that we will
// be accessing (in this case, Transactions DM)
def dmCtx = api.getDatamartContext()
def salesDM = dmCtx.getDatamart("Transaction")

// Next, we need to get the Customer input value by adding the following:
def customer = out.Customer

// Now we can build a query against our DataMart object called salesDM
def datamartQuery = dmCtx.newQuery(salesDM)

// Next, we use the select method to add the columns to the SELECT statement of our query.
//  From the datamart we need to retrieve the customer ID, invoice data and cost attributes.
datamartQuery.select("CustomerId")
datamartQuery.select("Cost")
datamartQuery.select("InvoiceDate")

// The final component of this query will be the addition of a WHERE statement.
// that will utilize a FILTER object to search on our customer ID value
datamartQuery.where(
        Filter.equal("CustomerID", customer)
)

// Finally, we are ready to execute our query and return the resultset
def result = dmCtx.executeQuery(datamartQuery)
//return result

result?.getData()?.forEach { row ->
    api.trace("Customer ID:", row.CustomerId)
    api.trace("Date:", row.InvoiceDate)
    api.trace("Cost", row.Cost)
}
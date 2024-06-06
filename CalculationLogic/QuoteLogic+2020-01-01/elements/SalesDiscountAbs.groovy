if (out.ListPrice == null || out.SalesDiscountPc == null) {
    api.addWarning("Sales Discount cannot be calculated: missing parameter(s)")
    return null
}

return out.ListPrice * out.SalesDiscountPc
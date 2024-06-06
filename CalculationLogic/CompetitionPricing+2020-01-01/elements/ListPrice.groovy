// ListPrice = CompetitionProductPrice * CompetitivePositioning

if(out.CompetitorProductPrice == null || out.CompetitivePositioning == null ) {
    api.addWarning("List Price cannot be calculated: missing parameter(s).")
    return null
}

def listPrice = out.CompetitorProductPrice + out.CompetitivePositioning

return listPrice
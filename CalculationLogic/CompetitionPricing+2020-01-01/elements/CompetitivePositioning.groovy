// CompetitivePositioning = from provided Price Parameter, based on Business Unit of the SKU

def businessUnit = api.product("BusinessUnit")
return api.vLookup("CompetitionStrategy", "CompetitivePositioning", businessUnit)
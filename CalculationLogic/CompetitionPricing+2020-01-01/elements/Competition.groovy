//Debug Code Start

/**
 * Spaceship operator Example - returns 0 ( Equal ) , negative 1 a < b, one ( 1 ) a > b
 *
 * groovy> def d = new Date()
 * groovy> println d <=> d
 * groovy> println 3 <=> 4
 * groovy> println “doberman” <=> “dachshund”
 * groovy> println d <=> new Date()

 0
 -1
 1
 -1


 def x = api.productCompetition(
 Filter.equal("competitionType", "Online"),
 Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
 )

 api.trace("Competition no sort : ",x)

 api.trace("Competition sort on 1 col : ",
 x?.sort { a, b ->
 b.infoDate <=> a.infoDate }
 )

 api.trace("Competition sort on 2 col : ",
 x?.sort { a, b ->
 b.infoDate <=> a.infoDate ?:
 a.price <=> b.price}
 )



 api.trace("Competition sort  on 2 col & find: ",
 x?.sort { a, b ->
 b.infoDate <=> a.infoDate ?:
 a.price <=> b.price }?.find()
 )
 api.trace("X & find: ",  x?.find() )
 */
// Debug Code End  ...or simply x?.find()
// api.productCompetition() call
compPrice =  api.productCompetition(
        Filter.equal("competitionType", "Online"),
        Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
        //Sorting and Finding
)?.sort { a, b ->
    b.infoDate <=> a.infoDate ?:
            a.price <=> b.price }
        ?.find()

// Logging and Handling Missing Price
api.trace("competition product price" , compPrice.price)

// Logs the competition product price using api.trace
if ( compPrice == null || compPrice == 0 ) {
    api.addWarning("No competitior price found ...using current price")
    def compMap = [:]
    compMap = ["competitor": "!! No Competitor Found !!", "label": api.product("label"), "price": api.productExtension("ProductCost")?.find()?.attribute1]
    api.trace("CompMap is ",compMap)
    return compMap
    // Returning Valid Price
} else {
    api.trace("Returned Map",compPrice)
    return compPrice
}


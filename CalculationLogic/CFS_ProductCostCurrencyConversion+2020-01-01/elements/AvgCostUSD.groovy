def cost = api.currentItem().attribute1
def exchangeRate = 1.1 // fixed rate for testing purposes

return cost != null ? (cost * exchangeRate) : null
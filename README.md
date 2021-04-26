# Flight and airport information API

##### Task made for smart4aviation recruitment process 

#####You can test Api by swagger on:

https://flight-information-api.com/swagger-ui/index.html#/

## available API
- get
    - Get flight and baggage numbers in airport
    - Get weight of specific flight
- post
    - Create new flight
    - Create cargo for flight
    
## example request

##### curl:
    curl -X GET "https://flight-information-api.com/airport/getFlightAndBaggageNumbers/GDN" -H "accept: */*"
    
##### response body:

    {
      "departingFlightsNumber": 1,
      "arrivingFlightsNumber": 2,
      "baggageArrivingPieces": 2338,
      "baggageDepartingPieces": 2751
    }
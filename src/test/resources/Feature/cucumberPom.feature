Feature: Verify Adactin Webpage

  Scenario Outline: Adactin Login Page execute
    Given User should be in adactin home page
    When User should enter the "<userName>" and "<Password>"
    And User should click the login button and verify login message

    Examples: 
      | userName      | Password  |
      | NarenElango23 | Naren2327 |

  Scenario Outline: Adactin Hotel Search Page
    Given User Should Hotel be in Search Page
    When User Enter the hotellocation "<Location>","<HotelName>","<RoomType>","<NumOfRoom>","<Indate>","<Outdate>","<NumOfAdults>","<numOfChild>"
    And User should click the search button and verify search message

    Examples: 
      | Location | HotelName      | RoomType     | NumOfRoom | Indate     | Outdate    | NumOfAdults | numOfChild |
      | Sydney   | Hotel Sunshine | Super Deluxe |         6 | 12/12/2023 | 24/12/2023 |           4 |          2 |

  Scenario: Select Hotel Page
    Given User Shuold be in Hotel Page
    When User Should select the Hotel and click continue
    

  Scenario Outline: Book a Hotel Page
    Given User Should be in Book a Hotel Page
    When User Enter Firstname "<FirstName>","<LastName>","<Address>","<CardNumber>","<CardType>","<month>","<year>","<cvvNum>"
    And User shoud click the BookNow button and verify booking
    And User Should get the OrderId

    Examples: 
      | FirstName   | LastName | Address  | CardNumber       | CardType | month | year | cvvNum |
      | NARENDHIRAN | ELANGO   | Namakkal | 1224364860728496 | AMEX     |    May | 2022 |    278 |

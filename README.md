# Microservices Project Using SpringBoot

This microservices project is built using Maven and Spring Boot 3.2.2. It consists of three main modules - UserService, HotelService, and RatingService. The project utilizes Eureka Server as a Service Registry to register all services. Additionally, there is a ConfigServer service fetching common configurations from GitHub.

## Modules

### UserService

- Manages user details.
- Utilizes Feign Client to call external services.
- Running on `8080` port
- Using MySql Database default database is test
- User Entity has attributes like userId, name, email, about
- Application name =`USER-SERVICE`

### HotelService

- Manages hotel details.
- Uses Eureka Server for service registration.
- Implements a controller for CRUD operations on hotels.
 - Running on `8081` port
- Using MySql Database default database is test
- User Entity has attributes like id, name, location, about
- Application name =`HOTEL-SERVICE`

### RatingService

- Manages ratings for hotels.
- Implements a controller for CRUD operations on ratings.
- Utilizes Feign Client for external service calls.
- -Running on `8082` port
- Using MySql Database default database is test
- User Entity has attributes like ratingid, userId, hotelId, about
- Application name =`RATING-SERVICE`

### ConfigServer

- Fetches common configurations stored in GitHub. [Link For ConfigServer Repo](https://github.com/Subhajitgarai/Microservice_Configuration)
-  Running on `8083` port
- Application name =`CONFIG-SERVICE`

### ApiGateway

- Redirects requests to desired services like User-Service, Hotel-Service or Ratings-Service.
- Running on port `8084`.
- Secured with Okta Authentication.
- Application name =`API-GATEWAY`

### ServiceRegistry
- Used to Register all the Running Microservices
- Running on Port `8761`
- Registered Services
    1. `HOTEL-SERVICE`
    2. `RATING-SERVICE`
    3. `USER-SERVICE`
    4. `CONFIG-SERVER`
    5. `API-GATEWAY`


## Configuration

- Eureka Server is used as the Service Registry.
- ConfigServer fetches common configurations from GitHub.
- Feign Clients are configured for external service calls.

## How to Run

1. Start Eureka Server.
2. Start ConfigServer.
3. Start each microservice module (UserService, HotelService, RatingService).
4. Start ApiGateway.

## API Endpoints

### UserService

- POST `/users`: Create a new user.
- GET `/users`: Get all users.
- GET `/users/{userId}`: Get user details by ID. Here by Internal Api calling all the Ratting and Hotels details are also atachted [Called the internal apis by RestTeamplate and Feign Client]

### HotelService

- POST `/hotels`: Create a new hotel.
- GET `/hotels`: Get all hotels.
- GET `/hotels/{hotelId}`: Get hotel details by ID.

### RatingService

- POST `/ratings`: Add a new rating.
- GET `/ratings`: Get all ratings.
- GET `/ratings/user/{userId}`: Get ratings by user ID.
- GET `/ratings/hotel/{hotelId}`: Get ratings by hotel ID.

## External Services

### Feign Clients

- `HotelExternalService`: Calls HotelService API.
- `RatingsExternalService`: Calls RatingService API.

## Okta Authentication

- The ApiGateway is secured using `Okta` Authentication.

## Notes

- Hotel entity in HotelService has attributes: `id, name, location, and about`.
- Rating entity in RatingService has attributes: `ratingsId, userId, hotelId, rating, and feedback`.
- User entity in UserService has attributes: `userId, name, email, about, and a transient list of ratings`.
- External services are called using `Feign Clients` and `RestTemplate`.

## How to Run
1. Ensure `JDK 17` is installed.
2. Clone the repository.
3. Navigate to the project directory.
4. Download `Intellij Idea` and run it as a SpringBoot Project




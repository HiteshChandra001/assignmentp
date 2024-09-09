# Coding_Challenge

## Overview
This Spring Boot project provides a Product Management API with functionalities to create products and retrieve products by category. Built with Java and Spring Boot, it uses RestTemplate for communication with external API and Maven for project management, offering a streamlined solution for product data management.

- **Create Product**: Add a new Product to the server.
- **Get Product List By Category**: Retrieve a list of Products by Category.


## API Endpoints

- **POST /products**: Create a new product.

### Sample Request Body:
```json
{
    "title": "bag - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
}
```

### Sample Response Body:
```json
{
    "id": 21,
    "price": 109.95,
    "title": "bag - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rating": null
}
```



- **GET /products/byCategory/jewellery**: Retrieve a list of product by category.

### Sample Response Body:
```json
[
    {
        "id": 5,
        "price": 695.0,
        "title": "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
        "description": "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
        "category": "jewelery",
        "image": "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
        "rating": {
            "rate": 4.6,
            "count": 400
        }
    }
]
```

### Technologies Used

- **Backend**: Java, Spring Boot, RestTemplate, Maven

### Prerequisites

- **Java**: JDK 17 or later
- **Maven**: 3.6 or later

### Getting Started

### Backend Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/HiteshChandra001/assignmentp.git
    cd coding_challenge
    ```

2. **Build and Run the Backend**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The backend server will run on `http://localhost:8080`.

<hr>


# Theoritical_Challenge

## Overview
This project allows users to upload a CSV file, which is then processed and returned as a downloadable CSV file. The processing involves operations calculating and transforming the data. Built using Spring Boot, it efficiently handles file uploads and returns the processed result in real time.

- **Upload CSV**:  upload a CSV file and in response, It returns a processed CSV file.

  
## API Endpoints

- **POST /csv/process**: upload a CSV file and in response, It returns a processed CSV file.


#### Sample Request:
```bash
"12","8","=A1*B1","=C1+5"
"6","3","=A2-B2","=C2*3"
"9","2","=A3/B3","=D2-7"
"14","7","=A4+B4","=A4*2"
```


#### Sample Response:
```bash
"12.0","8.0","96.0","101.0"
"6.0","3.0","3.0","9.0"
"9.0","2.0","4.5","2.0"
"14.0","7.0","21.0","28.0"
```


### Technologies Used

- **Backend**: Java, Spring Boot, OpenCSV, Maven

### Prerequisites

- **Java**: JDK 17 or later
- **Maven**: 3.6 or later

### Getting Started

### Backend Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/HiteshChandra001/assignmentp.git
    cd theoritical_challenge
    ```

2. **Build and Run the Backend**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The backend server will run on `http://localhost:9000`.

    


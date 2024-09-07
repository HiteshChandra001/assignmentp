# Coding_Challenge

## Overview
This Spring Boot project provides a Product Management API with functionalities to create products and retrieve products by category. Built with Java and Spring Boot, it uses RestTemplate for communication with external API and Maven for project management, offering a streamlined solution for product data management.

- **Create Product**: Add a new Product to the server.
- **Get Product List By Category**: Retrieve a list of Products by Category.

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

    
## API Endpoints

- **POST /products**: Create a new product.
- **GET /products/byCategory/jewellery**: Retrieve a list of product by category.


<hr>


# Theoritical_Challenge

## Overview
This project allows users to upload a CSV file, which is then processed and returned as a downloadable CSV file. The processing involves operations calculating and transforming the data. Built using Spring Boot, it efficiently handles file uploads and returns the processed result in real time.

- **Upload CSV**:  upload a CSV file and in response, It returns a processed CSV file.

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

    
## API Endpoints

- **POST /csv/process?file=input**: upload a CSV file and in response, It returns a processed CSV file.



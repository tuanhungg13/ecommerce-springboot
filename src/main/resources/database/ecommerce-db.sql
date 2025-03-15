CREATE DATABASE ecommerce_db;


CREATE TABLE users (
    uid varchar(255) PRIMARY KEY ,
    email VARCHAR(255) UNIQUE,
    avatar varchar(255),
    role INT,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    phoneNumber VARCHAR(10),
    password VARCHAR(255),
    accessToken varchar(255),
    refreshToken varchar(255),
    createdAt date
);

CREATE TABLE addresses (
    addressId BIGINT PRIMARY KEY AUTO_INCREMENT,
    uid varchar(255),
    street VARCHAR(255),
    ward VARCHAR(255),
    district VARCHAR(255),
    province VARCHAR(255),
    country VARCHAR(255),
    FOREIGN KEY (uid) REFERENCES users(uid) ON DELETE CASCADE
);

CREATE TABLE carts (
    cartId BIGINT PRIMARY KEY AUTO_INCREMENT,
    totalPrice DOUBLE,
    uid varchar(255),
    FOREIGN KEY (uid) REFERENCES users(uid) ON DELETE CASCADE
);

CREATE TABLE categories (
    categoryId BIGINT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(255)
);

CREATE TABLE collections (
    collectionId BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    productId BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    discount DOUBLE,
    image VARCHAR(255),
    price DOUBLE,
    productName VARCHAR(255),
    quantity INT,
    special_price DOUBLE,
    categoryId BIGINT,
    collectionId BIGINT,
	FOREIGN KEY (collectionId) REFERENCES collections(collectionId) ON DELETE SET NULL,
    FOREIGN KEY (categoryId) REFERENCES categories(categoryId) ON DELETE SET NULL
);



CREATE TABLE colors (
    colorId BIGINT PRIMARY KEY AUTO_INCREMENT,
    colorName VARCHAR(50) NOT NULL
);

CREATE TABLE productImages (
    imageId BIGINT PRIMARY KEY AUTO_INCREMENT,
    productId BIGINT,
    imageUrl VARCHAR(255) NOT NULL,
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE
);

CREATE TABLE sizes (
    sizeId BIGINT PRIMARY KEY AUTO_INCREMENT,
    sizeName VARCHAR(10) NOT NULL
);


CREATE TABLE productVariants (
    variantId BIGINT PRIMARY KEY AUTO_INCREMENT,
    productId BIGINT NOT NULL,
    colorId BIGINT NOT NULL,
    sizeId BIGINT NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE,
    FOREIGN KEY (colorId) REFERENCES colors(colorId) ON DELETE CASCADE,
    FOREIGN KEY (sizeId) REFERENCES sizes(sizeId) ON DELETE CASCADE,
    UNIQUE (productId, colorId, sizeId)
);


CREATE TABLE cartItems (
    cartItemId BIGINT PRIMARY KEY AUTO_INCREMENT,
    discount DOUBLE,
    quantity INT,
    cartId BIGINT,
    variantId BIGINT,
    FOREIGN KEY (cartId) REFERENCES carts(cartId) ON DELETE CASCADE,
    FOREIGN KEY (variantId) REFERENCES productVariants(variantId) ON DELETE CASCADE
);

CREATE TABLE payments (
    paymentId BIGINT PRIMARY KEY AUTO_INCREMENT,
    paymentMethod VARCHAR(255)
);

CREATE TABLE orders (
    orderId BIGINT PRIMARY KEY AUTO_INCREMENT,
    uid varchar(255) ,
    shippingPhoneNumber varchar(255) NOT NULL,
    shippingAddress varchar(255) NOT NULL,
    customerName VARCHAR(100) NOT NULL,
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    orderStatus ENUM('PENDING', 'CONFIRMED', 'SHIPPED', 'DELIVERED', 'CANCELLED') DEFAULT 'PENDING',
    totalAmount DECIMAL(10,2) NOT NULL,
    paymentId BIGINT,
    discount DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (paymentId) REFERENCES payments(paymentId) ON DELETE SET NULL,
    FOREIGN KEY (uid) REFERENCES users(uid) ON DELETE CASCADE
);


CREATE TABLE orderItems (
    orderItemId BIGINT PRIMARY KEY AUTO_INCREMENT,
    discount DOUBLE,
    orderedProductPrice DOUBLE,
    quantity INT,
    orderId BIGINT,
    variantId BIGINT,
    FOREIGN KEY (orderId) REFERENCES orders(orderId) ON DELETE CASCADE,
    FOREIGN KEY (variantId) REFERENCES productVariants(variantId) ON DELETE CASCADE
);

CREATE TABLE ratingProduct (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uid varchar(255) NOT NULL,
    productId BIGINT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (uid) REFERENCES users(uid) ON DELETE CASCADE,
    FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE
);

CREATE TABLE coupon (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL, -- Mã giảm giá
    discount DECIMAL(10,2) NOT NULL, -- Số tiền hoặc phần trăm giảm
    type ENUM('PERCENT', 'FIXED') NOT NULL, -- Loại giảm giá (theo % hoặc số tiền)
    min_order DECIMAL(10,2) DEFAULT 0, -- Giá trị đơn hàng tối thiểu để áp dụng
    quantity INT DEFAULT 1, -- Số lần sử dụng tối đa
    expiration_date DATE, -- Ngày hết hạn
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
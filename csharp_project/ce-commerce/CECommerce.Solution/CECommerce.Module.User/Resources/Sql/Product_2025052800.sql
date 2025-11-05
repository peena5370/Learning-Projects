CREATE DATABASE ecommerce_db
GO

USE ecommerce_db
GO

-- user_account Table
CREATE TABLE user_account (
    user_id BIGINT NOT NULL PRIMARY KEY,
    username VARCHAR(20) NULL UNIQUE, -- Added UNIQUE constraint for username
    password_hash CHAR(63) NULL,
    email VARCHAR(200) NOT NULL UNIQUE, -- Added UNIQUE constraint for email
    phone_number VARCHAR(20) NOT NULL,
    two_fa_enabled BIT NOT NULL,
    auth_provider VARCHAR(20) NOT NULL,
    is_locked BIT NOT NULL,
    status VARCHAR(20) NOT NULL,
    last_login_at DATETIME NULL,
    created_at DATETIME NOT NULL,
    deleted_at DATETIME NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL
);

---

-- mfa Table
CREATE TABLE mfa (
    mfa_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    mfa_method VARCHAR(20) NOT NULL, -- Changed to NOT NULL as an MFA method should always exist
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_mfa_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- user_role Table
CREATE TABLE user_role (
    role_id BIGINT NOT NULL PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL UNIQUE, -- Added UNIQUE constraint for role_name
    is_active BIT NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL
);

---

-- user_user_role Table (Junction Table for Many-to-Many relationship)
CREATE TABLE user_user_role (
    user_role_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT FK_user_user_role_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id),
    CONSTRAINT FK_user_user_role_role_id FOREIGN KEY (role_id) REFERENCES user_role(role_id),
    CONSTRAINT UQ_user_user_role UNIQUE (user_id, role_id) -- Ensures a user has a specific role only once
);

---

-- buyer_profile Table
CREATE TABLE buyer_profile (
    buyer_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE, -- User ID should be unique to a buyer profile
    fullname VARCHAR(200) NOT NULL,
    display_name VARCHAR(200) NULL,
    date_of_birth DATE NOT NULL,
    age TINYINT NOT NULL,
    nationality_code VARCHAR(20) NOT NULL,
    bio_data VARCHAR(200) NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_buyer_profile_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- admin_profile Table
CREATE TABLE admin_profile (
    admin_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE, -- User ID should be unique to an admin profile
    fullname VARCHAR(200) NOT NULL,
    date_of_birth DATE NOT NULL,
    age TINYINT NOT NULL,
    nationality VARCHAR(20) NOT NULL,
    department VARCHAR(200) NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_admin_profile_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- seller_profile Table
CREATE TABLE seller_profile (
    seller_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE, -- User ID should be unique to a seller profile
    business_name VARCHAR(200) NOT NULL,
    date_of_birth DATE NOT NULL,
    age TINYINT NOT NULL,
    nationality VARCHAR(20) NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_seller_profile_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- product_category Table (Defined before product as it's a dependency)
CREATE TABLE product_category (
    category_id BIGINT NOT NULL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE, -- Category names should be unique
    is_active BIT NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL
);

---

-- product Table
CREATE TABLE product (
    product_id BIGINT NOT NULL PRIMARY KEY,
    product_name VARCHAR(200) NOT NULL,
    description TEXT NULL,
    price DECIMAL(10, 2) NOT NULL,
    sku VARCHAR(50) NOT NULL UNIQUE, -- SKU should be unique for products
    quantity INT NOT NULL,
    category_id BIGINT NOT NULL,
    is_active BIT NOT NULL,
    created_at DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_product_category_id FOREIGN KEY (category_id) REFERENCES product_category(category_id)
);

---

-- product_image Table
CREATE TABLE product_image (
    image_id BIGINT NOT NULL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    image_path VARCHAR(200) NOT NULL,
    image_type VARCHAR(50) NOT NULL,
    image_size INT NOT NULL,
    uploaded_date DATETIME NOT NULL,
    CONSTRAINT FK_product_image_product_id FOREIGN KEY (product_id) REFERENCES product(product_id)
);

---

-- cart Table
CREATE TABLE cart (
    cart_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE, -- A user typically has only one active cart
    created_at DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_cart_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- cart_item Table
CREATE TABLE cart_item (
    item_id BIGINT NOT NULL PRIMARY KEY,
    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT FK_cart_item_cart_id FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
    CONSTRAINT FK_cart_item_product_id FOREIGN KEY (product_id) REFERENCES product(product_id),
    CONSTRAINT UQ_cart_item UNIQUE (cart_id, product_id) -- A product can only be in a cart once
);

---

-- shipping_address Table
CREATE TABLE shipping_address (
    address_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type VARCHAR(50) NOT NULL, -- Consider renaming to address_label or similar for clarity
    country VARCHAR(100) NULL,
    city VARCHAR(100) NULL,
    postal_code INT NULL,
    address_1 VARCHAR(200) NULL,
    address_2 VARCHAR(200) NULL,
    is_default BIT NOT NULL,
    address_type VARCHAR(20) NOT NULL, -- This seems redundant with 'type' column, consider consolidating
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_shipping_address_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

---

-- order Table
CREATE TABLE [order] ( -- Enclosed in brackets as 'order' is a reserved keyword in SQL Server
    order_id BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    order_date DATE NOT NULL,
    payment_status VARCHAR(20) NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    address_id BIGINT NOT NULL,
    tracking_number VARCHAR(50) NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_order_user_id FOREIGN KEY (user_id) REFERENCES user_account(user_id),
    CONSTRAINT FK_order_address_id FOREIGN KEY (address_id) REFERENCES shipping_address(address_id)
);

---

-- order_item Table
CREATE TABLE order_item (
    order_item_id BIGINT NOT NULL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    sub_total DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_order_item_order_id FOREIGN KEY (order_id) REFERENCES [order](order_id),
    CONSTRAINT FK_order_item_product_id FOREIGN KEY (product_id) REFERENCES product(product_id),
    CONSTRAINT UQ_order_item UNIQUE (order_id, product_id) -- A product can only be an item in a specific order once
);

---

-- order_payment Table
CREATE TABLE order_payment (
    payment_id BIGINT NOT NULL PRIMARY KEY,
    order_id BIGINT NOT NULL UNIQUE, -- An order typically has one primary payment record
    payment_method VARCHAR(50) NOT NULL,
    payment_date DATETIME NOT NULL,
    payment_amount DECIMAL(10, 2) NOT NULL,
    payment_status VARCHAR(20) NOT NULL,
    modified_at DATETIME NOT NULL,
    modified_by BIGINT NULL,
    CONSTRAINT FK_order_payment_order_id FOREIGN KEY (order_id) REFERENCES [order](order_id)
);
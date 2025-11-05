CREATE DATABASE ecommerce_db;
GO

USE ecommerce_db;
GO

CREATE TABLE product_product (
product_id VARCHAR(32) NOT NULL,
product_name VARCHAR(200) NOT NULL,
product_description TEXT NOT NULL,
product_price DECIMAL NOT NULL,
status BIT NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(product_id)
);

CREATE TABLE product_image (
image_id VARCHAR(32) NOT NULL,
image_location VARCHAR(500) NOT NULL,
product_id VARCHAR(32) NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(image_id)
);

CREATE TABLE product_category (
category_id VARCHAR(32) NOT NULL,
category_name VARCHAR(200) NOT NULL,
is_enabled BIT NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE product_product_category (
product_category_id VARCHAR(32) NOT NULL,
product_id VARCHAR(200) NOT NULL,
category_id TEXT NOT NULL,
PRIMARY KEY(product_category_id)
);

CREATE TABLE product_seller (
product_seller_id VARCHAR(32) NOT NULL,
product_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
product_quantity INT NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(product_seller_id)
);

CREATE TABLE product_tag (
tag_id VARCHAR(32) NOT NULL,
tag_name VARCHAR(32) NOT NULL,
parent_tag_id VARCHAR(32) NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(tag_id)
);

CREATE TABLE product_product_tag (
product_tag_id VARCHAR(32) NOT NULL,
product_id VARCHAR(32) NOT NULL,
tag_id VARCHAR(32) NOT NULL,
PRIMARY KEY(product_tag_id)
);

CREATE TABLE product_review (
review_id VARCHAR(32) NOT NULL,
product_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
rating INT NOT NULL,
comment VARCHAR(500) NOT NULL,
created_at DATETIME NOT NULL,
PRIMARY KEY(review_id)
);

CREATE TABLE product_review_image (
review_image_id VARCHAR(32) NOT NULL,
review_id VARCHAR(32) NOT NULL,
image_location VARCHAR(500) NOT NULL,
PRIMARY KEY(review_image_id)
);

CREATE TABLE cart_cart (
cart_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(cart_id)
);

CREATE TABLE cart_item (
cart_item_id VARCHAR(32) NOT NULL,
cart_id VARCHAR(32) NOT NULL,
product_id VARCHAR(32) NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY(cart_item_id)
);

CREATE TABLE order_order (
order_id VARCHAR(32) NOT NULL,
user_id VARCHAR(32) NOT NULL,
order_date DATETIME NOT NULL,
payment_status VARCHAR(20) NOT NULL,
order_status VARCHAR(50) NOT NULL,
ship_address_id VARCHAR(32) NOT NULL,
delivery_partner_id VARCHAR(32) NULL,
tracking_number VARCHAR(100) NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(order_id)
);

CREATE TABLE order_item (
order_item_id VARCHAR(32) NOT NULL,
order_id VARCHAR(32) NOT NULL,
product_id VARCHAR(32) NOT NULL,
quantity INT NOT NULL,
order_price DECIMAL NOT NULL,
PRIMARY KEY(order_item_id)
);

CREATE TABLE order_payment (
payment_id VARCHAR(32) NOT NULL,
order_id VARCHAR(32) NOT NULL,
payment_method VARCHAR(50) NOT NULL,
payment_date DATETIME NOT NULL,
payment_amount DECIMAL NOT NULL,
payment_status VARCHAR(20) NOT NULL,
transaction_id VARCHAR(32) NULL,
PRIMARY KEY(payment_id)
);

-- To be expand this table
CREATE TABLE order_transaction (
transaction_id VARCHAR(32) NOT NULL,
PRIMARY KEY(transaction_id)
);

CREATE TABLE order_refund (
refund_id VARCHAR(32) NOT NULL,
order_id VARCHAR(32) NOT NULL,
reason VARCHAR(50) NOT NULL,
request_date DATETIME NOT NULL,
refund_status VARCHAR(50) NOT NULL,
admin_response VARCHAR(50) NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(refund_id)
);

CREATE TABLE system_configuration (
system_id VARCHAR(32) NOT NULL,
system_key VARCHAR(100) NOT NULL,
system_value TEXT NOT NULL,
system_description TEXT NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(system_id)
);

CREATE TABLE delivery_partner (
delivery_partner_id VARCHAR(32) NOT NULL,
delivery_partner_name VARCHAR(100) NOT NULL,
delivery_partnet_phone VARCHAR(50) NOT NULL,
delivery_partnet_email VARCHAR(20) NOT NULL,
delivery_partnet_status VARCHAR(20) NOT NULL,
created_at DATETIME NOT NULL,
modified_at DATETIME NOT NULL,
modified_by VARCHAR(32) NULL,
PRIMARY KEY(delivery_partner_id)
);

CREATE TABLE delivery_partner_delivery (
delivery_id VARCHAR(32) NOT NULL,
delivery_partner_id VARCHAR(32) NOT NULL,
order_id VARCHAR(50) NOT NULL,
delivery_status VARCHAR(20) NOT NULL,
assigned_at DATETIME NOT NULL,
delivered_at DATETIME NOT NULL,
PRIMARY KEY(delivery_id)
);
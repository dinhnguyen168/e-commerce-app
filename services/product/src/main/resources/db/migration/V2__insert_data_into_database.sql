-- V2__insert_sample_data.sql

-- Insert categories
INSERT INTO category (id, name, description)
VALUES (nextval('category_seq'), 'Electronics', 'Electronic devices and gadgets'),
       (nextval('category_seq'), 'Clothing', 'Apparel and fashion items'),
       (nextval('category_seq'), 'Books', 'Various genres of books'),
       (nextval('category_seq'), 'Home & Kitchen', 'Home appliances and kitchenware');

-- Insert products
-- Electronics (12 products)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Smartphone', 'High-end smartphone', 100, 699.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Laptop', '15-inch laptop', 50, 999.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Wireless Earbuds', 'Bluetooth earbuds', 200, 129.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Smart TV', '55-inch 4K Smart TV', 30, 599.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Digital Camera', 'Mirrorless digital camera', 40, 799.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Smartwatch', 'Fitness tracking smartwatch', 150, 199.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Tablet', '10-inch tablet', 80, 349.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Gaming Console', 'Next-gen gaming console', 60, 499.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Bluetooth Speaker', 'Portable Bluetooth speaker', 120, 79.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'External Hard Drive', '2TB external hard drive', 100, 89.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Wireless Mouse', 'Ergonomic wireless mouse', 200, 39.99,
        (SELECT id FROM category WHERE name = 'Electronics')),
       (nextval('product_seq'), 'Wireless Keyboard', 'Slim wireless keyboard', 150, 59.99,
        (SELECT id FROM category WHERE name = 'Electronics'));

-- Clothing (13 products)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'T-Shirt', 'Cotton crew neck t-shirt', 500, 19.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Jeans', 'Classic blue jeans', 300, 49.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Dress', 'Floral summer dress', 200, 59.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Sweater', 'Wool blend sweater', 150, 69.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Jacket', 'Waterproof outdoor jacket', 100, 89.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Shorts', 'Casual khaki shorts', 250, 29.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Skirt', 'A-line midi skirt', 180, 39.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Polo Shirt', 'Classic polo shirt', 300, 34.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Hoodie', 'Zip-up hoodie', 200, 54.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Leggings', 'High-waist yoga leggings', 400, 24.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Blazer', 'Fitted blazer', 120, 79.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Socks', 'Pack of 6 ankle socks', 1000, 14.99,
        (SELECT id FROM category WHERE name = 'Clothing')),
       (nextval('product_seq'), 'Scarf', 'Soft knit scarf', 150, 19.99,
        (SELECT id FROM category WHERE name = 'Clothing'));

-- Books (13 products)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Fiction Bestseller', 'Latest fiction bestseller', 200, 24.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Cookbook', 'International cuisine cookbook', 150, 34.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Science Book', 'Popular science book', 100, 29.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'History Book', 'World history book', 120, 39.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Self-Help Book', 'Personal development book', 180, 19.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Children''s Book', 'Illustrated children''s story', 250, 14.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Biography', 'Celebrity biography', 140, 27.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Travel Guide', 'International travel guide', 160, 22.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Poetry Collection', 'Modern poetry anthology', 90, 18.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Graphic Novel', 'Superhero graphic novel', 110, 21.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Mystery Novel', 'Bestselling mystery novel', 170, 23.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Language Learning', 'Language learning textbook', 130, 31.99,
        (SELECT id FROM category WHERE name = 'Books')),
       (nextval('product_seq'), 'Art Book', 'Contemporary art collection', 80, 49.99,
        (SELECT id FROM category WHERE name = 'Books'));

-- Home & Kitchen (12 products)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Coffee Maker', 'Programmable coffee maker', 80, 79.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Blender', 'High-speed blender', 100, 89.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Toaster', '4-slice toaster', 120, 49.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Microwave', 'Countertop microwave oven', 60, 129.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Cookware Set', '10-piece non-stick cookware set', 50, 199.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Knife Set', '14-piece kitchen knife set', 70, 69.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Food Storage', '20-piece food storage set', 150, 29.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Dinner Set', '16-piece porcelain dinner set', 40, 89.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Stand Mixer', 'Professional stand mixer', 30, 249.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Rice Cooker', 'Digital rice cooker', 90, 59.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Vacuum Cleaner', 'Cordless stick vacuum', 70, 179.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen')),
       (nextval('product_seq'), 'Air Fryer', 'Digital air fryer', 110, 99.99,
        (SELECT id FROM category WHERE name = 'Home & Kitchen'));
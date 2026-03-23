-- ============================================================
-- Run this ONCE on your MySQL (local or RDS)
-- ============================================================

-- Create database
CREATE DATABASE IF NOT EXISTS productdb
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE productdb;

-- Products table (Hibernate will also auto-create via ddl-auto=update)
-- Keep this for reference / manual setup on RDS
CREATE TABLE IF NOT EXISTS products (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description VARCHAR(500),
    price       DECIMAL(10,2)  NOT NULL,
    stock       INT            NOT NULL DEFAULT 0,
    created_at  DATETIME,
    updated_at  DATETIME
);

-- Seed data for testing
INSERT INTO products (name, description, price, stock, created_at, updated_at) VALUES
('MacBook Pro 14"',  'Apple M3 chip, 16GB RAM, 512GB SSD', 1999.99, 50, NOW(), NOW()),
('Dell XPS 15',      'Intel i9, 32GB RAM, NVIDIA RTX 4060', 1749.00, 30, NOW(), NOW()),
('Sony WH-1000XM5', 'Noise cancelling wireless headphones', 349.99, 200, NOW(), NOW()),
('LG 27" 4K Monitor','IPS Panel, USB-C, 144Hz',             599.00,  75, NOW(), NOW()),
('Keychron K2 Pro',  'Wireless mechanical keyboard',         109.99, 150, NOW(), NOW());

CREATE TABLE url_shortener (
    id SERIAL PRIMARY KEY,              -- Auto-incrementing unique ID
    user_id INT NOT NULL,               -- The ID of the user who created the short URL
    short_url VARCHAR(100) NOT NULL,    -- Shortened URL slug or full short URL
    original_url TEXT NOT NULL,         -- Original full URL
    created_at TIMESTAMP DEFAULT NOW(), -- When the record was created
    updated_at TIMESTAMP DEFAULT NOW()  -- When the record was last updated
);
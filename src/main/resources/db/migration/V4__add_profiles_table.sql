CREATE TABLE profiles (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          bio TEXT,
                          phone_number VARCHAR(20),
                          date_of_birth DATE,
                          loyalty_points INT UNSIGNED DEFAULT 0,
                          user_id BIGINT,
                          CONSTRAINT fk_profiles_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

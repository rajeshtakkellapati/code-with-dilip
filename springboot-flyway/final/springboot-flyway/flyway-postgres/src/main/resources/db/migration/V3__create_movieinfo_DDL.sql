create table IF NOT EXISTS REVIEWS
(
    review_id  serial PRIMARY KEY,
    movie_info_id INT,
    review         TEXT,
    rating         INT
    );

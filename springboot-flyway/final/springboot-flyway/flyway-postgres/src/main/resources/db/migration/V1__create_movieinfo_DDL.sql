create table IF NOT EXISTS MOVIE_INFO
(
    movie_info_id  serial PRIMARY KEY,
    name         varchar(255),
    year         INT,
    release_date DATE
    );

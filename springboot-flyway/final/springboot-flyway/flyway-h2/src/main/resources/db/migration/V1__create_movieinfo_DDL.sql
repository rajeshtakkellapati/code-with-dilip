create table IF NOT EXISTS MOVIE_INFO
(
    movie_info_id  bigint auto_increment,
    name         varchar(255),
    year         INT,
    cast ARRAY,
    release_date DATE
    );

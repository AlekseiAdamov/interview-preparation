-- 1. Ошибки в расписании (пересечение расписаний разных фильмов друг на друга).
-- фильм 1 - время начала - длительность - фильм 2 - время начала - длительность
WITH movie_schedule AS (SELECT
        sessions.movie AS  movie_id,
        movies.title AS movie_title,
        sessions.schedule AS session_start,
        durations.duration AS duration,
        sessions.schedule + (durations.duration * interval '1 minute') AS session_end
    FROM cinema.sessions AS sessions
    LEFT JOIN cinema.movies AS movies ON sessions.movie = movies.id
    LEFT JOIN cinema.durations AS durations ON movies.duration = durations.id)
SELECT
    schedule1.movie_title AS title_1,
    -- ::timestamp(0) нужно для удаления миллисекунд из результата.
    schedule1.session_start::timestamp(0) AS start_1,
    schedule1.duration AS duration_1,
    schedule2.movie_title AS title_2,
    schedule2.session_start::timestamp(0) AS start_2,
    schedule2.duration AS duration_2
FROM movie_schedule AS schedule1
INNER JOIN movie_schedule AS schedule2
    ON schedule2.session_start BETWEEN schedule1.session_start AND schedule1.session_end
    AND schedule2.movie_id != schedule1.movie_id
;

-- 2. Перерывы 30 минут и более между фильмами.
-- сортировка по убыванию
-- фильм 1 - время начала - длительность - фильм 2 - время начала - длительность перерыва


-- 3. Список фильмов с количеством зрителей и кассовыми сборами.
WITH sales AS (
    SELECT
        sessions.id AS session_id,
        sessions.movie AS movie_id,
        COUNT(tickets.id) AS tickets_total,
        COUNT(tickets.id) * prices.price AS sum_total
    FROM cinema.sessions AS sessions
             LEFT JOIN cinema.prices AS prices
                       ON date_part('dow', sessions.schedule) = prices.weekday
                           AND CAST(sessions.schedule AS time) BETWEEN prices.time_from AND prices.time_till
             LEFT JOIN cinema.tickets AS tickets
                       ON sessions.id = tickets.session
    GROUP BY
        sessions.id,
        sessions.movie,
        prices.price
    ORDER BY sessions.id
)
SELECT *
FROM (SELECT
    movies.title AS movie_title,
    movies.year::text AS movie_year, -- Как текст только для того, чтобы в итогах вывести пустую ячейку, а не [null].
    SUM(sales.tickets_total) AS tickets_total,
    ROUND(AVG(sales.tickets_total)) AS tickets_avg,
    SUM(sales.sum_total) AS sum_total
FROM cinema.movies AS movies
    LEFT JOIN sales AS sales ON movies.id = sales.movie_id
GROUP BY
    movies.title,
    movies.year
ORDER BY sum_total DESC) AS sorted
UNION ALL
-- Строка итогов.
SELECT
    'TOTAL',
    '',
    SUM(sales.tickets_total),
    ROUND(AVG(sales.tickets_total)),
    SUM(sales.sum_total)
FROM sales AS sales;

-- 4. Число зрителей и кассовые сборы по временным интервалам.
SELECT
    time_interval AS time_interval,
    SUM(tickets_total) AS tickets_total,
    SUM(sum_total) AS sum_total
FROM (
    SELECT
        CASE
            WHEN date_part('hour', sessions.schedule) BETWEEN 0 AND 8 THEN '00:00 - 09:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 9 AND 14 THEN '09:00 - 15:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 15 AND 17 THEN '15:00 - 18:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 18 AND 20 THEN '18:00 - 21:00'
            ELSE '21:00 - 00:00'
        END AS time_interval,
        COUNT(tickets.id) AS tickets_total,
        COUNT(tickets.id) * prices.price AS sum_total
    FROM cinema.sessions AS sessions
    LEFT JOIN cinema.prices AS prices
            ON date_part('dow', sessions.schedule) = prices.weekday
                AND CAST(sessions.schedule AS time) BETWEEN prices.time_from AND prices.time_till
    LEFT JOIN cinema.tickets AS tickets
            ON sessions.id = tickets.session
    GROUP BY
        CASE
            WHEN date_part('hour', sessions.schedule) BETWEEN 0 AND 8 THEN '00:00 - 09:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 9 AND 14 THEN '09:00 - 15:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 15 AND 17 THEN '15:00 - 18:00'
            WHEN date_part('hour', sessions.schedule) BETWEEN 18 AND 20 THEN '18:00 - 21:00'
            ELSE '21:00 - 00:00'
        END,
        prices.price) AS time_intervals_total
GROUP BY time_interval
ORDER BY time_interval;

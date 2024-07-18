# Practicas de MySQL

Solución a los ejercicios de sqlbolt

# Exercise 1 - Task

1. Find the title of each film 
```sql
select title from movies;
```

2. Find the director of each film
```sql
select director from movies;
```

3. Find the title and director of each film
```sql
select title, director from movies;
```

4. Find the title and year of each film
```sql
select title, year from movies;
```

5. Find all the information about each film
```sql
select * from movies;
```




# Exercise 2 - Task

1. Find the movie with a row id of 6
```sql
SELECT * FROM movies where id=6;
```

2. Find the movies released in the years between 2000 and 2010
```sql
SELECT * FROM movies where year between 2000 and 2010;
```

3. Find the movies not released in the years between 2000 and 2010
```sql
SELECT * FROM movies where year not between 2000 and 2010;
```

4. Find the first 5 Pixar movies and their release year
```sql
SELECT * FROM movies where id<6;
```



# Exercise 3 - Task

1. Find all the Toy Story movies
```sql
SELECT * FROM movies where title like 'Toy Story%';
```

2. Find all the movies directed by John Lasseter
```sql
SELECT * FROM movies where director='John Lasseter';
```

3. Find all the movies (and director) not directed by John Lasseter
```sql
SELECT * FROM movies where director!='John Lasseter';
```
4. Find all the WALL-* movies
```sql
SELECT * FROM movies where title like 'WALL-%';
```


# Exercise 4- Task

1. List all directors of Pixar movies (alphabetically), without duplicates
```sql
SELECT distinct director FROM movies order by director;
```

2. List the last four Pixar movies released (ordered from most recent to least)
```sql
SELECT * FROM movies order by year desc limit 4;
```

3. List the first five Pixar movies sorted alphabetically
```sql
SELECT * FROM movies order by title limit 5;
```

4. List the next five Pixar movies sorted alphabetically
```sql
SELECT * FROM movies order by title limit 5 offset 5;
```

# Review 1 — Tasks

1. List all the Canadian cities and their populations
```sql
SELECT city, population FROM north_american_cities where country='Canada';
```

2. Order all the cities in the United States by their latitude from north to south
```sql
SELECT * FROM north_american_cities where country='United States' order by latitude desc;
```

3. List all the cities west of Chicago, ordered from west to east
```sql
SELECT * FROM north_american_cities where longitude<-87.629798 order by longitude;
```

4. List the two largest cities in Mexico (by population)
```sql
SELECT * FROM north_american_cities where country='Mexico' order by population desc limit 2;
```

5.  List the third and fourth largest cities (by population) in the United States and their population
```sql
SELECT * FROM north_american_cities where country='United States' order by population desc limit 2 offset 2;
```


# Exercise 6 — Tasks

1. Find the domestic and international sales for each movie
```sql
SELECT * FROM movies  inner join Boxoffice on movies.id=Boxoffice.Movie_id;
```

2. Show the sales numbers for each movie that did better internationally rather than domestically
```sql
SELECT * FROM movies 
inner join Boxoffice
on movies.id=Boxoffice.Movie_id
where international_sales>domestic_sales;
```

3. List all the movies by their ratings in descending order
```sql
SELECT * FROM movies 
inner join Boxoffice
on movies.id=Boxoffice.Movie_id
order by rating desc;
```


# Exercise 7 — Tasks

1. Find the list of all buildings that have employees
```sql
SELECT distinct buildings.* FROM buildings
inner join employees
on employees.Building=buildings.Building_name;
```

2. Find the list of all buildings and their capacity
```sql
SELECT distinct buildings.* FROM buildings
left join employees
on employees.Building=buildings.Building_name;
```

3. List all buildings and the distinct employee roles in each building (including empty buildings)
```sql
SELECT distinct employees.role, Building_name FROM buildings
left join employees
on employees.Building=buildings.Building_name;
```


# Exercise 8 — Tasks

1. Find the name and role of all employees who have not been assigned to a building
```sql
SELECT name, role FROM employees
left join buildings
on employees.Building=buildings.Building_name
where Building_name is null;
```

2. Find the names of the buildings that hold no employees
```sql
SELECT building_name FROM buildings
left join employees
on employees.Building=buildings.Building_name
where name is null;
```

# Exercise 9 — Tasks

1. List all movies and their combined sales in millions of dollars
```sql
SELECT title, (Domestic_sales+International_sales)/1000000 as 'millions' FROM movies
join boxoffice
on movies.Id=boxoffice.Movie_id;
```

2. List all movies and their ratings in percent
```sql
SELECT title, rating * 10
FROM movies
  JOIN boxoffice
    ON movies.id = boxoffice.movie_id;
```

3. List all movies that were released on even number years
```sql
SELECT title, year
FROM movies
WHERE year % 2 = 0;
```


# Exercise 10 — Tasks

1. Find the longest time that an employee has been at the studio
```sql
SELECT max(Years_employed) FROM employees;
```

2. For each role, find the average number of years employed by employees in that role
```sql
SELECT distinct role, name, avg(Years_employed) FROM employees
group by role;
```

3. Find the total number of employee years worked in each building
```sql
SELECT building, sum(years_employed)FROM employees
group by building;
```


# Exercise 11 — Tasks

1. Find the number of Artists in the studio (without a HAVING clause)
```sql
SELECT count(*) FROM employees
where role='Artist';
```

2. Find the number of Employees of each role in the studio
```sql
SELECT role, count(name) FROM employees
group by role;
```

3. Find the total number of years employed by all Engineers
```sql  
SELECT role, sum(Years_employed) FROM employees
where role='Engineer';
```


# Exercise 12 — Tasks

1. Find the number of movies each director has directed
```sql
SELECT Director, count(Title) FROM movies
group by director;
```

2. Find the total domestic and international sales that can be attributed to each director
```sql
SELECT Director, sum(Domestic_sales+International_sales) FROM movies
join Boxoffice
on movies.id=Boxoffice.Movie_id
group by director;
```


# Exercise 13 — Tasks

1. Add the studio's new production, Toy Story 4 to the list of movies (you can use any director)
```sql
insert into movies 
values (4, "Toy Story 4", "Si", 2020, 90);
```

2. Toy Story 4 has been released to critical acclaim! It had a rating of 8.7, and made 340 million domestically and 270 million internationally. Add the record to the BoxOffice table.
```sql
insert into boxoffice 
VALUES (4, 8.7, 340000000, 270000000);
```


# Exercise 14 — Tasks

1. The director for A Bug's Life is incorrect, it was actually directed by John Lasseter
```sql
update movies 
set director='John Lasseter'
where title="A Bug's Life";
```

2. The year that Toy Story 2 was released is incorrect, it was actually released in 1999
```sql
update movies 
set year=1999
where title='Toy Story 2';
```

3. Both the title and director for Toy Story 8 is incorrect! The title should be "Toy Story 3" and it was directed by Lee Unkrich
```sql
update movies 
set title='Toy Story 3',
director='Lee Unkrich'
where title='Toy Story 8';
```


# Exercise 15 — Tasks

1. This database is getting too big, lets remove all movies that were released before 2005.
```sql
delete from movies
where year<2005;
```

2. Andrew Stanton has also left the studio, so please remove all movies directed by him.
```sql
delete from movies
where director='Andrew Stanton';
```


# Exercise 16 — Tasks

1. Create a new table named Database with the following columns:
– Name A string (text) describing the name of the database
– Version A number (floating point) of the latest version of this database
– Download_count An integer count of the number of times this database was downloaded
This table has no constraints.
```sql
create table Database (
Name text,
Version float,
Download_count int
);
```


# Exercise 17 — Tasks

1. Add a column named Aspect_ratio with a FLOAT data type to store the aspect-ratio each movie was released in.
```sql
alter table movies
add column Aspect_ratio float;
```

2. Add another column named Language with a TEXT data type to store the language that the movie was released in. Ensure that the default for this language is English.
```sql
alter table movies
add column Language text default ('English');
```


# Exercise 18 — Tasks

1. We've sadly reached the end of our lessons, lets clean up by removing the Movies table
```sql
drop table movies;
```

2. And drop the BoxOffice table as well
```sql
drop table BoxOffice;
```
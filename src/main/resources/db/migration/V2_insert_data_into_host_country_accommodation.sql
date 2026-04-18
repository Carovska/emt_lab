INSERT INTO countries(name, continent)
VALUES  ('Brazil', 'South America'),
        ('France', 'Europe'),
        ('South Korea', 'Asia'),
        ('New Zealand', 'Australia'),
        ('Mexico', 'North America'),
        ('Egypt', 'Africa'),
        ('Italy', 'Europe'),
        ('India', 'Asia');

INSERT INTO hosts(created_at, updated_at, name, surname, country_id)
VALUES  (now(), now(), 'Maria', 'Silva', (SELECT id FROM countries WHERE name = 'Brazil')),
        (now(), now(), 'Liam', 'Smith', (SELECT id FROM countries WHERE name = 'United Kingdom')),
        (now(), now(), 'Sofia', 'Rossi', (SELECT id FROM countries WHERE name = 'Italy')),
        (now(), now(), 'Kenji', 'Tanaka', (SELECT id FROM countries WHERE name = 'Japan')),
        (now(), now(), 'Ava', 'Johnson', (SELECT id FROM countries WHERE name = 'Canada')),
        (now(), now(), 'Diego', 'Martinez', (SELECT id FROM countries WHERE name = 'Argentina')),
        (now(), now(), 'Nina', 'Müller', (SELECT id FROM countries WHERE name = 'Germany')),
        (now(), now(), 'Anika', 'Patel', (SELECT id FROM countries WHERE name = 'India'));


INSERT INTO accommodations(created_at, updated_at, name, category, host_id, num_rooms)
VALUES  (now(), now(), 'Ocean Breeze Villa', 'HOUSE', (SELECT id FROM hosts WHERE name = 'Maria'), 5),
        (now(), now(), 'Mountain View Inn', 'MOTEL', (SELECT id FROM hosts WHERE name = 'Liam'), 8),
        (now(), now(), 'City Lights Hotel', 'HOTEL', (SELECT id FROM hosts WHERE name = 'Sofia'), 25),
        (now(), now(), 'Forest Cabin', 'HOUSE', (SELECT id FROM hosts WHERE name = 'Kenji'), 3),
        (now(), now(), 'Lakeside Flat', 'FLAT', (SELECT id FROM hosts WHERE name = 'Ava'), 4),
        (now(), now(), 'Sunny Apartments', 'APARTMENT', (SELECT id FROM hosts WHERE name = 'Diego'), 6),
        (now(), now(), 'Riverbank Lodge', 'ROOM', (SELECT id FROM hosts WHERE name = 'Nina'), 2),
        (now(), now(), 'City Center Loft', 'APARTMENT', (SELECT id FROM hosts WHERE name = 'Anika'), 3);


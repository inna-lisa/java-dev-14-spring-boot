INSERT INTO users(username, password, enabled)
VALUES
    ('user', '$2a$10$MC2OSbuBwjMKFWhUYK/G6ex78KrPdpIHppHHQgfMJVbjCYsz9YaXi', true),  // jdbcDefault
    ('admin', '$2a$10$ixtiwXWaPV9vN.dlSTXVZu0TAE9UUs8sfG/S2eggzqfXKmCHKhFEm', true);   // jdbcAdmin

INSERT INTO authorities(username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');
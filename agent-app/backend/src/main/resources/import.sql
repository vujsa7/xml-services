insert into role (id, name) values ('2273ea92-dad3-11ec-9d64-0242ac120002', 'ROLE_USER');
insert into role (id, name) values ('3d89303a-dad3-11ec-9d64-0242ac120002', 'ROLE_ADMIN');
insert into role (id, name) values ('4492ab54-dad3-11ec-9d64-0242ac120002', 'ROLE_COMPANY_OWNER');
insert into users (id, email, password, role_id, is_enabled, is_deleted) values ('58b17b60-dad3-11ec-9d64-0242ac120002', 'admin@gmail.com', '$2a$10$t5B4Vu20.u//zjDP2IU4kOR49tqzbUo9WRVQ50rV1Og3FxBsioG2C', '3d89303a-dad3-11ec-9d64-0242ac120002', true, false);
insert into users (id, email, password, role_id, is_enabled, is_deleted) values ('b6588e23-c3ac-45c5-b7de-35cf173d065a', 'user@gmail.com', '$2a$10$t5B4Vu20.u//zjDP2IU4kOR49tqzbUo9WRVQ50rV1Og3FxBsioG2C', '2273ea92-dad3-11ec-9d64-0242ac120002', true, false);
insert into users (id, email, password, role_id, is_enabled, is_deleted) values ('a05038f5-4f38-4b0b-8402-abeb66ba4031', 'company-owner@gmail.com', '$2a$10$t5B4Vu20.u//zjDP2IU4kOR49tqzbUo9WRVQ50rV1Og3FxBsioG2C', '4492ab54-dad3-11ec-9d64-0242ac120002', true, false);
insert into users (id, email, password, role_id, is_enabled, is_deleted) values ('ed1ac743-41c9-49aa-9eef-4ffa5ff663c3', 'user.fishbook@gmail.com', '$2a$10$t5B4Vu20.u//zjDP2IU4kOR49tqzbUo9WRVQ50rV1Og3FxBsioG2C', '2273ea92-dad3-11ec-9d64-0242ac120002', true, false);


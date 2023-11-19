-- Insert into the category table
INSERT INTO category (category_id, category_name)
VALUES (1, 'Doors and Windows');
INSERT INTO category (category_id, category_name)
VALUES (2, 'Repairs');
INSERT INTO category (category_id, category_name)
VALUES (3, 'Gardening');

-- project 1 Build 
-- Insert into the material table
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (1, 'nails', 20, 4.99 );
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (1, "2 by 4's", 2, 5.59 );
-- Insert into the step table
INSERT INTO step (project_id, step_text, step_order)
VALUES(1, 'cut wood', 1);
INSERT INTO step (project_id, step_text, step_order)
VALUES(1, 'hammer nails', 2);
-- Insert into the project_category table
INSERT INTO project_category (project_id, category_id)
VALUES (1, 2);

-- project 2 Hang a door
-- Insert into the material table
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (2, 'Door in frame', 1, null );
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (2, 'Door hangers', 2, 5.59 );
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (2, '2-inch screws', 20, 4.99 );
-- Insert into the step table
INSERT INTO step (project_id, step_text, step_order)
VALUES(2, 'Align hangers on opening side of the door vertically on the wall', 1);
INSERT INTO step (project_id, step_text, step_order)
VALUES(2, 'Screw hangers into fram', 2);
-- Insert into the project_category table
INSERT INTO project_category (project_id, category_id)
VALUES (2, 1);
INSERT INTO project_category (project_id, category_id)
VALUES (2, 2);

-- Insert into the material table
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (3, 'soil', 1 bag, 7.99 );
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (3, "pot", 1, 5.59 );
-- Insert into the step table
INSERT INTO step (project_id, step_text, step_order)
VALUES(3, 'fill pot half way with soil.', 1);
INSERT INTO step (project_id, step_text, step_order)
VALUES(3, 'place plant in pot', 2);
INSERT INTO step (project_id, step_text, step_order)
VALUES(3, 'fill the rest of the pot with soil', 3);
-- Insert into the project_category table
INSERT INTO project_category (project_id, category_id)
VALUES (3, 3);




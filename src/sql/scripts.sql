 CREATE TABLE IF NOT EXISTS "User"(
  "id" serial PRIMARY KEY,
  "first_name" varchar,
  "last_name" varchar,
  "age" integer,
  "email" varchar,
  "password" varchar,
  "phone_number" varchar
);

CREATE TABLE IF NOT EXISTS "Role" (
  "id" serial PRIMARY KEY,
  "status" varchar,
  "description" text
);

CREATE TABLE IF NOT EXISTS "Request" (
  "id" serial PRIMARY KEY,
  "time" timestamp,
  "url" varchar
);

CREATE TABLE IF NOT EXISTS "Request_Context" (
  "id" serial PRIMARY KEY,
  "request_id" bigint,
  "context_id" bigint
);

CREATE TABLE IF NOT EXISTS "Context" (
  "id" serial PRIMARY KEY,
  "filter" varchar,
  "category" varchar,
  "date" date
);

CREATE TABLE IF NOT EXISTS "Request_Response" (
  "id" serial PRIMARY KEY,
  "request_url" bigint,
  "response_url" bigint
);

CREATE TABLE IF NOT EXISTS "Response" (
  "id" serial PRIMARY KEY,
  "description" text,
  "graphic" text
);

CREATE TABLE IF NOT EXISTS "DataSet" (
  "id" serial PRIMARY KEY,
  "text" text,
  "image_url" varchar,
  "diagram" text,
  "label" varchar,
  "source" varchar,
  "created_att" timestamp
);

CREATE TABLE IF NOT EXISTS "Feedback" (
  "id" serial PRIMARY KEY,
  "response_id" integer,
  "user_id" integer,
  "title" varchar,
  "comment" text
);

ALTER TABLE "Context" ADD FOREIGN KEY ("id") REFERENCES "User" ("id");

ALTER TABLE "User" ADD FOREIGN KEY ("id") REFERENCES "Role" ("id");

ALTER TABLE "Request" ADD FOREIGN KEY ("id") REFERENCES "User" ("id");

ALTER TABLE "Response" ADD FOREIGN KEY ("id") REFERENCES "User" ("id");

ALTER TABLE "Feedback" ADD FOREIGN KEY ("id") REFERENCES "User" ("id");

ALTER TABLE "Request_Context" ADD FOREIGN KEY ("id") REFERENCES "Request" ("id");

ALTER TABLE "Request_Response" ADD FOREIGN KEY ("id") REFERENCES "Request" ("id");

ALTER TABLE "Request_Response" ADD FOREIGN KEY ("id") REFERENCES "Response" ("id");

ALTER TABLE "Feedback" ADD FOREIGN KEY ("id") REFERENCES "Response" ("id");

ALTER TABLE "DataSet" ADD FOREIGN KEY ("id") REFERENCES "Response" ("id");

ALTER TABLE "Request_Context" ADD FOREIGN KEY ("id") REFERENCES "Context" ("id");
